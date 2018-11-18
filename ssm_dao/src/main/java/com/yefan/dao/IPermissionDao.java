package com.yefan.dao;

import com.yefan.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {

    @Select("select * from PERMISSION where id in (select permissionId from ROLE_PERMISSION where roleId = #{roleId})")
    public List<Permission> findPermissonByRid(String roleId) throws Exception;


    @Select("select * from permission ")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void addPermission(Permission permission) throws Exception;
}
