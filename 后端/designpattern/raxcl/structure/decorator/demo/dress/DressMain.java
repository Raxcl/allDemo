package raxcl.structure.decorator.demo.dress;

/**
 * @author D30100_chenlong
 * @date 2022/5/31 17:35
 */
public class DressMain {
    public static void main(String[] args) {
        Person xc = new Person("小菜");
        System.out.println("第一种装扮");

        BigTrouser kk = new BigTrouser();
        TShirts dtx = new TShirts();

        kk.decorate(xc);
        dtx.decorate(kk);
        dtx.show();
    }
}
