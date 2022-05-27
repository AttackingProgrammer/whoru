package com.ydp.shardingserver.dao;

import com.ydp.shardingserver.entity.UserPO;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserPOMapperTest {
    @Autowired
    private UserPOMapper userPOMapper;
    @org.junit.Test
    public void deleteByPrimaryKey() {
    }

    @org.junit.Test
    public void insert() {
        UserPO po = new UserPO();
        po.setId(0L);
        po.setAge(11);
        po.setName("test");
        po.setSex("male");
        long userId = userPOMapper.insert(po);
        assert userId > 0;
    }

    @org.junit.Test
    public void insertSelective() {
    }

    @org.junit.Test
    public void selectByPrimaryKey() {
    }

    @org.junit.Test
    public void updateByPrimaryKeySelective() {
    }

    @org.junit.Test
    public void updateByPrimaryKey() {
    }
}