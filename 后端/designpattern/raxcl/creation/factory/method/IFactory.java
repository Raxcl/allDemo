package raxcl.creation.factory.method;

/**
 * 工厂接口
 *
 * @author D30100_chenlong
 * @date 2022/6/7 13:30
 */
public interface IFactory {
    public Operation createOperation();
}

class AddFactory implements IFactory {

    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }
}

class SubFactory implements IFactory {

    @Override
    public Operation createOperation() {
        return new OperationSub();
    }
}

class MulFactory implements IFactory {

    @Override
    public Operation createOperation() {
        return new OperationMul();
    }
}

class DivFactory implements IFactory {

    @Override
    public Operation createOperation() {
        return new OperationDiv();
    }
}
