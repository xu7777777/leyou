package com.leyou.goodsweb.client;

import com.leyou.item.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author xu7777777
 * @date 2020/3/11 5:41 PM
 */
@FeignClient("item-service")
public interface GoodsClient extends GoodsApi {
}
