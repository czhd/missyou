package pro.kelu.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
public class BannerItem extends BaseEntity{
    @Id
    private long id;
    private long bannerId;
    private String name;
    private String img;
    private byte type;
    private String keyword;
    private String description;



}
