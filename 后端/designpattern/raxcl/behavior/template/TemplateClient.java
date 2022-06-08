package raxcl.behavior.template;

/**
 * 模板方法客户端
 *
 * @author D30100_chenlong
 * @date 2022/6/8 14:07
 */
public class TemplateClient {
    public static void main(String[] args) {
        AbstractTemplate abstractTemplate;

        abstractTemplate = new ConcreteClassA();
        abstractTemplate.templateMethod();

        abstractTemplate = new ConcreteClassB();
        abstractTemplate.templateMethod();
    }
}
