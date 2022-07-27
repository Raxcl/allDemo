package cn.raxcl.basic.proxy.dynamicProxy.cglib;


/**
 * @author D30100_chenlong
 * date 2022/7/19 15:29
 */
public class CglibProxyClient {
    public static void main(String[] args) {
        //todo 框架有问题，待解决----已解决，改用jdk8
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("你好啊");
    }
}
