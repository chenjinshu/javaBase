package com.cjs.nioTest;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/**
 * 选择器测试(参考: https://blog.csdn.net/jek123456/article/details/80610926), 模拟监听服务端接受客户端连接请求事件
 * 该测试不需要启动sokit(因为SocketChannel.open(new InetSocketAddress("127.0.0.1", 10008))方式连接默认采用的是非阻塞模式，
 * 方法会在和服务端建立连接成功前就返回，要想确认是否连接成功，可以调用socketChannel.isConnected()方法)
 * @author chen.jinshu (青禾)
 * 2019/04/01
 */
public class SelectorTest1 {

    public static void main(String[] args) throws Exception {
        // 创建一个Selector
        Selector selector = Selector.open();

        // 创建一个服务端Socket通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 10008));

        serverSocketChannel.configureBlocking(false);
        // 对于ServerSocketChannel，可选择的被监听的事件只能有OP_ACCEPT，原理在SelectorTest2中讲解
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 模拟有客户端连接到服务端
        new Thread(() -> {
            try {
                connect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        while (true) {
            // select会去查询哪些通道有注册事件发生，然后把这些通道封装成SelectionKey
            // 放入一个集合中（也就是selector.selectedKeys()返回的那个集合）。然后返回
            // 新查询出来的通道与原SelectionKey集合相比新增的那些通道的数量值
            // 如果该方法查询不到有注册事件发生的通道，那么该方法会一直阻塞，直到有通道有注册事件发生
            System.out.println("已有" + selector.select() + "个新的通道有注册事件准备就绪");


            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectionKeySet.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey k = keyIterator.next();
                if (k.isConnectable()) {
                    System.out.println("Connectable~");
                } else if (k.isAcceptable()) {
                    System.out.println("Acceptable~");
                } else if (k.isReadable()) {
                    System.out.println("Readable~");
                } else if (k.isWritable()) {
                    System.out.println("Writable~");
                }

                // 注意每次迭代末尾的keyIterator.remove()调用。Selector不会自己从已选择键集中移除SelectionKey实例。
                // 必须在处理完通道时自己移除。下次该通道变成就绪时，Selector会再次将其放入已选择键集中
                // ************* 尝试注释掉此方法，对比下有什么不同 ****************
                keyIterator.remove();
            }

            Thread.sleep(1000);
        }
    }

    private static void connect() throws Exception {
        // 模拟连接请求耗时
        Thread.sleep(3000);

        System.out.println("<<<<<<< 准备连接服务端... <<<<<<<<<");
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 10008));
    }
}
