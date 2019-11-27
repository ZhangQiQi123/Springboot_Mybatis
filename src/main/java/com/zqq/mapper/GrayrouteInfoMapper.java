package com.zqq.mapper;

import com.zqq.model.GrayrouteInfo;
import org.springframework.stereotype.Repository;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/11/27 13:35
 * @Description: com.zqq.mapper
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
@Repository
public interface GrayrouteInfoMapper {
    int insert(GrayrouteInfo grayrouteInfo);
}
