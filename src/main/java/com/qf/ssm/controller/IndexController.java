package com.qf.ssm.controller;

import com.qf.ssm.commons.Constants;
import com.qf.ssm.commons.enums.RoleType;
import com.qf.ssm.pojo.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author dhy
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String toIndex(HttpSession session) {
        SysUser sysUser = (SysUser)session.getAttribute(Constants.USER_SESSION_KEY);

        String role = sysUser.getRole();
        if(RoleType.student.toString().equals(role)){
            return "student/index";
        }else if(RoleType.teacher.toString().equals(role)) {
            return "teacher/index" ;
        }else {
            return "redirect:/error.html";
        }

    }

}
