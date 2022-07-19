package proxy.dynamicProxy.jdk;

import proxy.service.SmsService;
import proxy.service.SmsServiceImpl;

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
