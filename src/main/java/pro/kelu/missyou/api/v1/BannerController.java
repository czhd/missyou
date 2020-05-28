package pro.kelu.missyou.api.v1;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.kelu.missyou.exception.http.NotFoundException;

@RestController
@RequestMapping("/banner")
@Validated
public class BannerController {
    @GetMapping("test")
    public void test() {
        throw new NotFoundException(10001);
//        throw new RuntimeException("这里错了");
    }

    @GetMapping("name/{name}")
    public String getByName(@PathVariable String name) {
        return "Hello Chase!";
    }
}
