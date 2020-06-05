package pro.kelu.missyou.service;

import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Spu> getLastPagingSpu() {
        return spuRepository.findAll();
    }
}
