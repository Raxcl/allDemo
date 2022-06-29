package raxcl.creation.factory.abstraction.demo;

/**
 * IFactory接口，定义一个创建访问User表对象的抽象的工厂接口。
 * @author D30100_chenlong
 * @date 2022/6/17 18:38
 */
public interface IFactory {
    IUser createUser();
    IDepartment createDepartment();
}
