package pro.kelu.missyou.service;

import org.springframework.stereotype.Service;
import pro.kelu.missyou.model.Banner;

public interface BannerService {
    Banner getByName(String name);
}
