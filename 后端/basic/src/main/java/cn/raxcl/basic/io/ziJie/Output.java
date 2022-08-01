package cn.raxcl.basic.io.ziJie;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 字节输出流
 * @author D30100_chenlong
 * date 2022/7/29 17:42
 */
public class Output {
    private String path = "src/main/java/cn/raxcl/basic/io/ziJie/file/";

    public static void main(String[] args) {
        Output output = new Output();
        output.fileOutputStreamTest();
        // 缓冲字节知识点的时候再写demo
        output.bufferedOutputStreamTest();
        output.dataOutputStreamTest();
        output.objectOutputStreamTest();
    }

    private void objectOutputStreamTest() {
        try {
            // 写入文件的是序列化后的内容，出现乱码是正常的
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path + "file.txt"));
            Person person = new Person("dragon", "九尺之上");
            output.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dataOutputStreamTest() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path + "out.txt")) {
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            // 输出任意数据类型
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeByte(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void bufferedOutputStreamTest() {
        try (FileOutputStream output = new FileOutputStream(path + "output.txt")) {
            BufferedOutputStream bos = new BufferedOutputStream(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fileOutputStreamTest() {
        try (FileOutputStream output = new FileOutputStream(path + "output.txt")) {
            byte[] array = "dragon".getBytes();
            output.write(array);
            BufferedOutputStream bos = new BufferedOutputStream(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
