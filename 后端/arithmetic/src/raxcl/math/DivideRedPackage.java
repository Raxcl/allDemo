package raxcl.math;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 拆分红包
 *
 * @author D30100_chenlong
 * @date 2022/4/20 17:46
 */
public class DivideRedPackage {
    /**
     * 拆分红包
     * @param totalAmount 总金额（以分为单位）
     * @param totalPeopleNum 总人数
     * @return
     */
    public  static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeopleNum){
        List<Integer> amountList = new ArrayList<>();
        Integer restAmount = totalAmount;
        Integer restPeopleNum = totalPeopleNum;
        Random random = new Random();
        for (int i = 0; i < totalPeopleNum-1; i++) {
            //随机范围：【1，剩余人均金额的2倍-1】分
            int amount = random.nextInt(restAmount/restPeopleNum*2-1)+1;
            restAmount -= amount;
            restPeopleNum--;
            amountList.add(amount);
        }
        amountList.add(restAmount);
        return amountList;
    }

    public static void main(String[] args) {
        List<Integer> amountList = divideRedPackage(1000, 10);
        for (Integer amount: amountList){
            System.out.println("抢到金额："+ new BigDecimal(amount).divide(new BigDecimal(1)));
        }
    }

}
