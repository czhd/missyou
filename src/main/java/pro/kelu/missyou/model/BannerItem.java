package pro.kelu.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class BannerItem extends BaseEntity {
    @Id
    private long id;
    private long bannerId;
    private String name;
    private String img;
    private Short type;
    private String keyword;
    private String description;


}
