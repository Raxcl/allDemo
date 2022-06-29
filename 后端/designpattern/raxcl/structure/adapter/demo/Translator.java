package raxcl.structure.adapter.demo;

/**
 * 翻译者
 *
 * @author D30100_chenlong
 * @date 2022/6/21 13:56
 */
public class Translator extends Player{
    private Wangzhaojun wzj = new Wangzhaojun();

    public Translator(String name) {
        super(name);
        wzj.name = name;
    }

    @Override
    public void attack() {
        wzj.进攻();
    }

    @Override
    public void defense() {
        wzj.防守();
    }
}
