package cn.raxcl.basic.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author D30100_chenlong
 * date 2022/7/19 18:39
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        /*float a = 2.0f - 1.9f;
        float b = 1.8f - 1.7f;
        System.out.println(a);// 0.100000024
        System.out.println(b);// 0.099999905
        System.out.println(a == b);// false*/

        /*BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");

        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);

        System.out.println(x.compareTo(y));// 0*/

        /*BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        System.out.println(a.add(b));// 1.9
        System.out.println(a.subtract(b));// 0.1
        System.out.println(a.multiply(b));// 0.90
        System.out.println(a.divide(b));// 无法除尽，抛出 ArithmeticException 异常
        System.out.println(a.divide(b, 2, RoundingMode.HALF_UP));// 1.11*/

        /*BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        System.out.println(a.compareTo(b));// 1*/

        /*BigDecimal m = new BigDecimal("1.255433");
        BigDecimal n = m.setScale(3,RoundingMode.HALF_DOWN);
        System.out.println(n);// 1.255*/

        /*BigDecimal a = new BigDecimal("1");
        BigDecimal b = new BigDecimal("1.0");
        System.out.println(a.equals(b));//false*/

        BigDecimal a = new BigDecimal("1");
        BigDecimal b = new BigDecimal("1.0");
        System.out.println(a.compareTo(b));//0

    }
}
