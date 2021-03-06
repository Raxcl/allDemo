package raxcl.behavior.responsibilitychain.demo;

/**
 * 申请
 *
 * @author D30100_chenlong
 * @date 2022/6/29 10:53
 */
public class Request {
    //申请类别
    private String requestType;
    //申请内容
    private String requestContent;
    //数量
    private int number;

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
