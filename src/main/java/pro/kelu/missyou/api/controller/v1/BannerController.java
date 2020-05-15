package pro.kelu.missyou.api.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pro.kelu.missyou.model.Banner;
import pro.kelu.missyou.service.BannerService;

@RestController
@RequestMapping("/v1/banner")
@Validated
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("name/{name}")
    public Banner getByName(@PathVariable String name) {
        Banner banner = bannerService.getByName(name);
        return banner;
    }
}
