package cn.ccc212.mall.canal.listener;

import cn.ccc212.mall.goods.enums.AuditStatusEnum;
import cn.ccc212.mall.goods.model.Sku;
import cn.ccc212.mall.page.feign.PageFeign;
import cn.ccc212.mall.search.feign.SkuSearchFeign;
import cn.ccc212.mall.search.model.SkuEs;
import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;

@CanalTable("sku")
@Component
@RequiredArgsConstructor
@Slf4j
public class SkuHandler implements EntryHandler<Sku> {

    private final SkuSearchFeign skuSearchFeign;
    private final PageFeign pageFeign;

    @Override
    public void insert(Sku sku) {
        log.debug("insert sku:{}", sku);
        if (sku.getStatus().intValue() == AuditStatusEnum.AUDIT.getCode()) {
            skuSearchFeign.add(BeanUtil.copyProperties(sku, SkuEs.class));
        }
        pageFeign.generateHtml(sku.getSpuId());
    }

    @Override
    public void update(Sku before, Sku after) {
        log.debug("update sku before:{}", before);
        log.debug("update sku after:{}", after);
        String id = after.getId();
        if (after.getStatus() != null && id != null &&
                (after.getStatus().intValue() == AuditStatusEnum.AUDIT_NOT_PASS.getCode() ||
                        after.getStatus().intValue() == AuditStatusEnum.NOT_AUDIT.getCode())
        ) {
            skuSearchFeign.delete(id);
        } else {
            skuSearchFeign.add(BeanUtil.copyProperties(after, SkuEs.class));
        }
        pageFeign.generateHtml(after.getSpuId());
    }

    @Override
    public void delete(Sku sku) {
        log.debug("delete sku:{}", sku);
        String id = sku.getId();
        if (id != null) {
            skuSearchFeign.delete(id);
        }
    }
}