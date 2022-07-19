package cn.raxcl.basic.proxy.dynamicProxy.cglib;


/**
 * @author D30100_chenlong
 * date 2022/7/18 21:03
 */
public class AliSmsService{

    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
