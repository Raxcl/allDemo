package raxcl.test;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 检查文本中是否有特殊字符
 *
 * @author D30100_chenlong
 * @date 2022/5/27 13:39
 */
public class CheckSpecialCharacter {
    public static final int S = 4;

    public static void main(String[] args) throws IOException {
//        String str1 = "你们好啊，朋友@#%^&*(们\uD83D\uDC7D！:= '=' | '≠' | [ぁ-ゖゝ-ゟ\uD82C\uDC01\uD83C\uDE00]'!='\\p{scx=Kana} 我acvMSX在这里啊， 啊U+1F1EB U+1F1F7.U+0300 ( ◌̀ )〲啊。啊 --- ￥￥ 540€<tab>002;<control>;Cc;0;BN;;;;;N;START OF TEXT;;;;321 结束";
//        String str = "成为B站车型品牌的头部账户。\n" +
//                "覆盖人次：100W、CPC：6.5元、线索：500条、粉丝增长量：5W+\u000B平均视频播放量：15000次/条\u000B爆款视频数：4+（播放量超10万）。";
        String str = "Bilibili 車種ブランドのヘッドアカウントとなります。\n" +
                "ｶﾊﾞﾚｯｼﾞ：100万、CPC：6.5元、手掛かり：500条、ﾌｧﾝ増加数5W+\u000B各動画平均放映数8000回/本\u000Bﾋｯﾄ動画4+（放映数10万強）。";
        System.out.println("修改前：");
        System.out.println(str+":"+str.length());
        System.out.println("=============================================");
//        getStr("\\pP",str,"标点符号");
//        getStr("\\pL",str,"字母");
//        getStr("\\pM",str,"标记符号");
//        getStr("\\pZ",str,"分隔符");
//        getStr("\\pS",str,"符号");
//        getStr("\\pN",str,"数字");
        str = getStr("\\pC",str,"其他字符");
        System.out.println("修改后");
        System.out.println(str+":"+str.length());
        int S = 4;


    }

    private static String getStr(String regEx, String str,String des) {
//        System.out.println(des);
        return Pattern.compile(regEx).matcher(str).replaceAll("").trim();
//        Matcher matcher = Pattern.compile(regEx).matcher(str);
//        while (matcher.find()) {
//            System.out.print(matcher.group()+"_");
//        }
//        System.out.println();
//        System.out.println("=============================================");
    }

    private void checkTxt() throws IOException {
        //获取文本
        String fileName = "src/raxcl/test/华阳神功.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path).useDelimiter("\\\\pP|\\\\pS|\\\\s+");
        if (scanner.hasNext()){
            System.out.println("有特殊字符");
        }else{
            System.out.println("无特殊字符");
        }
        System.out.println(scanner.next());
        scanner.close();
    }
}
