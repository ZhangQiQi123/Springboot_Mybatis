package com.zqq.service.impl;

import com.zqq.mapper.GrayrouteInfoMapper;
import com.zqq.model.GrayrouteInfo;
import com.zqq.service.GrayrouteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/11/27 13:34
 * @Description: com.zqq.service.impl
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
@Service("grayrouteInfoService")
public class GrayrouteInfoServiceImpl implements GrayrouteInfoService{
    @Autowired
    private GrayrouteInfoMapper grayrouteInfoMapper;


    @Override
    public int insert(GrayrouteInfo grayrouteInfo) throws Exception {
        return grayrouteInfoMapper.insert(grayrouteInfo);
    }
}
