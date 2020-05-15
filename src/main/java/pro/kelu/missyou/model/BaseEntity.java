package pro.kelu.missyou.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class BaseEntity {
    private Date deleteTime;
    private Date createTime;
    private Date updateTime;
}
