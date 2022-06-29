package raxcl.creation.factory.abstraction.demo;

/**
 * @author D30100_chenlong
 * @date 2022/6/17 18:54
 */
public class OracleDepartment implements IDepartment{
    @Override
    public void insert(Department department) {
        System.out.println("在oracle中给Department表增加一条记录");
    }

    @Override
    public Department getDepartment(int id) {
        System.out.println("在oracle中根据id得到Department表一条记录");
        return null;
    }
}
