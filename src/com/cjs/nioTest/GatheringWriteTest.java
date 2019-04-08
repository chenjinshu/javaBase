package com.cjs.nioTest;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * channel的gathering write(聚集写入)操作测试
 * @author chen.jinshu (青禾)
 * 2019/04/01
 */
public class GatheringWriteTest {

    public static void main(String[] args) throws Exception {
        // 存储头部信息的字节缓冲区
        ByteBuffer header = ByteBuffer.allocate(48);

        // 存储信息体的字节缓冲区
        ByteBuffer body = ByteBuffer.allocate(48);

        // 创建byteBuffer数组
        ByteBuffer[] bufferArray = {header, body};

        // 创建随机访问文件对象
        RandomAccessFile randomAccessFile = new RandomAccessFile(System.getProperty("user.dir") + "/src/com/cjs/nioTest/files/index.txt", "rw");

        // 根据文件对象获取文件通道
        FileChannel inChannel = randomAccessFile.getChannel();

        // 读取通道数据至buffer数组中, read()方法按照buffer在数组中的顺序将从channel中读取的数据写入到buffer，
        // 当一个buffer被写满后，channel紧接着向另一个buffer中写。
        // Scattering Reads在移动下一个buffer前，必须填满当前的buffer，这也意味着它不适用于动态消息(译者注：消息大小不固定)。
        // 换句话说，如果存在消息头和消息体，消息头必须完成填充（例如 128byte），Scattering Reads才能正常工作
        inChannel.read(bufferArray);

        // 重置position和limit，准备写入
        header.flip();
        body.flip();

        // 聚集写入
        // write()方法会按照buffer在数组中的顺序，将数据写入到channel，注意只有position和limit之间的数据才会被写入。
        // 因此，如果一个buffer的容量为128byte，但是仅仅包含58byte的数据，那么这58byte的数据将被写入到channel中。
        // 因此与Scattering Reads相反，Gathering Writes能较好的处理动态消息
        RandomAccessFile randomAccessFile1 = new RandomAccessFile(System.getProperty("user.dir") + "/src/com/cjs/nioTest/files/testGatheringWrite.txt", "rw");
        FileChannel channel = randomAccessFile1.getChannel();
        channel.write(bufferArray);
    }
}
