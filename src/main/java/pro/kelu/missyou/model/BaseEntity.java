package pro.kelu.missyou.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @JsonIgnore
    private Timestamp deleteTime;
    @JsonIgnore
    private Timestamp createTime;
    @JsonIgnore
    private Timestamp updateTime;
}
