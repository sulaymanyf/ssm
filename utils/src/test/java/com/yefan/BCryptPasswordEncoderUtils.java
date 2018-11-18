package com.yefan;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Description
 * @Author xiaoqx <Yefansulayman@gmail.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/11/15
 */

public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password) {

            return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String s = BCryptPasswordEncoderUtils.encodePassword("ye123");
        System.out.println(s);
        //$2a$10$pGRP45fwsm3uMMUzOENQuu7M7GKQqa3Gog/Eyo9Wr9uc4wN1VHQdC
    }
}
