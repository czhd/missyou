package pro.kelu.missyou.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "banner")
public class Banner {
    @Id
    //自增长
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(length = 20)
    private String name;
    private String img;
    private String description;

    //关系一对多
    @OneToMany(mappedBy = "banner", fetch = FetchType.EAGER)
    private List<BannerItem> items;
}
