package pro.kelu.missyou.api.v1;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import pro.kelu.missyou.bo.PageCounter;
import pro.kelu.missyou.exception.http.NotFoundException;
import pro.kelu.missyou.model.Spu;
import pro.kelu.missyou.service.SpuService;
import pro.kelu.missyou.util.CommonUtil;
import pro.kelu.missyou.vo.PagingDozer;
import pro.kelu.missyou.vo.SpuSimplifyVO;

import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/spu")
public class SpuController {
    @Autowired
    private SpuService spuService;

    @GetMapping("/id/{id}/detail")
    public Spu getDetail(@PathVariable @Positive long id) {
        Spu spu = spuService.getById(id);
        if (spu == null) {
            throw new NotFoundException(30003);
        }
        return spu;
    }

    @GetMapping("/latest")
    public PagingDozer<Spu, SpuSimplifyVO> getLatestSpu(@RequestParam(defaultValue = "0") int start,
                                            @RequestParam(defaultValue = "20") int count) {
        PageCounter pageCounter = CommonUtil.convertToPageParameter(start, count);
        Page<Spu> pagingSpu = spuService.getLastPagingSpu(pageCounter.getPage(), pageCounter.getCount());
        return new PagingDozer<>(pagingSpu, SpuSimplifyVO.class);
    }

    @GetMapping("/by/category/{id}")
    public PagingDozer<Spu, SpuSimplifyVO> getByCategoryId(@PathVariable @Positive long id,
                                @RequestParam(name = "is_root") boolean isRoot,
                                @RequestParam(name = "start", defaultValue = "0") int start,
                                @RequestParam(name = "count", defaultValue = "20") int count) {
        PageCounter pageCounter = CommonUtil.convertToPageParameter(start, count);
        Page<Spu> pageSpu = spuService.getByCategory(id, isRoot, pageCounter.getPage(), pageCounter.getCount());
        return new PagingDozer<>(pageSpu, SpuSimplifyVO.class);
    }
}



