package pro.kelu.missyou.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;

//@Data
@Getter
@Setter
public class PersonDTO {
    @Length(min = 2, max = 10, message = "xxxx")
    private String name;
    private Integer age;

    @Valid
    private SchoolDTO schoolDTO;

}
