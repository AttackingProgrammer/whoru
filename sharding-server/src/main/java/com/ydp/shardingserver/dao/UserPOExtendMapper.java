package com.ydp.shardingserver.dao;

import com.ydp.shardingserver.entity.UserPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserPOExtendMapper
 * @Author ydp
 * @Version
 * @Date 2022/4/26
 */
public interface UserPOExtendMapper extends UserPOMapper {

    List<UserPO> selectBySex(@Param("sex") String sex);

}
