package com.lcg.vueadmin.service;

import com.lcg.vueadmin.entity.User;

public interface LoginService {
   public User getByUserId(long id);
}
