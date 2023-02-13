package cn.raxcl.basic.BigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class BigDecimalTest {
    public static void main(String[] args) {
//         test1();
         test2();

    }

    private static void test2() {
        // DecimalFormat 默认使用的 HALF_EVEN
        /**
         * HALF_EVEN : Rounding mode to round towards the “nearest neighbor” unless both neighbors are equidistant, in which case, round towards the even neighbor.
         * 向最近的邻居舍入，意思是：如果要舍弃的位数是5，
         * 5后面有值，说明接近6，就进位
         * 如果没值或者都是0，说明进位和舍弃的距离相等，就判断前一位，使其向偶数靠拢，如果前一位是2，就不进位，如果是3就进位变成4.
         */
        //
        BigDecimal bigDecimal = new BigDecimal("10182220.225000");
        String format = new DecimalFormat("##0.00").format(bigDecimal);
        System.out.println(format);
    }

    private static void test1() {
        BigDecimal bigDecimal = new BigDecimal("10182220.225000");
        DecimalFormat df = new DecimalFormat("##0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        String format = df.format(bigDecimal);
        System.out.println(format);
    }
}
