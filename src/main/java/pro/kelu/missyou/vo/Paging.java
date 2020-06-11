package pro.kelu.missyou.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Paging<T> {
    private long total;
    private int page;
    private int count;
    private int totalPage;
    private List<T> items;

    public Paging(Page<T> page) {
        this.initPageParameters(page);
        this.items = page.getContent();
    }

    void initPageParameters(Page<T> page) {
        this.total = page.getTotalElements();
        this.page = page.getNumber();
        this.count = page.getSize();
        this.totalPage = page.getTotalPages();
    }
}
