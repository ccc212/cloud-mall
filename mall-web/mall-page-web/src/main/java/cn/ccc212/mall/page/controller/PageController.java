package cn.ccc212.mall.page.controller;

import cn.ccc212.mall.page.service.PageService;
import cn.ccc212.mall.util.RespResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/page")
@RequiredArgsConstructor
public class PageController {

    private final PageService pageService;

    @GetMapping(value = "/{id:[0-9]+}")
    @ResponseBody
    public RespResult<?> generateHtml(@PathVariable(value = "id") String spuId) {
        pageService.generateHtml(spuId);
        return RespResult.ok();
    }

    @GetMapping(value = "/view/{id}")
    public String viewPage(@PathVariable(value = "id") String spuId) {
        return "redirect:/page/" + spuId + ".html";
    }
}