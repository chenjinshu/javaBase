package com.cjs.UDPTest;

import java.net.*;

public class SimpleUDPServer {

	public static void main(String[] args) {
		DatagramSocket ds = null;      // 连接对象，发射器
		DatagramPacket sdp = null;     // 发送数据包对象
		DatagramPacket rdp = null;     // 接收数据包对象
		int port = 10008;
		String msg = "I am server!";

		try {
			ds = new DatagramSocket(port);     // 实例化发射器对象，并监听10008端口

			while(true) {
				// 初始化接收数据
				byte[] bt = new byte[1024];
				rdp = new DatagramPacket(bt, bt.length);

				// 接收数据
				ds.receive(rdp);

				// 创建单独线程处理此次数据传输
				new LogicThread(ds, rdp);
			}
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
