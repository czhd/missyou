package pro.kelu.missyou.vo;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @param <T> 源
 * @param <K> 目标
 */
public class PagingDozer<T, K> extends Paging {
    @SuppressWarnings("unchecked")
    public PagingDozer(Page<T> page, Class<K> kClass) {
        this.initPageParameters(page);

        List<T> tList = page.getContent();
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        List<K> kList = new ArrayList<>();
        tList.forEach(t -> {
            K k = mapper.map(t, kClass);
            kList.add(k);
        });
        this.setItems(kList);
    }
}
