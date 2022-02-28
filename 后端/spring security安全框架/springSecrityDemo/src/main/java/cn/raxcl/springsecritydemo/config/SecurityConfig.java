package cn.raxcl.springsecritydemo.config;

import cn.raxcl.springsecritydemo.handle.MyAccessDeniedHandler;
import cn.raxcl.springsecritydemo.handle.MyAuthenticationSuccessHandler;
import cn.raxcl.springsecritydemo.handle.MyAuthticationFailureHandler;
import cn.raxcl.springsecritydemo.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * 生成一个 BCryptPasswordEncoder 对象
 * 作用： ？？？
 * @author c-long.chan
 * @date 2022/1/18 12:02
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private PersistentTokenRepository persistentTokenRepository;

    /**
     * 自定义登录页面
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("执行了configure方法");
        http.formLogin()
                .loginProcessingUrl("/login")
//                .loginPage("/login.html ")
                .loginPage("/showLogin")
                //必须是post请求
                .successForwardUrl("/toMain")
                //登录成功处理器，不能和successForwardUrl共用
//                .successHandler(new MyAuthenticationSuccessHandler("http://www.baidu.com"))
                //失败后跳转页面
                .failureForwardUrl("/toError");
//                        .failureHandler(new MyAuthticationFailureHandler("/error.html"));
        //授权认证
        http.authorizeRequests()
                //login.html不需要被认证
//                .antMatchers("/login.html").permitAll()
                .antMatchers("/login.html").permitAll()
                .antMatchers("/showLogin").permitAll()
//                .antMatchers("/main1.html").hasAuthority("adminD")
//                .antMatchers("/main1.html").hasRole("abd")
                //所有请求都必须被认证，必须登录之后被访问
                .anyRequest().authenticated();
//                .anyRequest().access("@myServiceImpl.hasPermission(request,authentication)");

        //关闭csrf防护
//        http.csrf().disable();

        //异常处理
        http.exceptionHandling().accessDeniedHandler(myAccessDeniedHandler);

        //记住我
        http.rememberMe()
                //失效时间，单位秒
                .tokenValiditySeconds(60)
                //自定义登录逻辑
                .userDetailsService(userDetailsService)
                //持久层对象
                .tokenRepository(persistentTokenRepository);

        //退出功能
        http.logout()
                .logoutUrl("/logout")
                //退出登录跳转页面
                .logoutSuccessUrl("/login.html");

    }

    @Bean
    public PasswordEncoder getPw(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository getPersistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        //自动建表，第一次启动时候需要，第二次启动注释掉
//        jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }
}
