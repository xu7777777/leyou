package com.leyou.auth.client;

import com.leyou.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author xu7777777
 * @date 2020/3/12 3:30 PM
 */
@FeignClient(value = "user-service")
public interface UserClient extends UserApi {
}