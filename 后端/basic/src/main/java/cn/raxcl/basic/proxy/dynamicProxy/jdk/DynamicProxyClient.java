package cn.raxcl.basic.proxy.dynamicProxy.jdk;


import cn.raxcl.basic.proxy.service.SmsService;
import cn.raxcl.basic.proxy.service.SmsServiceImpl;

/**
 * @author D30100_chenlong
 * date 2022/7/18 21:59
 */
public class DynamicProxyClient {
    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");
    }
}
