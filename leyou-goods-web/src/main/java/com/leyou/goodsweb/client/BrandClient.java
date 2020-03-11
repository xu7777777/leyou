package com.leyou.goodsweb.client;

import com.leyou.item.api.BrandApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author xu7777777
 * @date 2020/3/11 5:40 PM
 */
@FeignClient("item-service")
public interface BrandClient extends BrandApi {
}