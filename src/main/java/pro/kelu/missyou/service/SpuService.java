package pro.kelu.missyou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pro.kelu.missyou.exception.http.NotFoundException;
import pro.kelu.missyou.model.Spu;
import pro.kelu.missyou.repository.SpuRepository;

import java.util.List;

@Service
public class SpuService {
    @Autowired
    private SpuRepository spuRepository;

    public Spu getById(long id) {
        return spuRepository.findOneById(id);
    }

    public Page<Spu> getLastPagingSpu(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createTime").descending());
        return spuRepository.findAll(pageable);
    }

    public Page<Spu> getByCategory(long cid, boolean isRoot, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        if (isRoot) {
            return (Page<Spu>) spuRepository.findByRootCategoryIdOrderByCreateTime(cid, pageable);
        } else {
            return (Page<Spu>) spuRepository.findByCategoryIdOrderByCreateTime(cid, pageable);
        }
    }
}
