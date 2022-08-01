package cn.raxcl.basic.io.ziFu;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 字符输入流测试
 * @author D30100_chenlong
 * date 2022/7/31 11:57
 */
public class Reader {
    private String path = "src/main/java/cn/raxcl/basic/io/ziFu/file/";
    public static void main(String[] args) {
        Reader reader = new Reader();
        // 常用字符编码所占字节数？
        // utf8: 英文占 1 字节， 中文占 3 字节；
        // unicode: 任何字符都占 2 个字节
        // gbk: 英文占 1 字节， 中文占 2 字节
        reader.byteTest();
        // 字符输入流测试
        reader.fileReaderTest();
        // 字符输出流测试
        reader.fileWritreTest();

    }

    private void fileWritreTest() {
        try (Writer output = new FileWriter(path + "output.txt")) {
            output.write("你好， 我是 raxcl。 ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fileReaderTest() {
        try (FileReader fileReader = new FileReader(path + "input.txt")) {
            int context;
            long skip = fileReader.skip(3);
            System.out.println("跳过的字符数：" + skip);
            System.out.println("从文件中输入的内容：");
            while ((context = fileReader.read()) != -1) {
                System.out.print((char) context + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void byteTest() {
        String letter = "c";
        System.out.println();
        System.out.println("一个字母所占字节数：" + letter.getBytes().length);
        String hanZi = "仙";
        System.out.println("一个汉字所占字节数：" + hanZi.getBytes().length);
    }
}
