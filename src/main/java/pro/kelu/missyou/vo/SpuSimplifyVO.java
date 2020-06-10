package pro.kelu.missyou.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpuSimplifyVO {
    private long id;
    private String title;
    private String subtitle;
    private long sketchSpecId;
    private String price;
    private String discountPrice;
    private String img;
    private String description;
    private String tags;
    private String forThemeImg;
}
