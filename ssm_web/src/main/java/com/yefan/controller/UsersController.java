package com.yefan.controller;

import com.yefan.domain.Role;
import com.yefan.domain.UserInfo;
import com.yefan.service.IUserService;
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
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfoList =  iUserService.findAll();
        mv.addObject("userList",userInfoList);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/addUser.do")
    public String addUser(UserInfo user) throws Exception {
        iUserService.addUser(user);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findUserById.do")
    public ModelAndView findUserById(@RequestParam(name = "id", required = true) String userId) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = iUserService.findUserById(userId);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) String userId) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo user = iUserService.findUserById(userId);
        List<Role> roleList= iUserService.findOtherRolesById(userId);

        mv.setViewName("user-role-add");
        return mv;
    }


}
