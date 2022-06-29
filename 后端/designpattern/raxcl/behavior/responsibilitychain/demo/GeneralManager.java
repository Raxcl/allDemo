package raxcl.behavior.responsibilitychain.demo;

/**
 * 总经理
 *
 * @author D30100_chenlong
 * @date 2022/6/29 13:38
 */
public class GeneralManager extends Manager{
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void requestApplications(Request request) {
        if (request.getRequestType()=="请假"){
            System.out.println(name+":"+request.getRequestContent()+" 数量"+request.getNumber()+" 被批准");
        }else if(request.getRequestType()=="加薪" && request.getNumber()<=500){
            System.out.println(name+":"+request.getRequestContent()+" 数量"+request.getNumber()+" 被批准");
        }else if(request.getRequestType()=="加薪" && request.getNumber()>500){
            System.out.println(name+":"+request.getRequestContent()+" 数量"+request.getNumber()+" 再说吧");
        }
    }
}
