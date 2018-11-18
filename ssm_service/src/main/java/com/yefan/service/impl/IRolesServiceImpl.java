package com.yefan.service.impl;

import com.yefan.dao.IRoleDao;
import com.yefan.domain.Permission;
import com.yefan.domain.Role;
import com.yefan.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description
 * @Author xiaoqx <Yefansulayman@gmail.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/11/14
 */
@Service
@Transactional
public class IRolesServiceImpl implements IRolesService {

    @Autowired
    private IRoleDao roleDao;


    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void addRole(Role role) throws Exception {
        roleDao.addRole(role);
    }

    @Override
    public Role findRoleByRid(String roleId) throws Exception {
        return roleDao.findRoleByRid(roleId);
    }

    @Override
    public Role findById(String roleId) throws Exception {
        return roleDao.findRoleByRid(roleId);
    }

    @Override
    public List<Permission> findPermissions(String roleId) throws Exception {

        return roleDao.findPermissions(roleId);
    }
}
