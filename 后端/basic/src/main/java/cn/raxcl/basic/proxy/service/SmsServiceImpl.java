package proxy.service;

/**
 * @author D30100_chenlong
 * date 2022/7/18 21:03
 */
public class SmsServiceImpl implements SmsService{
    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
