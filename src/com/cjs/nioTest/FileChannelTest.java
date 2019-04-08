package com.cjs.nioTest;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件通道测试(参考https://blog.csdn.net/jek123456/article/details/80606969)
 * FileChannel无法设置为非阻塞模式，它总是运行在阻塞模式下
 * @author chen.jinshu (青禾)
 * 2019/03/31
 */
public class FileChannelTest {

    public static void main(String[] args) throws Exception {
        // 创建随机访问文件对象
        RandomAccessFile randomAccessFile = new RandomAccessFile(System.getProperty("user.dir") + "/src/com/cjs/nioTest/files/index.txt", "rw");

        // 根据文件对象获取文件通道
        FileChannel inChannel = randomAccessFile.getChannel();

        // 创建一个可容纳48个字节数据的字节缓冲区
        // 类似的缓冲区还有 CharBuffer, IntBuffer, DoubleBuffer...等等
        ByteBuffer buffer = ByteBuffer.allocate(48);

        // 读取通道数据至缓冲区中,返回值为本次读取的字节数
        int bytesRead = inChannel.read(buffer);

        while (bytesRead != -1) {
            System.out.println("<<<<<<Read: " + bytesRead);
            // 将buffer从写模式切换到读模式，具体参考https://www.cnblogs.com/woshijpf/articles/3723364.html
            buffer.flip();

            // 循环读取缓冲区的数据, hasRemaining方法返回的值是数据指针所指的数据是否为空
            while (buffer.hasRemaining()) {
                // get方法每次读取一个字节的数据，并将数据指针往后移动一个字节，使得下次调用get方法时从指针所指的地方读取
                // 这里所说的指针其实就是buffer的position属性
                System.out.print((char) buffer.get());
            }

            // 调用该方法，position将被设回0，limit被设置成capacity的值。但是Buffer中的数据并未清除，只是这些标记告诉我们可以从哪里开始往Buffer里写数据
            buffer.clear();
            // 调用该方法, 会将buffer中未被读取过的数据移动到缓冲区的起始处，并置position为被移动的后的数据末尾，使得新数据从未被读取的数据后面写入。跟clear方法一样，数据依然不会被清除
            /// buffer.compact();

            // 继续读取通道数据至缓冲区
            bytesRead = inChannel.read(buffer);
        }

        // 关闭channel
        inChannel.close();
        // 关闭文件对象
        randomAccessFile.close();
    }
}
