package cn.ccc212.mall.canal.listener;

import cn.ccc212.mall.goods.feign.SkuFeign;
import cn.ccc212.mall.goods.model.AdItems;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;

@CanalTable("ad_items")
@Component
@RequiredArgsConstructor
@Slf4j
public class AdItemsHandler implements EntryHandler<AdItems> {

    private final SkuFeign skuFeign;

    @Override
    public void insert(AdItems adItems) {
        log.debug("insert aditem:{}", adItems);
        // 重新加载缓存
        this.skuFeign.updateTypeItems(adItems.getType());

    }

    @Override
    public void update(AdItems before, AdItems after) {
        log.debug("update aditem before:{}", before);
        log.debug("update aditem after:{}", after);

        if (before.getType() != null &&
                before.getType().intValue() != after.getType().intValue()) {
            // 重新加载变更前分类的Id对应的推广产品
            this.skuFeign.updateTypeItems(before.getType());
        }

        // 重新加载缓存
        this.skuFeign.updateTypeItems(after.getType());
    }

    @Override
    public void delete(AdItems adItems) {
        log.debug("delete aditem:{}", adItems);
        this.skuFeign.deleteTypeItems(adItems.getType());
    }
}