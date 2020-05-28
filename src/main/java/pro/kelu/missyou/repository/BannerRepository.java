package pro.kelu.missyou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.kelu.missyou.model.Banner;

//@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {
    Banner findOneById(long id);

    Banner findOneByName(String name);
}
