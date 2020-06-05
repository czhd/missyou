package pro.kelu.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
public class SpuDetailImg extends BaseEntity{
    @Id
    private long id;
    private String img;
    private long spuId;
    private long index;

}
