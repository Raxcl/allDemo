package cn.raxcl.basic.io.IO传输模型.BIO;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BIODemo {
    public static void main(String[] args) {
        // 初始化对象
        User user = new User();
        user.setName("张三");
        user.setAge(18);

        // 写入对象到文件
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("src/main/java/cn/raxcl/basic/io/IO传输模型/BIO/tempFile")));
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert oos != null;
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // 从文件中读取对象
        File file = new File("src/main/java/cn/raxcl/basic/io/IO传输模型/BIO/tempFile");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(Files.newInputStream(file.toPath()));
            User newUser = (User) ois.readObject();
            System.out.println(newUser);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert ois != null;
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
