package com.cjs.nioTest;

import com.cjs.nioTest.util.FileOperatorUtil;

import java.io.File;

/**
 * @author chen.jinshu (青禾)
 * 参考https://blog.csdn.net/jek123456/article/details/80612527
 * 利用NIO2.0提供的文件操作api测试文件操作
 * 2019/04/08
 */
public class FileOperatorTest {

    public static void main(String[] args) throws Exception {
        // 测试创建文件
        //FileOperatorUtil.createFile(System.getProperty("user.dir") + "/src/com/cjs/nioTest/files/fileOperatorTest.txt");

        // 测试删除文件
        //FileOperatorUtil.deleteFile(System.getProperty("user.dir") + "/src/com/cjs/nioTest/files/fileOperatorTest.txt");

        // 测试拷贝文件
//        FileOperatorUtil.copyFile(System.getProperty("user.dir") + "/src/com/cjs/nioTest/files/fileOperatorTest.txt",
//                System.getProperty("user.dir") + "/src/com/cjs/nioTest/filescopy/");

        // 测试移动文件
        FileOperatorUtil.moveFile(System.getProperty("user.dir") + "/src/com/cjs/nioTest/files/fileOperatorTest.txt",
                System.getProperty("user.dir") + "/src/com/cjs/nioTest/filescopy/");
    }
}
