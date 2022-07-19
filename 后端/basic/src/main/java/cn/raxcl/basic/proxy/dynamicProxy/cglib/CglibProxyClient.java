package cn.raxcl.basic.proxy.dynamicProxy.cglib;


/**
 * @author D30100_chenlong
 * date 2022/7/19 15:29
 */
public class CglibProxyClient {
    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("你好啊");
    }
}
