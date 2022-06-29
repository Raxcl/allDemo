package raxcl.behavior.command;

/**
 * Invoker类，要求该命令执行这个请求。
 * @author D30100_chenlong
 * @date 2022/6/29 10:23
 */
public class Invoker {
    private Command command;

    public void setComponent(Command command){
        this.command = command;
    }

    public void excuteCommand(){
        command.excute();
    }
}
