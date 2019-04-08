package com.cjs.nioTest;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 选择器测试(参考: https://blog.csdn.net/jek123456/article/details/80610926)
 * 测试时，必须先启动Tcp监听10008端口，可以通过终端输入sokit调用可视化界面来启动Tcp监听
 * @author chen.jinshu (青禾)
 * 2019/04/01
 */
public class SelectorTest {

    public static void main(String[] args) throws Exception {
        // 创建一个Selector
        Selector selector = Selector.open();

        // 注意，FileChannel不是可挑选的通道(也就是非SelectableChannel)，该通道是阻塞通道，无法注册到selector上。
        // 所以这里使用SocketChannel来进行测试
        // 创建一个SocketChannel，该通道连接至本机10008端口(首先必须启动该端口的Tcp监听，否则会报连接被拒绝的异常)
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 10008));
        /// SocketChannel socketChannel = SocketChannel.open();

        // 设置通道为非阻塞模式(因为通道要想与Selector一起使用，必须是处于非阻塞模式)
        socketChannel.configureBlocking(false);

        // 注册该通道到selector上, 并设置selector对该通道感兴趣的事件为读和写(感兴趣事件通过|符号连接)
        SelectionKey key = socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);

        // 获取key的interest(感兴趣)集合
//        int interestSet = key.interestOps();
//        System.out.println(interestSet);

//        boolean isInterestedInAccept  = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT;
//        boolean isInterestedInConnect = (interestSet & SelectionKey.OP_CONNECT) == SelectionKey.OP_CONNECT;
//        boolean isInterestedInRead    = (interestSet & SelectionKey.OP_READ) == SelectionKey.OP_READ;
//        boolean isInterestedInWrite   = (interestSet & SelectionKey.OP_WRITE) == SelectionKey.OP_WRITE;
//        System.out.println(isInterestedInAccept);
//        System.out.println(isInterestedInConnect);
//        System.out.println(isInterestedInRead);
//        System.out.println(isInterestedInWrite);

        // 获取ready集合。ready集合是通道已经准备就绪的操作的集合。在一次选择(Selection)之后，你会首先访问这个ready set
//        int readySet = key.readyOps();
//        System.out.println(readySet);

        // 该方法会阻塞到至少有一个通道在你注册的事件上就绪了。该方法还有select(long timeout)，selectNow()等重载方法
        // 其返回值表示有多少通道准备就绪。亦即，自上次调用select()方法后有多少通道变成就绪状态。如果调用select()方法，
        // 因为有一个通道变成就绪状态，返回了1，若再次调用select()方法，如果另一个通道就绪了，它会再次返回1。
        // 如果对第一个就绪的channel没有做任何操作，现在就有两个就绪的通道，但在每次select()方法调用之间，只有一个通道就绪了。
        System.out.println("已有" + selector.select() + "个新的通道有注册事件准备就绪");

        // 一旦调用了select()方法，并且返回值表明有一个或更多个通道就绪了，然后可以通过调用selector的selectedKeys()方法，
        // 访问“已选择键集(包括之前选择的集合)”中的就绪通道。
        Set<SelectionKey> selectionKeySet = selector.selectedKeys();
        Iterator<SelectionKey> keyIterator = selectionKeySet.iterator();
        while (keyIterator.hasNext()) {
            SelectionKey k = keyIterator.next();
            if (k.isAcceptable()) {
                System.out.println("Acceptable~");
            } else if (k.isConnectable()) {
                System.out.println("Connectable~");
            } else if (k.isReadable()) {
                System.out.println("Readable~");
            } else if (k.isWritable()) {
                System.out.println("Writable~");
                SocketChannel channel = (SocketChannel) k.channel();
                ByteBuffer buffer = ByteBuffer.allocate("cjs".getBytes().length);
                buffer.put("cjs".getBytes());
                // 向socketChannel写入数据，此时tcp的server端可以接收到此数据
                buffer.flip();
                while (buffer.hasRemaining()) {
                    channel.write(buffer);
                }
            }

            // 注意每次迭代末尾的keyIterator.remove()调用。Selector不会自己从已选择键集中移除SelectionKey实例。
            // 必须在处理完通道时自己移除。下次该通道变成就绪时，Selector会再次将其放入已选择键集中
            keyIterator.remove();
        }


        socketChannel.close();
        selector.close();
    }
}
