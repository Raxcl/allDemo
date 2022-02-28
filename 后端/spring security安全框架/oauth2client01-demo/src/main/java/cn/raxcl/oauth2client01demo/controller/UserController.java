package cn.raxcl.oauth2client01demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author c-long.chan
 * @date 2022/1/27 17:24
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 获取当前用户信息
     * @param authentication
     * @return
     */
    @RequestMapping("getCurrentUser")
    public Object getCurrentUser(Authentication authentication){
        return authentication;
    }

}
