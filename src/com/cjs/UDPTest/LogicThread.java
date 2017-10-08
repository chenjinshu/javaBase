package com.cjs.UDPTest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class LogicThread extends Thread {

    private DatagramSocket ds;      // 发射器

    private DatagramPacket rdp;     // 接收数据包

    private DatagramPacket sdp;     // 发送数据包

    private String msg;

    public LogicThread(DatagramSocket ds, DatagramPacket rdp) {
        this.ds = ds;
        this.rdp = rdp;
        this.msg = "I am server!";
        this.start();
    }

    @Override
    public void run() {

        try {
            // 读取接收内容并输出
            InetAddress ia = rdp.getAddress();      // 客户端InetAddress对象
            String clientHost = ia.getHostAddress();
            int clientPort = rdp.getPort();
            byte[] data = rdp.getData();
            int len = rdp.getLength();
            String content = new String(data, 0, len);
            System.out.println("客户端主机ip地址为：" + clientHost);
            System.out.println("客户端端口为：" + clientPort);
            System.out.println("客户端发送数据内容为：" + content);

            // 向客户端发送反馈内容
            sdp = new DatagramPacket(msg.getBytes(), msg.getBytes().length, ia, clientPort);
            ds.send(sdp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
