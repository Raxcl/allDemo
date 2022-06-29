package raxcl.creation.factory.abstraction.demo;

/**
 * 抽象模式客户端
 *
 * @author D30100_chenlong
 * @date 2022/6/17 18:24
 */
public class AbstractClient {
    public static void main(String[] args) {
        User user = new User();
        Department department = new Department();
        IFactory factory = new MysqlFactory();
        IUser iu = factory.createUser();
        iu.insert(user);
        iu.getUser(1);
        IDepartment id = factory.createDepartment();
        id.insert(department);
        id.getDepartment(1);
    }
}