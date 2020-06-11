package pro.kelu.missyou.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pro.kelu.missyou.model.Spu;
import pro.kelu.missyou.service.SpuService;

public interface SpuRepository extends JpaRepository<Spu, Long> {
    Spu findOneById(long id);

    Spu findByCategoryIdOrderByCreateTime(long cid, Pageable pageable);

    Spu findByRootCategoryIdOrderByCreateTime(long cid, Pageable pageable);
}
