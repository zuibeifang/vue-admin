package com.lcg.dao;

import com.lcg.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
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
