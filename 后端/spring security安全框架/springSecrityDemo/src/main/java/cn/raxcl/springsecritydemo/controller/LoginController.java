package cn.raxcl.springsecritydemo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录Controller
 * @author c-long.chan
 * @date 2022-01-18 11:00:08
 */

@Controller
public class LoginController {

    @RequestMapping("login")
    public String login(){
        System.out.println("执行登录方法");
        return "redirect:main.html";
    }

//    @Secured("ROLE_abc")
    @PreAuthorize("hasRole('abc')")
    @RequestMapping("toMain")
    public String toMain(){
        System.out.println("执行成功跳转方法");
        return "redirect:main.html";
    }
    @RequestMapping("toError")
    public String toError(){
        System.out.println("执行失败跳转方法");
        return "redirect:error.html";
    }

    @RequestMapping("demo")
    public String demo(){
        return "demo";
    }

    @RequestMapping("showLogin")
    public String showLogin(){
        return "login";
    }
    
}
