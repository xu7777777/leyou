package com.leyou.search.client;

import com.leyou.item.api.BrandApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author XuQiaoYang
 * @Date 2020/2/16 14:15
 */
@FeignClient(value = "item-service")
public interface BrandClient extends BrandApi {
}
