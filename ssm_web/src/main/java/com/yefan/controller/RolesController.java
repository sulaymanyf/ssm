package com.yefan.controller;

import com.yefan.domain.Permission;
import com.yefan.domain.Role;
import com.yefan.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description
 * @Author xiaoqx <Yefansulayman@gmail.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/11/14
 */
@Controller
@RequestMapping("/role")
public class RolesController {
    @Autowired
    private IRolesService rolesService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList =  rolesService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/roleAdd")
    public String addRole(Role role) throws Exception {
        rolesService.addRole(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findRoleByRid.do")
    public ModelAndView findRoleByRid(@RequestParam(name = "id", required = true) String roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role =  rolesService.findRoleByRid(roleId);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }

    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) String RoleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = rolesService.findById(RoleId);
        List<Permission> permissionList = rolesService.findPermissions(RoleId);
        mv.addObject("role",role);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }

}
