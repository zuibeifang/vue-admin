package com.lcg.vueadmin.service;

import com.lcg.vueadmin.dao.LoginMapper;
import com.lcg.vueadmin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User getByUserId(long id) {
        return loginMapper.getUserById ( id );
    }
}
