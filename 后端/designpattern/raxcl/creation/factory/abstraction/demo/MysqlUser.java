package raxcl.creation.factory.abstraction.demo;

/**
 * 用于操作User表
 * @author D30100_chenlong
 * @date 2022/6/17 18:19
 */
public class MysqlUser implements IUser{

    @Override
    public void insert(User user) {
        System.out.println("在mysql中给User表增加一条记录");
    }

    @Override
    public User getUser(int id) {
        System.out.println("在mysql中根据id得到User表一条记录");
        return null;
    }
}
