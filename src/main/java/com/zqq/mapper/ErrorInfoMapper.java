package com.zqq.mapper;

import com.zqq.model.ErrorInfo;
import org.springframework.stereotype.Repository;

/**
 * @Auther: Zhang Qi
 * @Date: 2019/11/27 11:40
 * @Description: com.zqq.mapper
 * @Email: zhang.qq@topcheer.com
 * @Version: 1.0
 */
@Repository
public interface ErrorInfoMapper {
    int insert(ErrorInfo errorInfo);
}
