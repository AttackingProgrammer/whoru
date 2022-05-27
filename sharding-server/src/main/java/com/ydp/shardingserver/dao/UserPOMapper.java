package com.ydp.shardingserver.dao;

import com.ydp.shardingserver.entity.UserPO;
import org.springframework.stereotype.Component;

@Component
public interface UserPOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserPO record);

    int insertSelective(UserPO record);

    UserPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserPO record);

    int updateByPrimaryKey(UserPO record);
}