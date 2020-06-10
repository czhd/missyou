package pro.kelu.missyou.api.v1;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.kelu.missyou.exception.http.NotFoundException;
import pro.kelu.missyou.model.Spu;
import pro.kelu.missyou.service.SpuService;
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
    public List<SpuSimplifyVO> getLatestSpu() {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        List<Spu> spuList = spuService.getLastPagingSpu();
        List<SpuSimplifyVO> vos = new ArrayList<>();
        spuList.forEach(spu -> {
            SpuSimplifyVO vo = mapper.map(spu, SpuSimplifyVO.class);
            vos.add(vo);
        });
        return vos;
    }
}
