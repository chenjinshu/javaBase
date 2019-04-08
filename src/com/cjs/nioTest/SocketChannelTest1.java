package com.cjs.nioTest;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * TCP网络套接字通道测试(参考https://blog.csdn.net/jek123456/article/details/80611992)
 * 测试往通道中写入数据，测试时先启动sokit并采用tcp监听10008端口
 * @author chen.jinshu (青禾)
 * 2019/03/31
 */
public class SocketChannelTest1 {

    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 10008));
        //socketChannel.configureBlocking(false);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("cjsnb".getBytes());
        buffer.flip();
        socketChannel.write(buffer);

        buffer.flip();
        System.out.println("向服务端发送的数据:" + new String(buffer.array(), 0, buffer.limit()));

        /**
         * 默认情况下，该通道的write方法依然是一个阻塞方法。会阻塞到数据发送到服务端读缓冲区为止。
         * 通过设置通道configureBlocking为false，该方法就会变成一个非阻塞方法
         */
    }
}
