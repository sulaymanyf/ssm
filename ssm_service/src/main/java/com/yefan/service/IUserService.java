package com.yefan.service;

import com.yefan.domain.Role;
import com.yefan.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Description
 * @Author xiaoqx <Yefansulayman@gmail.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/11/12
 */

public interface IUserService extends UserDetailsService{

    List<UserInfo> findAll() throws Exception;

    void addUser(UserInfo user) throws Exception;

    UserInfo findUserById(String userId) throws Exception;

    List<Role> findOtherRolesById(String userId) throws Exception;
}
