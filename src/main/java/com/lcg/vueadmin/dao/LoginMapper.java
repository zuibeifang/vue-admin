package com.lcg.vueadmin.dao;

import com.lcg.vueadmin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoginMapper {
    //根据ID用户信息
    public User getUserById(long id);

    @Select ( "select userName as userName from base_user" )
/*    @Results({
       @Result(property = "userName",column = "username")
    })*/
    public List<User> tttt();
}
