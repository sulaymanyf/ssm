package com.yefan.service;

import com.yefan.domain.Permission;
import com.yefan.domain.Role;

import java.util.List;

public interface IRolesService {

    List<Role> findAll() throws Exception;

    void addRole(Role role) throws Exception;

    Role findRoleByRid(String roleId) throws Exception;

    Role findById(String roleId) throws Exception;

    List<Permission> findPermissions(String roleId) throws Exception;
}
