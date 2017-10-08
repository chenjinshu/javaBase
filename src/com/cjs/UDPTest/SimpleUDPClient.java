package com.cjs.UDPTest;

import java.net.*;

public class SimpleUDPClient {

	public static void main(String[] args) {
		DatagramSocket ds = null;      // 连接对象，也就是数据发射器
		DatagramPacket sdp = null;      // 被发射器发射的数据包对象
		DatagramPacket rdp = null;      // 被发射器接收的数据包对象
		String serverHost = "127.0.0.1";    // 服务器主机地址
		int serverPort = 10008;     // 服务器端口号
		String msg = "I am client!";    // 传输的内容

		try {
			// 实例化发射器对象
			ds = new DatagramSocket();

			// 将发射字符串转为byte数组
			byte[] data = msg.getBytes();

            // 创建InetAddresss对象
			InetAddress ia = InetAddress.getByName(serverHost);

			// 实例化发送数据包对象，包含所发送的数据，发送到的服务器以及相应的端口号。
			sdp = new DatagramPacket(data, data.length, ia, serverPort);

			// 发送
			ds.send(sdp);



			// 初始化接收数据
			byte[] bt = new byte[1024];
			rdp = new DatagramPacket(bt, bt.length);

			// 接收
			ds.receive(rdp);

			// 读取反馈内容并输出
			byte[] response = rdp.getData();
			int len = rdp.getLength();
			String s = new String(response, 0, len);
			System.out.println("服务器反馈：" + s);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ds.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
