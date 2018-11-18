package com.yefan.dao;

import com.yefan.domain.Permission;
import com.yefan.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {

    @Select("select * from role where id in (select roleId from users_role where userId = #{id})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.yefan.dao.IPermissionDao.findPermissonByRid"))
    })
    Role findRoleByUid(String id) throws Exception;

    @Select("select * from role")
    List<Role> findAll() throws Exception;

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void addRole(Role role) throws Exception;

    @Select("select * from role where Id = #{roleId}")
    @Results(id = "roleMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = List.class, many = @Many(select = "com.yefan.dao.IPermissionDao.findPermissonByRid")),
            @Result(property = "users",column = "id",javaType = List.class,many = @Many(select = "com.yefan.dao.IUserDao.findUserByIdAndAllRole"))
    })
    Role findRoleByRid(String roleId) throws Exception;


    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findPermissions(String roleId) throws Exception;
}
