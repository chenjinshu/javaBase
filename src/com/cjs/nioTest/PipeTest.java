package com.cjs.nioTest;

import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * 管道测试(参考地址: https://blog.csdn.net/jek123456/article/details/80612262)
 * Pipe通常用于线程间数据传输
 * @author chen.jinshu (青禾)
 * 2019/04/08
 */
public class PipeTest {

    public static void main(String[] args) throws Exception {
        // 创建管道
        Pipe pipe = Pipe.open();

        // 要向管道写数据首先需要访问sink通道
        Pipe.SinkChannel sinkChannel = pipe.sink();

        // 通过调用SinkChannel的write()方法，将数据写入SinkChannel
        String data = "Hello Nio~";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(data.getBytes());
        buffer.flip();
        while (buffer.hasRemaining()) {
            sinkChannel.write(buffer);
        }


        // 从管道读取数据,需要访问source通道
        Pipe.SourceChannel sourceChannel = pipe.source();
        ByteBuffer buffer1 = ByteBuffer.allocate(1024);
        int bytesRead = sourceChannel.read(buffer1);

        System.out.println("读取到" + bytesRead + "个字节的数据");
        buffer1.flip();
        System.out.println(new String(buffer1.array(), 0, buffer1.limit()));
    }
}
