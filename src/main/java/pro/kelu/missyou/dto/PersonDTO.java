package pro.kelu.missyou.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import pro.kelu.missyou.validators.PasswordEqual;

import javax.validation.Valid;

@Getter
@Setter
@NoArgsConstructor
@PasswordEqual
public class PersonDTO {
    @Length(min = 2, max = 10, message = "XXXX")
    private String name;
    private int age;

//    @Valid
//    private SchoolDTO schoolDTO;

    private String password1;

    private String password2;
}
