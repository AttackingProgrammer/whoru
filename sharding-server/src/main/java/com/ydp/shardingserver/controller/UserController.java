package com.ydp.shardingserver.controller;

import com.ydp.shardingserver.entity.UserPO;
import com.ydp.shardingserver.respond.RespondData;
import com.ydp.shardingserver.service.UserService;
import com.ydp.shardingserver.status.StatusCodeEnum;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 用户相关操作接口
 * @ClassName UserController
 * @Author ydp
 * @Version
 * @Date 2021/7/6
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;


    @RateLimiter(name = "myLimiter", fallbackMethod = "myFallBack")
    @PostMapping("/save")
    public RespondData handle(@RequestBody Map<String, String> bodyMap) throws Exception {

        long userId = userService.saveUser(bodyMap.get("name"), Integer.parseInt(bodyMap.get("age")), bodyMap.get("sex"));
        RespondData<Long> res;
        if (userId > 0) {
            res = new RespondData<>(StatusCodeEnum.success, "save successfully", userId);
        } else {
            res = new RespondData<>(StatusCodeEnum.save_fail, "save failed");
        }
        return res;
    }

    public RespondData myFallBack(@RequestBody Map<String, String> bodyMap, Throwable throwable) {
        return new RespondData(StatusCodeEnum.rate_limit, "rate limit");
    }
    @PostMapping("/users_by_sex")
    public RespondData ListUsersBySex(@RequestBody Map<String, String> bodyMap) throws Exception {

        String sex = bodyMap.getOrDefault("sex", "");
        List<UserPO> list = userService.listUserBySex(sex);
        RespondData res;
        if (list != null && !list.isEmpty()) {
            res = new RespondData<>(StatusCodeEnum.success, "query successfully", list);
        } else {
            res = new RespondData<>(StatusCodeEnum.query_fail, "query failed");
        }
        return res;
    }
}