package raxcl.behavior.interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author D30100_chenlong
 * @date 2022/6/30 15:07
 */
public class InterpreterClient {
    public static void main(String[] args) {
        Context context = new Context();
        List<AbstractExpression> list = new ArrayList<>();
        list.add(new TerminalExpression());
        list.add(new NoterminalExpression());
        list.add(new TerminalExpression());
        list.add(new TerminalExpression());

        for (AbstractExpression exp: list){
            exp.interpret(context);
        }
    }
}
