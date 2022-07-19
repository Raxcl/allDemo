package cn.raxcl.basic.proxy.staticProxy;


import cn.raxcl.basic.proxy.service.SmsService;

/**
 * 静态代理实现短信发送接口
 * @author D30100_chenlong
 * date 2022/7/18 21:05
 */
public class SmsProxy implements SmsService {

    private final SmsService smsService;

    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method send()");
        smsService.send(message);
        System.out.println("after method send()");
        return null;
    }
}
