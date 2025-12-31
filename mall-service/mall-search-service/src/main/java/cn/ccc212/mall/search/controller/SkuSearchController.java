package cn.ccc212.mall.search.controller;

import cn.ccc212.mall.search.model.SkuEs;
import cn.ccc212.mall.search.model.vo.SearchVO;
import cn.ccc212.mall.search.service.ISkuSearchService;
import cn.ccc212.mall.util.RespResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SkuSearchController {

    private final ISkuSearchService skuSearchService;

    @PostMapping("/add")
    public RespResult<?> add(@RequestBody SkuEs skuEs) {
        skuSearchService.add(skuEs);
        return RespResult.ok();
    }

    @DeleteMapping("/del/{id}")
    public RespResult<?> delete(@PathVariable("id") String id) {
        skuSearchService.delete(id);
        return RespResult.ok();
    }

    @GetMapping
    public RespResult<SearchVO> search(@RequestParam(required = false) String keywords) {
        return RespResult.ok(skuSearchService.searchData(keywords));
    }
}