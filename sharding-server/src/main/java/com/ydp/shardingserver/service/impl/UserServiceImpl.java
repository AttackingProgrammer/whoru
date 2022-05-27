package com.ydp.shardingserver.service.impl;

import com.ydp.shardingserver.dao.UserPOExtendMapper;
import com.ydp.shardingserver.dao.UserPOMapper;
import com.ydp.shardingserver.entity.UserPO;
import com.ydp.shardingserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Author ydp
 * @Version
 * @Date 2021/12/6
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserPOMapper userPOMapper;
    @Autowired
    private UserPOExtendMapper userPOExtendMapper;
    @Override
    @Transactional()
    public long saveUser(String name, int age, String sex) {
        UserPO user = new UserPO();
        user.setId(0L);
        user.setName(name);
        user.setAge(age);
        user.setSex(sex);
        int save = userPOMapper.insertSelective(user);
        logger.info("saveUser save={}, user={}", save, user);
        return save > 0 ? user.getId() : -1;
    }

    @Override
    public List<UserPO> listUserBySex(String sex) {
        return userPOExtendMapper.selectBySex(sex);
    }

}
