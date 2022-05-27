package com.ydp.shardingserver.service;

import com.ydp.shardingserver.entity.UserPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 *
 * @ClassName UserService
 * @Author ydp
 * @Version
 * @Date 2021/12/6
 */
public interface UserService {
    static Logger logger = LoggerFactory.getLogger(UserService.class);

    long saveUser(String name, int age, String sex);

    List<UserPO> listUserBySex(String sex);
}
