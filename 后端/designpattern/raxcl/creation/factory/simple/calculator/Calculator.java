package raxcl.creation.factory.simple.calculator;

import java.util.Scanner;

/**
 * 输入两数和运算符号，返回结果  简单工厂模式
 * start 12:00
 * @author D30100_chenlong
 * @date 2022/4/6 11:58
 */
public class Calculator {

    public static void main(String[] args){
        Operation operation;
        char oper='+';
        operation = OperationFactory.createOperation(oper);
        operation.numberA = 1.1;
        operation.numberB = 2.2;
        System.out.println(operation.result());
    }

}

