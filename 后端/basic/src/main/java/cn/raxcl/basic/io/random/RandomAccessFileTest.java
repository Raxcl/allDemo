package cn.raxcl.basic.io.random;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机访问流
 *
 * @author D30100_chenlong
 * date 2022/7/31 16:04
 */
public class RandomAccessFileTest {
    private String path = "src/main/java/cn/raxcl/basic/io/random/file/";
    public static void main(String[] args) {
        RandomAccessFileTest random = new RandomAccessFileTest();
        random.randomAccessTest();
    }

    private void randomAccessTest() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(path + "input.txt"), "rw");
            System.out.println("读取之前的偏移量：" + randomAccessFile.getFilePointer() + ", 当前读取到的字符：" + (char) randomAccessFile.read() + ", 读取之后的偏移量：" + randomAccessFile.getFilePointer());
            // 设置指针偏移量为 6
            randomAccessFile.seek(6);
            System.out.println("读取之前的偏移量：" + randomAccessFile.getFilePointer() + ", 当前读取到的字符：" + (char) randomAccessFile.read() + ", 读取之后的偏移量：" + randomAccessFile.getFilePointer());
            // 从偏移量 7 的位置开始写入字节数据
            randomAccessFile.write(new byte[]{'H', 'I', 'j', 'k'});
            randomAccessFile.seek(0);
            System.out.println("读取之前的偏移量：" + randomAccessFile.getFilePointer() + ", 当前读取到的字符：" + (char) randomAccessFile.read() + ", 读取之后的偏移量：" + randomAccessFile.getFilePointer());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
