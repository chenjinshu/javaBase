package com.cjs.TCPTest;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LogicThread extends Thread {

    private Socket socket;

    private InputStream is;

    private OutputStream os;

    private String msg;

    public LogicThread(Socket socket) {
        this.socket = socket;
        this.msg = "I am server!";
        this.start();
    }

    @Override
    public void run() {

        try {
            // 获得输入流
            is = socket.getInputStream();

            // 接收客户端传来的数据
            for(int i=0; i<3; i++) {     // 复用socket
                byte[] bt = new byte[1024];
                int n = is.read(bt);            // 这同样也是一个阻塞方法，只有当流中有数据并被读取完后，后面的代码才能被执行

                // 输出传来的数据
                System.out.println("客户端发送内容为：" + new String(bt, 0, n));

                // 向客户端发送反馈内容
                os = socket.getOutputStream();
                os.write(msg.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
