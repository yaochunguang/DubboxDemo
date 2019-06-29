package com.company.dubbox.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.company.dubbox.service.UserService;

/**
 * @description: 实现类【注意：导入的注解类为：com.alibaba.dubbo.config.annotation.Service】
 * @author: chunguang.yao
 * @date: 2019-06-28 0:28
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getName() {
        return "Hello World";
    }
}
