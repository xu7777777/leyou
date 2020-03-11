import com.leyou.LeyouItemApplication;
import com.leyou.item.mapper.SkuMapper;
import com.leyou.item.pojo.Sku;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xu7777777
 * @date 2020/3/10 10:03 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LeyouItemApplication.class)
public class ChangeDB {
    @Resource
    private SkuMapper skuMapper;

    @Test
    public void test(){
        List<Sku> skus = skuMapper.selectAll();

        skus.forEach(sku -> {
            sku.setImages(sku.getImages().replace("image.leyou.com", "106.54.86.212"));
            skuMapper.updateByPrimaryKey(sku);
        });
    }
}
