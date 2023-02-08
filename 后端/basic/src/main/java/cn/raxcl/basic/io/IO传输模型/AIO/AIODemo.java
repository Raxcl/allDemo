package cn.raxcl.basic.io.IO传输模型.AIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Future;

public class AIODemo {
    public static void main(String[] args) {
        readFromFile();
    }

    private static void readFromFile() {
        Path file = Paths.get("/usr/a.txt");
        AsynchronousFileChannel channel = null;
        try {
            channel = AsynchronousFileChannel.open(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ByteBuffer buffer = ByteBuffer.allocate(100_000);
        Future<Integer> result = channel.read(buffer, 0);
        while (!result.isDone()) {
            // todo 卡住了，希望后面能有demo可以敲一敲
        }
    }
}
