package com.leyou.search.client;

import com.leyou.item.api.CategoryApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author XuQiaoYang
 * @Date 2020/2/16 14:16
 */
@FeignClient(value = "item-service")
public interface CategoryClient extends CategoryApi {
}
