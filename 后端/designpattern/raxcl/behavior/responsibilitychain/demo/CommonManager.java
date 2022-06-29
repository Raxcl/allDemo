package raxcl.behavior.responsibilitychain.demo;

/**
 * 经理
 *
 * @author D30100_chenlong
 * @date 2022/6/29 13:33
 */
public class CommonManager extends Manager{
    public CommonManager(String name) {
        super(name);
    }

    @Override
    public void requestApplications(Request request) {
            if (request.getRequestType()=="请假" && request.getNumber()<=2){
                System.out.println(name+":"+request.getRequestContent()+" 数量"+request.getNumber()+" 被批准");
            }else if(superior !=null){
                //其余的申请都需转到上级
                superior.requestApplications(request);
            }
    }
}
