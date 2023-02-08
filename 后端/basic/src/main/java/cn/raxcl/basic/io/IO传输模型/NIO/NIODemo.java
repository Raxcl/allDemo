package cn.raxcl.basic.io.IO传输模型.NIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class NIODemo {
    public static void main(String[] args) {
//        readNIO();
        writeNIO();
    }

    private static void writeNIO() {
        String  filename = "src/main/java/cn/raxcl/basic/io/IO传输模型/NIO/out.txt";
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(new File(filename));
            FileChannel channel = fos.getChannel();
            ByteBuffer src = Charset.forName("utf8").encode("我发你对方那就等你");
            int length = 0;

            while ((length = channel.write(src)) != 0) {
                System.out.println("写入长度:" + length);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static void readNIO() {
        String pathname = "src/main/java/cn/raxcl/basic/io/IO传输模型/NIO/d3dcompiler_47.dll";
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(new File(pathname));
            FileChannel channel = fin.getChannel();
            int capacity = 100; // 字节
            ByteBuffer bf = ByteBuffer.allocate(capacity);
            int length = -1;
            while((length = channel.read(bf)) != -1) {
                bf.clear();
                byte[] bytes = bf.array();
                System.out.write(bytes, 0, length);
                System.out.println();
            }
            channel.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
