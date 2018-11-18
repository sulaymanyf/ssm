package com.yefan.service;

import com.yefan.domain.Permission;

import java.util.List;

public interface IPermissionService {
    List<Permission> findAll() throws Exception;

    void addPermission(Permission permission) throws Exception;
}
