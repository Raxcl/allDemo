package raxcl.structure.adapter.demo;

/**
 * 前锋
 *
 * @author D30100_chenlong
 * @date 2022/6/21 13:47
 */
public class Forwards extends Player{
    public Forwards(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("前锋"+name+"进攻");
    }

    @Override
    public void defense() {
        System.out.println("前锋"+name+"防守");
    }
}
