package cn.raxcl.basic.proxy.staticProxy;


import cn.raxcl.basic.proxy.service.SmsService;
import cn.raxcl.basic.proxy.service.SmsServiceImpl;

/**
 * @author D30100_chenlong
 * date 2022/7/18 21:11
 */
public class StaticProxyClient {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("java");
    }
}
