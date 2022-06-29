package raxcl.structure.adapter.demo;

/**
 * 球赛客户端
 *
 * @author D30100_chenlong
 * @date 2022/6/21 13:49
 */
public class PlayerClient {
    public static void main(String[] args) {
        Player b = new Forwards("妲己");
        b.attack();
        Player m = new Forwards("安琪拉");
        m.attack();
        Player ym = new Translator("王昭君");
        ym.attack();
        ym.defense();


    }
}
