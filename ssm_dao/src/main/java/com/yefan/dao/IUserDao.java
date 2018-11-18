package com.yefan.dao;
import com.yefan.domain.Role;
import com.yefan.domain.UserInfo;
import org.apache.ibatis.annotations.*;


import java.util.List;

public interface IUserDao {

    @Select("select * from users where username=#{username}")
    @Results( id = "userMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class, many =@Many(select = "com.yefan.dao.IRoleDao.findRoleByUid"))
    })
    UserInfo findByUsername(String username) throws Exception;

    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;


    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void addUser(UserInfo user) throws Exception;

    @Select("select * from users where id = #{userId}")
    @ResultMap("userMap")
    UserInfo findUserById(String userId) throws Exception;

    @Select("select * from role where roleId not in (select roleId from users_role where roleId=#{roleId} )")
    List<Role> findOtherRolesById(String roleId) throws Exception;
}
