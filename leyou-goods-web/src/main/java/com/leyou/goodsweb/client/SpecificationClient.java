package com.leyou.goodsweb.client;

import com.leyou.item.api.SpecificationApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author xu7777777
 * @date 2020/3/11 5:43 PM
 */
@FeignClient(value = "item-service")
public interface SpecificationClient extends SpecificationApi {
}