package com.lcg.vueadmin.entity;

import lombok.Data;

@Data
public class User extends IdEntity {
    //用户名
   private String userName;
   //密码
   private String passWord;
   //登录名
   private String loginName;

   //用户的状态 冻结，激活
   private int status;

}
