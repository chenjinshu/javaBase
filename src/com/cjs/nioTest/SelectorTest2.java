package com.cjs.nioTest;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 选择器测试(参考: https://blog.csdn.net/jek123456/article/details/80610926), 模拟监听客户端连接服务端事件
 * 测试时，无须启动sokit监听端口
 * @author chen.jinshu (青禾)
 * 2019/04/01
 */
public class SelectorTest2 {

    public static void main(String[] args) throws Exception {
        // 创建一个Selector
        Selector selector = Selector.open();

        // 创建一个Socket通道
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        // 注意，SocketChannel在注册到选择器上时，可选键值不能有OP_ACCEPT，这个选项只有ServerSocketChannel能用
        // 原因很简单，OP_ACCEPT意思是可以接受客户端连接，当然只有服务端能用，同理OP_CONNECT服务端ServerSocketChannel
        // 不能用，因为它意思是可以连接服务端，当然也就只有客户端SocketChannel能用
        // 即：SocketChannel可选被监听项有OP_CONNECT, OP_READ, OP_WRITE
        // ServerSocketChannel可选被监听项只有OP_ACCEPT
        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        // 模拟连接到服务端
        connect(socketChannel);

        while (true) {
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

    private static void connect(SocketChannel socketChannel) throws Exception {
        // 模拟延时连接
        Thread.sleep(3000);

        System.out.println("<<<<<<< 准备连接服务端... <<<<<<<<<");
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 10008));
    }
}
