package com.qf.ssm.utils;

import org.springframework.util.DigestUtils;

/**
 * 密码的加解密
 */
public class PasswdCodeC {

    /**
     *  密码加盐(salt)处理。
     *   123456 -> e1 0a dc 39 49 ba59abbe56e057f20f883e
     *   然后再生产16位随机字符串，abcde0123456789a
     *   e1 a 0a b dc c .....  -> 得到的长度为48位
     *   接着对48位的字符串再次md5.
     *
     *   将得到的字符串存入到数据库
     */
    public  static String encryPwd(String salt ,String password) {
        if(salt != null && salt.length() != 16){
            return null ;
        }

        String pwdMd5 = DigestUtils.md5DigestAsHex(password.getBytes());
        char[] pwdMd5CharArray = pwdMd5.toCharArray();
        char[] saltCharArray = salt.toCharArray();

        char[] newCharArray = new char[48];
        /**
         * c4 ca 42 38 a0b923820dcc509a6f75849b
         * abcde0123456789a
         * c4a cab
         * c4acab42c38da0eb902318220d3cc45059a66f77588499ba
         */
        for (int i = 0; i <16 ; i++) {
            newCharArray[i*3] = pwdMd5CharArray[i*2];
            newCharArray[i*3 + 1] = pwdMd5CharArray[i*2 + 1];
            newCharArray[i*3 + 2] = saltCharArray[i];

        }
        String newPwd = new String(newCharArray).intern();
        return DigestUtils.md5DigestAsHex(newPwd.getBytes());
    }

    public static void main(String[] args) {
        String str = "/exam/" ;
        System.out.println(str.substring(0,str.length()-1));
        String st = encryPwd("abcde0123456789a","123");
        System.out.println(st);
    }



}
