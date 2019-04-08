package com.cjs.nioTest;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * UDP的DatagramChannel通道测试(参考https://blog.csdn.net/jek123456/article/details/80612189)
 * Java NIO中的DatagramChannel是一个能收发UDP包的通道。因为UDP是无连接的网络协议，所以不能像其它通道那样读取和写入。它发送和接收的是数据包
 * 测试时启动sokit通过udp方式往10008端口发送数据
 * @author chen.jinshu (青禾)
 * 2019/03/31
 */
public class DatagramChannelTest {

    public static void main(String[] args) throws Exception {
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.bind(new InetSocketAddress("127.0.0.1", 10008));

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        datagramChannel.receive(buffer);
        buffer.flip();
        System.out.println("接收到udp数据:" + new String(buffer.array(), 0, buffer.limit()));
    }
}
