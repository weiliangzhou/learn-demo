package com.zwl.learn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwl.learn.dao.UserMapper;
import com.zwl.learn.entity.User;
import com.zwl.learn.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 二师兄
 * @since 2020-10-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
