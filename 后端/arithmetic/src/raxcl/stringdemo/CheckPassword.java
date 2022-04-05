package raxcl.stringdemo;

import java.util.Arrays;

/**
 * 校验密码是否为高级密码，返回修改成高级密码的最少次数
 *
 * @author D30100_chenlong
 * @date 2022/4/2 14:16
 */
public class CheckPassword {
    public static void main(String[] args) {
        CheckPassword checkPassword = new CheckPassword();
        System.out.println(checkPassword.strongPasswordChecker("aaaB1"));
    }
    public int strongPasswordChecker(String password) {
        //start 13:40
        //end   14:12
        //final
        //判断字符串位数i>=6,i<=20；少几个字符，则次数加几
        //判断是否同时包含小写，大写，数字； 缺几个，次数加几
        //判断是否有连续三次的字符串,aaaaa如果有，执行两次i++，跳过接下来两个，继续判断，次数加一
        //返回修改次数

        int s = 0;
        int freePlusA = 0;
        //多了，减
        int freePlusAA = 0;
        //少了，加
        //思考：加一个和修改一个是不是一样？加是一次i++,修改是2次i++
        int freePlusAB = 0;

        //判断字符串位数i<6,i>20；少几个字符，则次数加几
        if(password.length()<6){
            s += 6-password.length();
            if (s<=3){
                freePlusAB = s;
            }else {
                freePlusAB = 3;
            }
        }else if(password.length()>20){
            s += password.length()-20;
            if (s<=3){
                freePlusAA = s;
            }else {
                freePlusAA = 3;
            }
        }

        //判断是否同时包含小写，大写，数字； 缺几个，次数加几
        boolean w=false,W=false,z=false;
        for(int i=0; i<password.length(); i++){
            char ch = password.charAt(i);
            if(ch>='a' && ch<='z'){
                w=true;
            }else if(ch>='A' && ch<='Z'){
                W=true;
            }else if(ch>='0' && ch<='9'){
                z=true;
            }
        }
        //有个问题，可能会重复,比如aaaaa1,就可能重复加，添加免死机制
        int freePlusB = 0;
        if(w==false){
            if(freePlusAB==0){
                s++;
                freePlusB++;
            }else {
                freePlusAB--;
            }

        }
        if(W==false){
            if(freePlusAB==0){
                s++;
                freePlusB++;
            }else {
                freePlusAB--;
            }
        }
        if(z==false){
            if(freePlusAB==0){
                s++;
                freePlusB++;
            }else {
                freePlusAB--;
            }
        }
        //判断是否有连续三次的字符串,aaaaa如果有，执行两次i++，跳过接下来两个，继续判断，次数加一
        //由于可以任意位置插入或删除，分情况判断
        //如果是插入，从插入后一个开始判断，即1次i++;
        //如果是删除，从删除后一个开始判断aaaaaa,删除位后两个不能和前面一样，用删除，否则用修改,然后i++
        //删除的极端情况，全是a,或者很多a，todo
        for(int i=0; i<password.length()-2; i++){
            char ch = password.charAt(i);
            char ch2 = password.charAt(i+1);
            char ch3 = password.charAt(i+2);
            if(ch == ch2 && ch == ch3){
                //插入
                if(freePlusAB >0){
                    freePlusAB--;
                    i += 1;
                    continue;
                //删除 aaaab ,4次i++
                }else if(freePlusAA >0) {
                    char ch4 = password.charAt(i+3);
                    char ch5 = password.charAt(i+4);
                    if (ch == ch4 && ch == ch5){
                        //5个全等采用修改模式
                        i += 2;
                        continue;
                    }
                    freePlusAA--;
                    i += 1;
                    continue;
                }
                    if(freePlusB >0){
                    freePlusB--;
                    i += 2;
                    continue;
                }
                s++;
                i += 2;
            }
        }
        return s;
    }

}
