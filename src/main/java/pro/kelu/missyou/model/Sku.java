package pro.kelu.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Sku extends BaseEntity{
    @Id
    private long id;
    private long spuId;
    private long categoryId;
    private long rootCategoryId;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private String img;
    private String title;
    private String code;
    private long stock;
    private boolean online;
    private String specs;


}
