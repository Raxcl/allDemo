package cn.raxcl.basic.io.buffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节缓冲流测试
 *
 * @author D30100_chenlong
 * date 2022/7/31 15:11
 */
public class ByteBufferedTest {
    private String path = "src/main/java/cn/raxcl/basic/io/buffer/file/";
    public static void main(String[] args) {
        ByteBufferedTest byteBufferedTest = new ByteBufferedTest();
        // 普通字节流复制文件--时间测试
//        byteBufferedTest.ordinaryTimeTest();
        // 缓冲字节流复制文件--时间测试
//        byteBufferedTest.bufferTimeTest();
        // 缓冲字节流复制文件--时间测试
        byteBufferedTest.bufferTimeTestWithBytes();
        // 普通字节流复制文件--时间测试
        byteBufferedTest.ordinaryTimeTestWithBytes();
    }

    private void ordinaryTimeTest() {
        // 记录开始时间
        long start = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream(path + "自控力.pdf");
             FileOutputStream fos = new FileOutputStream(path + "自控力-副本1.pdf")
        ) {
            int context;
            while ((context = fis.read()) != -1) {
                fos.write((char) context);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("使用普通流复制pdf问价总耗时：" + (end - start) + "毫秒");
    }

    private void bufferTimeTestWithBytes() {
        // 记录开始时间
        long start = System.currentTimeMillis();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path + "qqq.pdf"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + "qqq-副本.pdf"))
        ) {
            int context;
            while ((context = bis.read()) != -1) {
                bos.write((char) context);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("使用缓冲流复制pdf问价总耗时：" + (end - start) + "毫秒");
    }

    private void ordinaryTimeTestWithBytes() {
        // 记录开始时间
        long start = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream(path + "qqq.pdf");
             FileOutputStream fos = new FileOutputStream(path + "qqq-副本1.pdf")
        ) {
            int len;
            byte[] bytes = new byte[4 * 1024];
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("使用普通流复制pdf问价总耗时：" + (end - start) + "毫秒");
    }

    private void bufferTimeTest() {
        // 记录开始时间
        long start = System.currentTimeMillis();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path + "自控力.pdf"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + "自控力-副本.pdf"))
        ) {
            int len;
            byte[] bytes = new byte[4 * 1024];
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("使用缓冲流复制pdf问价总耗时：" + (end - start) + "毫秒");
    }
}
