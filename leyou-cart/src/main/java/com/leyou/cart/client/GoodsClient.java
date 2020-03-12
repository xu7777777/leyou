package com.leyou.cart.client;

import com.leyou.item.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author xu7777777
 * @date 2020/3/12 9:20 PM
 */
@FeignClient("item-service")
public interface GoodsClient extends GoodsApi {
}