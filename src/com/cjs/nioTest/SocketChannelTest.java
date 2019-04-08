package com.cjs.nioTest;

import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * TCP网络套接字通道测试(参考https://blog.csdn.net/jek123456/article/details/80611992)
 * 测试从通道中读取数据，测试时先启动sokit并采用tcp监听10008端口
 * @author chen.jinshu (青禾)
 * 2019/03/31
 */
public class SocketChannelTest {

    public static void main(String[] args) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 10008));
        //socketChannel.configureBlocking(false);

        socketChannel.read(buffer);

        buffer.flip();
        System.out.println("获取到服务端发送的数据:" + new String(buffer.array(), 0, buffer.limit()));

        /**
         * 默认情况下，该通道的read方法依然是一个阻塞方法。会阻塞到客户端服务器读缓冲区有数据并读取到为止。
         * 通过设置通道configureBlocking为false，该方法就会变成一个非阻塞方法。
         *
         * 关于缓冲区的理解参考https://www.cnblogs.com/longfurcat/p/10349365.html
         */
    }
}
