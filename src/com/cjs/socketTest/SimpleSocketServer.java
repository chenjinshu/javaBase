package com.cjs.socketTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleSocketServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		OutputStream os = null;
		InputStream is = null;
		
		// 端口号
		int port = 10008;
		
		// 反馈内容
		String msg = "I am server！";

		try {
			// 创建服务端serverSocket (维修公司前台MM)
			serverSocket = new ServerSocket(port);
			
			// 创建服务端Socket (维修人员)
			socket = serverSocket.accept();         // 该方法为阻塞方法，只当有请求到来时才会执行。
			
			// 获得输入流
			is = socket.getInputStream();
			
			// 接收客户端传来的数据
			byte[] bt = new byte[1024];
			int n = is.read(bt);
			
			// 输出传来的数据
			System.out.println("客户端发送内容为：" + new String(bt, 0, n));
			
			// 向客户端发送反馈内容
			os = socket.getOutputStream();
			os.write(msg.getBytes());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭输入输出流
				os.close();
				is.close();
				
				// 关闭socket
				socket.close();
				
				// 关闭serverSocket
				serverSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
