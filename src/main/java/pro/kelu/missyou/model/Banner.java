package pro.kelu.missyou.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Banner {
    @Id
    private long id;
    private String title;
    private String name;
    private String img;
    private String description;
}
