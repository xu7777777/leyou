package com.leyou.goodsweb.controller;

import com.leyou.goodsweb.service.GoodsHtmlService;
import com.leyou.goodsweb.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author xu7777777
 * @date 2020/3/11 5:27 PM
 */
@Controller
@RequestMapping("item")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @Resource
    private GoodsHtmlService goodsHtmlService;

    /**
     * 跳转到商品详情页
     * @param model
     * @param id
     * @return
     */
    @GetMapping("{id}.html")
    public String toItemPage(Model model, @PathVariable("id")Long id){
        // 加载所需的数据
        Map<String, Object> modelMap = this.goodsService.loadData(id);
        // 放入模型
        model.addAllAttributes(modelMap);

        // 页面静态化
        this.goodsHtmlService.asyncExcute(id);

        return "item";
    }
}