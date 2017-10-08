package com.cjs.TCPTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleTCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		OutputStream os = null;
		InputStream is = null;
		
		// 端口号
		int port = 10008;
		
		// 反馈内容
		//String msg = "I am server！";

		try {
			// 创建服务端serverSocket (维修公司前台MM)
			serverSocket = new ServerSocket(port);

			// 利用线程处理多客户端连接
			while(true) {
				// 创建服务端Socket (维修人员)
				socket = serverSocket.accept();         // 该方法为阻塞方法，只当有请求到来时才会执行。

				new LogicThread(socket);
			}
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
