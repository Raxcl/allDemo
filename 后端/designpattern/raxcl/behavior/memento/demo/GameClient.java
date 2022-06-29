package raxcl.behavior.memento.demo;

/**
 * 游戏角色客户端
 *
 * @author D30100_chenlong
 * @date 2022/6/27 11:22
 */
public class GameClient {
    public static void main(String[] args) {
        //大战Boss前
        GameRole lixiaoyao = new GameRole();
        //获得初始角色状态
        lixiaoyao.getInitState();
        lixiaoyao.stateDisplay();

        //保存进度，通过‘游戏角色’的新实例，来保存进度
        RoleStateCaretaker stateCaretaker = new RoleStateCaretaker();
        stateCaretaker.setMemento(lixiaoyao.saveState());

        //大战Boss时，损耗严重
        lixiaoyao.fight();
        lixiaoyao.stateDisplay();

        //恢复之前状态
        lixiaoyao.recoveryState(stateCaretaker.getMemento());
        lixiaoyao.stateDisplay();

    }
}
