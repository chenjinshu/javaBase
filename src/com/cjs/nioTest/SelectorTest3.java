package com.cjs.nioTest;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 选择器测试(参考: https://blog.csdn.net/jek123456/article/details/80610926), 模拟监听客户端可读写事件
 * 测试时，必须先启动Tcp监听10008端口，通过终端输入sokit调用可视化界面来启动Tcp监听
 * @author chen.jinshu (青禾)
 * 2019/04/01
 */
public class SelectorTest3 {

    public static void main(String[] args) throws Exception {
        // 创建一个Selector
        Selector selector = Selector.open();

        // 创建一个Socket通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 10008));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);

        while (true) {
            //System.out.println("已有" + selector.select() + "个新的通道有注册事件准备就绪");
            selector.select();

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
                    SocketChannel sc = (SocketChannel) k.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    sc.read(buffer);
                    buffer.flip();
                    System.out.println("服务端发送来的数据:" + new String(buffer.array(), 0, buffer.limit()));
                } else if (k.isWritable()) {
                    // 因为没有往SocketChannel写入东西，所以可写事件会一直处于就绪状态，这里会一直打印
                    //System.out.println("Writable~");
                }

                // 注意每次迭代末尾的keyIterator.remove()调用。Selector不会自己从已选择键集中移除SelectionKey实例。
                // 必须在处理完通道时自己移除。下次该通道变成就绪时，Selector会再次将其放入已选择键集中
                // ************* 尝试注释掉此方法，对比下有什么不同 ****************
                keyIterator.remove();
            }

            Thread.sleep(1000);
        }
    }

    /**
     * 运行该程序后，通过启动的sokit的服务端向该客户端发送一条数据，如果不消费这些数据(注释掉42到48行代码)，看到界面上会一直打印Readable~
     * */
}
