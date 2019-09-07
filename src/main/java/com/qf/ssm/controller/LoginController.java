package com.qf.ssm.controller;

import com.qf.ssm.commons.Constants;
import com.qf.ssm.dao.SysUserDao;
import com.qf.ssm.pojo.SysUser;
import com.qf.ssm.service.SysUserService;
import com.qf.ssm.utils.PasswdCodeC;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class LoginController {

    @Resource
    private SysUserService sysUserService;

    /**
     * 开发中密码是不允许明文存储。
     * md5 -> 不可逆
     * 12356 -> 1;;2::3##4%%5$$6 -> 可以实现可逆
     *
     * md5不安全，彩虹表。
     *
     * 原密码   加密后的密码
     *   1         abc
     *  234       xyz
     *
     *
     */

    @RequestMapping("/login")
    public Object login(String username , String password , HttpSession session){
        SysUser sysUser = sysUserService.getSysUserByName(username);
        Map<String , Object> map = new HashMap<>();
        if(sysUser == null ) {
            map.put("code", "-1");
            map.put("msg" , "用户名或密码错误");
            return map;
        }
        String dbPassword = sysUser.getPassword();
        String salt = sysUser.getSalt();

        String cryptPwd = PasswdCodeC.encryPwd(salt,password);
        if (dbPassword.equals(cryptPwd)){
            session.setAttribute(Constants.USER_SESSION_KEY,sysUser);
            map.put("code", "1");
            map.put("msg" , "success");
        }else{
            map.put("code", "-1");
            map.put("msg" , "用户名或密码错误");
        }
        return map;
    }
}
