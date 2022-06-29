package raxcl.creation.factory.abstraction.demo;

/**
 * @author D30100_chenlong
 * @date 2022/6/17 18:32
 */
public class OracleUser implements IUser{
    @Override
    public void insert(User user) {
        System.out.println("在Oracle中给User表增加一条记录");
    }

    @Override
    public User getUser(int id) {
        System.out.println("在Oracle中根据id获取User表一条记录");
        return null;
    }
}
