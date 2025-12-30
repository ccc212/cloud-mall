package cn.ccc212.mall.canal.listener;

import cn.ccc212.mall.goods.feign.SkuFeign;
import cn.ccc212.mall.goods.model.AdItems;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;

@CanalTable(value = "ad_items")
@Component
@RequiredArgsConstructor
public class AdItemsHandler implements EntryHandler<AdItems> {

    private final SkuFeign skuFeign;

    /**
     * 数据库的数据发生增加操作，会触发该方法
     */
    @Override
    public void insert(AdItems adItems) {
        System.out.println(" public void insert(AdItems adItems) 执行了:" + adItems);
        // 重新加载缓存
        this.skuFeign.updateTypeItems(adItems.getType());

    }

    /**
     * 数据库的数据发生修改操作，会触发该方法
     */
    @Override
    public void update(AdItems before, AdItems after) {
        System.out.println(" public void update" + before);
        System.out.println(" public void update" + after);

//        if (before.getType().intValue() != after.getType().intValue()) {
//            // 重新加载变更前分类的Id对应的推广产品
//            this.skuFeign.updateTypeItems(before.getType());
//        }

        // 重新加载缓存
        this.skuFeign.updateTypeItems(after.getType());
    }

    /**
     * 数据库数据发生删除操作，会触发该方法
     */
    @Override
    public void delete(AdItems adItems) {
        System.out.println("  public void delete(AdItems adItems) 执行了: " + adItems);
        this.skuFeign.deleteTypeItems(adItems.getType());
    }
}