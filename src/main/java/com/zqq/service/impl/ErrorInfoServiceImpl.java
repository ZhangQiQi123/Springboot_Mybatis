package com.zqq.service.impl;

import com.zqq.mapper.ErrorInfoMapper;
import com.zqq.model.ErrorInfo;
import com.zqq.service.ErrorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/11/27 11:49
 * @Description: com.zqq.service.impl
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
@Service("errorInfoService")
public class ErrorInfoServiceImpl implements ErrorInfoService {

    @Autowired
    private ErrorInfoMapper errorInfoMapper;

    @Override
    public int insert(ErrorInfo errorInfo) throws Exception {
        return errorInfoMapper.insert(errorInfo);
    }
}
