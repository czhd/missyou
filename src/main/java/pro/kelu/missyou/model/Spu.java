package pro.kelu.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Spu extends BaseEntity {
    @Id
    private long id;
    private long categoryId;
    private long rootCategoryId;
    private String title;
    private String subtitle;
    private long sketchSpecId;
    private long defaultSkuId;
    private String price;
    private String discountPrice;
    private String img;
    private boolean online;
    private String description;
    private String tags;
    private boolean isTest;
//    private Object spuThemeImg;
    private String forThemeImg;

    @OneToMany
    @JoinColumn(name = "spuId")
    private List<Sku> skuList;

    @OneToMany
    @JoinColumn(name = "spuId")
    private List<SpuDetailImg> spuDetailImgList;

    @OneToMany
    @JoinColumn(name = "spuId")
    private List<SpuImg> spuImgList;
}
