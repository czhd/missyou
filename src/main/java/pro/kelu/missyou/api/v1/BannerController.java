package pro.kelu.missyou.api.v1;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pro.kelu.missyou.dto.PersonDTO;
import pro.kelu.missyou.exception.http.NotFoundException;
import pro.kelu.missyou.model.Banner;
import pro.kelu.missyou.service.BannerService;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/banner")
@Validated
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/name/{name}")
    public Banner getByName(@PathVariable @NotBlank String name) {
        Banner banner =  bannerService.getByName(name);
        if (banner == null) {
            throw new NotFoundException(30005);
        }
        return banner;
    }
}
