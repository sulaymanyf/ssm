package com.yefan.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.util.Assert;

/**
 * @Description
 * @Author xiaoqx <Yefansulayman@gmail.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/11/14
 */

public class userDetilInfo implements GrantedAuthority {


    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private final String role;
    private UserInfo userInfo;

    public userDetilInfo(String role,UserInfo userInfo) {
        Assert.hasText(role, "A granted authority textual representation is required");
        this.role = role;
        this.userInfo =userInfo;
    }

    @Override
    public String getAuthority() {
        return role;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof userDetilInfo) {
            return role.equals(((userDetilInfo) obj).role);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return this.role.hashCode();
    }

    @Override
    public String toString() {
        return this.role;
    }
}
