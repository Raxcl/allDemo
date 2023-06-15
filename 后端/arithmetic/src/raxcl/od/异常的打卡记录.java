package raxcl.od;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author D30100_chenlong
 * @date 2023/2/24 21:09
 */
public class 异常的打卡记录 {
    public static void main(String[] args) {
        异常的打卡记录 异常的打卡记录 = new 异常的打卡记录();
        异常的打卡记录.method();
    }

    private void method() {
        // 输入

        Scanner scanner = new Scanner(System.in);
        String temStr = scanner.nextLine();
        if (temStr == null) {
            System.out.println("null");
            return;
        }
        int nums = Integer.parseInt(temStr);
        /**
         * 输入用 List<str[]>封装
         * 输出用 TreeMap<index, str[]>封装，解决重复问题
         */
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < nums; i++) {
            list.add(scanner.nextLine());
        }
        // 输出
        TreeMap<Integer, String> resultMap = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            String[] str = list.get(i).split(",");
            // 异常一
            if (!str[3].equals(str[4])) {
                resultMap.put(i, list.get(i));
                continue;
            }
            if (i ==0) {
                continue;
            }
            String[] leftStr = list.get(i-1).split(",");

            // 异常二
            // 时间
            int temTime = Integer.parseInt(str[1]);
            int leftTime = Integer.parseInt(leftStr[1]);
            // 距离
            int temDis = Integer.parseInt(str[2]);
            int leftDis = Integer.parseInt(leftStr[2]);
            if (str[0].equals(leftStr[0]) && temTime - leftTime < 60 && Math.abs((temDis - leftDis)) > 5) {
                resultMap.put(i-1, list.get(i-1));
                resultMap.put(i, list.get(i));
            }
        }
        if (resultMap.size() == 0) {
            System.out.println("null");
        } else {
            // 打印
            StringBuilder stringBuilder = new StringBuilder();
            Set<Integer> set = resultMap.keySet();
            for (Integer key : set) {
                stringBuilder.append(resultMap.get(key)).append(";");
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            System.out.println(stringBuilder);
        }
    }
}

