package raxcl.creation.factory.abstraction.demo;

/**
 * MysqlFactory类，实现IFactory接口，实例化MysqlUser
 * @author D30100_chenlong
 * @date 2022/6/17 18:40
 */
public class OracleFactory implements IFactory{
    @Override
    public IUser createUser() {
        return new OracleUser();
    }

    @Override
    public IDepartment createDepartment() {
        return new OracleDepartment();
    }
}
