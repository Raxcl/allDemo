package raxcl.structure.adapter.demo;

/**
 * 球员
 *
 * @author D30100_chenlong
 * @date 2022/6/21 13:44
 */
public abstract class Player {
    protected String name;
    public Player(String name){
        this.name = name;
    }

    //进攻和防守方法
    public abstract void attack();
    public abstract void defense();
}
