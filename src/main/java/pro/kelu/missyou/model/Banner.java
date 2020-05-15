package pro.kelu.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Banner extends BaseEntity {
    @Id
    private long id;
    private String name;
    private String title;
    private String img;
    private String description;


    @OneToMany
    @JoinColumn(name = "bannerId")
    private List<BannerItem> items;
}
