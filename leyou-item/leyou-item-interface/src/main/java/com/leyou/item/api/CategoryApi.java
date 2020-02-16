package com.leyou.item.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author XuQiaoYang
 * @Date 2020/2/16 14:10
 */
@RequestMapping("category")
public interface CategoryApi {

    /**
     * 查询商品分类名
     * @param ids
     * @return
     */
    @GetMapping("names")
    List<String> queryNamesByIds(@RequestParam("ids")List<Long> ids);
}
