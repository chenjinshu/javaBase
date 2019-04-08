package com.cjs.util;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * 字节数组转换工具
 * @author chen.jinshu (青禾)
 * 2019/03/01
 */
public class ByteArrayConverterUtils {

    /**
     * 把字节数组转为字符串
     * @param data 字节数组
     * @return String
     */
    public static String byteArrayToString(byte[] data) {
        StringBuilder sb = new StringBuilder();
        for (byte b : data) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }

    /**
     * 把字符串转为字节数组
     * @param data 源字符串
     * @return byte[]
     */
    public static byte[] StringToByteArray(String data) {
        int numberChars = data.length();
        byte[] bytes = new byte[numberChars / 2];
        for (int i = 0; i < numberChars; i += 2) {
            bytes[i / 2] = (byte) Integer.valueOf(data.substring(i, i+2),16).intValue();
        }
        return bytes;
    }

    /**
     * 把double型数据转换成字节数组
     * @param d 源数字
     * @return byte[]
     */
    public static byte[] doubleToByteArray(double d){
        byte[] b = new byte[8];
        long l = Double.doubleToLongBits(d);
        for(int i = 0; i < b.length; i++){
            b[i] = new Long(l).byteValue();
            l = l >> 8;
        }
        return b;
    }

    /**
     * 把字节数组转换成double类型
     * @param b 字节数组
     * @return double
     */
    public static double byteArrayToDouble(byte[] b) {
        long l;
        l = b[0];
        l &= 0xFFL;
        l |= ((long) b[1] << 8);
        l &= 0xFFFFL;
        l |= ((long) b[2] << 16);
        l &= 0xFFFFFFL;
        l |= ((long) b[3] << 24);
        l &= 0xFFFFFFFFL;
        l |= ((long) b[4] << 32);
        l &= 0xFFFFFFFFFFL;
        l |= ((long) b[5] << 40);
        l &= 0xFFFFFFFFFFFFL;
        l |= ((long) b[6] << 48);
        l &= 0xFFFFFFFFFFFFFFL;
        l |= ((long) b[7] << 56);
        return Double.longBitsToDouble(l);
    }

    /**
     * 把int型数据转换成字节数组
     * @param number 源数字
     * @return byte[]
     */
//    public static byte[] intToByteArray(int number) {
//        int temp = number;
//        byte[] b = new byte[4];
//        for (int i = b.length - 1; i > -1; i--){
//            //将最高位保存在最低位
//            b[i] = new Integer(temp & 0xff).byteValue();
//            //向右移8位
//            temp = temp >> 8;
//        }
//        return b;
//    }

    /**
     * 把无符号短整形数字转换成字节数组
     * @param n 源数字
     * @return byte[]
     */
    public static byte[] ushortToByteArray(int n) {
        byte[] b = new byte[2];
        b[1] = (byte) (n & 0xff);
        b[0] = (byte) ((n >> 8) & 0xff);
        return b;
    }

    /**
     * 把int型数字转换成字节数组
     * @param n 源数字
     * @return byte[]
     */
    public static byte[] intToByteArray(int n) {
        byte[] b = new byte[4];
        b[3] = (byte) (n & 0xff);
        b[2] = (byte) (n >> 8 & 0xff);
        b[1] = (byte) (n >> 16 & 0xff);
        b[0] = (byte) (n >> 24 & 0xff);
        return b;
    }

    /**
     * 把字节数组转换成long类型
     * @param bytes 字节数组
     * @return long
     */
    public static long byteArrayToLong(byte[] bytes) {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        DataInputStream dis = new DataInputStream(bais);
        long result = 0;
        try {
            int len = dis.available();
            if (len == 1) {
                result = dis.readByte();
            } else if (len == 2) {
                result = dis.readShort();
            } else if (len == 4) {
                result = dis.readInt();
            } else if (len == 8) {
                result = dis.readLong();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dis.close();
                bais.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
