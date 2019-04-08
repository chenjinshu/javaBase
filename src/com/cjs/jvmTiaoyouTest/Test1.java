package com.cjs.jvmTiaoyouTest;

import com.cjs.classloader.DiskClassLoader;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * 模拟metaSpace(元空间)溢出(这里设置的虚拟机参数中MetaspaceSize和MaxMetaspaceSize都是2m，所以启动就会报元空间不足的错误)
 * @author chen.jinshu (青禾)
 * 2019/03/29
 */
public class Test1 {

    public static void main(String[] args) throws Exception {
        //获取有关类型加载的JMX接口
//        ClassLoadingMXBean loadingBean = ManagementFactory.getClassLoadingMXBean();
//
//        while (true) {
//            DiskClassLoader diskClassLoader = new DiskClassLoader("/Users/chenjinshu/IdeaProjects/javaBase/customClassLoaderClassPath");
//            diskClassLoader.loadClass("com.cjs.testclassloader.Point");
//            //显示数量信息（共加载过的类型数目，当前还有效的类型数目，已经被卸载的类型数目）
//            System.out.println("total: " + loadingBean.getTotalLoadedClassCount());
//            System.out.println("active: " + loadingBean.getLoadedClassCount());
//            System.out.println("unloaded: " + loadingBean.getUnloadedClassCount());
//            System.out.println("================");
//        }
    }
}
