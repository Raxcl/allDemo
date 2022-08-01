package cn.raxcl.basic.io.ziJie;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * 字节输入流测试
 *
 * @author D30100_chenlong
 * date 2022/7/29 15:04
 */
public class Input {
    private String path = "src/main/java/cn/raxcl/basic/io/ziJie/file/";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Input input = new Input();
        // 文件输入流
        input.fileInputStreamTest();
        // 文件输入流 + 字节缓冲输入流
//        input.fileInputStreamAndBufferedInputStreamTest();
        // DataInputStream测试
        input.dataInputStreamTest();
//        input.objectInputStreamTest();

    }

    // object.data 必须实现序列化
    private void objectInputStreamTest() throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(path + "object.data"));
        Object o = input.readObject();
        System.out.println(o);
    }

    private void dataInputStreamTest() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path + "input.txt");
        // 必须将 fileInputStream 作为构造参数才能使用
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        // 可以读取任意具体的类型数据
        dataInputStream.readBoolean();
        dataInputStream.readInt();
//        dataInputStream.readUTF();
    }

    /*private void fileInputStreamAndBufferedInputStreamTest() throws FileNotFoundException {
        // 新建一个 BufferedInputStream 对象
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src/main/java/cn/raxcl/basic/io/ziJie/input.txt"));
        // 读取文件的内容并复制到 String 对象中 (jdk9才有的方法）
        String reslut = new String(bufferedInputStream.readAllBytes());

    }*/

    private void fileInputStreamTest() {
        try (InputStream fis = new FileInputStream(path + "input.txt")) {
            System.out.println("Number of remaining bytes: " + fis.available());
            int content;
            long skip = fis.skip(3);
            System.out.println("The actual number of bytes skipped: " + skip);
            System.out.print("The content read from the file: ");
            // 一个字节一个字节读取
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
