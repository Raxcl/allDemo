package raxcl.behavior.memento.demo;

/**
 * 游戏角色类，用来存储角色的生命力，攻击力，防御力的数据。
 *
 * @author D30100_chenlong
 * @date 2022/6/27 11:11
 */
public class GameRole {
    //生命力
    private int vit;
    //攻击力
    private int atk;
    //防御力
    private int def;

    //状态显示
    public void stateDisplay(){
        System.out.println("角色当前状态：");
        System.out.println("体力:"+vit);
        System.out.println("攻击力:"+atk);
        System.out.println("防御力:"+def);
        System.out.println();
    }

    //获得初始状态
    public void getInitState(){
        //数据通常来自本机磁盘或远程数据库
        vit=100;
        atk=100;
        def=100;
     }

     //战斗
    public void fight(){
        //在与Boss大战后游戏数据损耗为零
        vit=0;
        atk=0;
        def=0;
    }

    //保存角色状态
    public RoleStateMemento saveState(){
        return new RoleStateMemento(vit,atk,def);
    }

    //恢复角色状态
    public void recoveryState(RoleStateMemento memento){
        this.vit = memento.getVit();
        this.atk = memento.getAtk();
        this.def = memento.getDef();
    }


}
