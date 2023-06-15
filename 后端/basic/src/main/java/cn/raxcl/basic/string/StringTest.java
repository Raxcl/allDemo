package cn.raxcl.basic.string;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author D30100_chenlong
 * date 2022/8/2 9:46
 */
public class StringTest {
    public static void main(String[] args) {
//        String str = "BXYB202301D00008";
        String str = "";
        String[] s = str.split("_");
        System.out.println(Arrays.toString(s));
        System.out.println(s.length);
        System.out.println(3 == 3 && 4==4);
        List<String> list = new ArrayList<>();
    }
}
