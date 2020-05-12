package pro.kelu.missyou.api.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pro.kelu.missyou.dto.PersonDTO;
import pro.kelu.missyou.sample.ISkill;
import pro.kelu.missyou.service.BannerService;

import javax.validation.constraints.Max;

@RestController
@RequestMapping("/v1/banner")
@Validated
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("name/{name}")
    public void getByName(@PathVariable String name) {

    }
}