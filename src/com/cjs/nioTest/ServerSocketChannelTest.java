package com.cjs.nioTest;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 服务端TCP网络套接字通道测试(参考https://blog.csdn.net/jek123456/article/details/80612124)
 * 测试时可以通过启动sokit通过tcp方式往10008端口发送数据
 * @author chen.jinshu (青禾)
 * 2019/03/31
 */
public class ServerSocketChannelTest {

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 10008));
        //serverSocketChannel.configureBlocking(false);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            handle(socketChannel);
        }
    }

    private static void handle(SocketChannel socketChannel) throws Exception {
        if (socketChannel != null) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            socketChannel.read(buffer);
            buffer.flip();
            System.out.println("客户端发送内容:" + new String(buffer.array(), 0, buffer.limit()));
        }
    }

    /**
     * 默认情况下，serverSocketChannel.accept()方法是阻塞方法，直到有和新的客户端建立连接.
     * 取消掉19行代码的注释，accept方法会变成非阻塞方法。在非阻塞模式下，accept() 方法会立刻返回，
     * 如果还没有新进来的连接,返回的将是null。因此，需要检查返回的SocketChannel是否是null
     */
}
