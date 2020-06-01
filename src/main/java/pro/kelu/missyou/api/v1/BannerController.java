package pro.kelu.missyou.api.v1;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pro.kelu.missyou.dto.PersonDTO;
import pro.kelu.missyou.exception.http.NotFoundException;

@RestController
@RequestMapping("/banner")
@Validated
public class BannerController {

    @PostMapping("name/{id}")
    public PersonDTO getByName(@PathVariable @Range(min = 1, max = 10, message = "长度在1~10哦") Integer id,
                            @RequestParam @Length(min = 8) String name,
                            @RequestBody @Validated PersonDTO person) {

//        PersonDTO personDTO = new PersonDTO();
////        personDTO.getAge();
        return person;
    }
}
