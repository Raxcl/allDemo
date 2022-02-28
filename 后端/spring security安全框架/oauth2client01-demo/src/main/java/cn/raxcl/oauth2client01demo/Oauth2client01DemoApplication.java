package cn.raxcl.oauth2client01demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
//开启单点登录功能
@EnableOAuth2Sso
public class Oauth2client01DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2client01DemoApplication.class, args);
    }

}
