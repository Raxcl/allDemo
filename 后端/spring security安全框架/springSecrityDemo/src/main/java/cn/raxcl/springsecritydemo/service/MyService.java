package cn.raxcl.springsecritydemo.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author c-long.chan
 * @date 2022/1/21 12:56
 */
public interface MyService {
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
