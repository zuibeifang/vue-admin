package com.lcg.vueadmin.web;

import com.lcg.vueadmin.dao.LoginMapper;
import com.lcg.vueadmin.entity.User;
import com.lcg.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vue")
public class LoginController {

    @Autowired
    @Qualifier(value="loginService")
    private LoginService loginService;
    @Autowired
    private LoginMapper loginMapper;


    @RequestMapping("/login")
    public List<User> login(){

       User user= loginService.getByUserId ( 1 );

       List<User> ll= loginMapper.tttt ();

       User u=new User();
        u.setId ( ll.size () );
       return ll;
    }


    @RequestMapping("/test")
    public String test(){

        return "ok";
    }

}
