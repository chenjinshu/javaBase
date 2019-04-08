package com.cjs.nioTest;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件通道测试(参考https://blog.csdn.net/jek123456/article/details/80610332)
 * 通道间直接数据转移
 * @author chen.jinshu (青禾)
 * 2019/03/31
 */
public class FileChannelTest1 {

    public static void main(String[] args) throws Exception {
        // 创建随机访问文件对象
        RandomAccessFile fromRandomAccessFile = new RandomAccessFile(System.getProperty("user.dir") + "/src/com/cjs/nioTest/files/from.txt", "rw");
        // 根据文件对象获取文件通道
        FileChannel fromChannel = fromRandomAccessFile.getChannel();

        // 创建随机访问文件对象
        RandomAccessFile toRandomAccessFile = new RandomAccessFile(System.getProperty("user.dir") + "/src/com/cjs/nioTest/files/to.txt", "rw");
        // 根据文件对象获取文件通道
        FileChannel toChannel = toRandomAccessFile.getChannel();

        long position = 0;
        long count = fromChannel.size();

        // 开始转移，把fromChannel中的数据克隆到toChannel对应的文件中(to.txt)
        // 方法的输入参数position表示从position处开始向目标文件写入数据，count表示最多传输的字节数。
        // 如果源通道的剩余空间小于 count 个字节，则所传输的字节数要小于请求的字节数。
        // 此外要注意，在SoketChannel的实现中，SocketChannel只会传输此刻准备好的数据（可能不足count字节）。
        // 因此，SocketChannel可能不会将请求的所有数据(count个字节)全部传输到FileChannel中。
        toChannel.transferFrom(fromChannel, position, count);

        // 该方法的效果跟上面的方法一模一样
        /// fromChannel.transferTo(position, count, toChannel);

        fromChannel.close();
        fromRandomAccessFile.close();
        toChannel.close();
        toRandomAccessFile.close();
    }
}
