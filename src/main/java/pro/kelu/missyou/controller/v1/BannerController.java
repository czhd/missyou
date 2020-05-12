package pro.kelu.missyou.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pro.kelu.missyou.dto.PersonDTO;
import pro.kelu.missyou.exception.http.NotFoundException;
import pro.kelu.missyou.sample.ISkill;

import javax.validation.constraints.Max;
import java.util.Map;

@RestController
@RequestMapping("/v1/banner")
@Validated
public class BannerController {

    @Autowired
    private ISkill ISkill;

    @PostMapping("/test/{id}")
    public String index(@PathVariable @Max(value = 10, message = "超出范围了哦") Integer id,
                        @RequestParam String name, Integer age,
                        @RequestBody @Validated PersonDTO person) {
        ISkill.r();
        throw new RuntimeException("哈哈");
//        return "Hello Chase & Bing !!! ~~~~";
    }
}
