package com.company.DZPK.client;

import java.io.*;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    public static PrintWriter pw = null;
    public void load(){

    }
    public static void main(String[] args) {
        try {
            //1.创建客户端Socket，指定服务器地址和端口号
            Socket socket = new Socket("127.0.0.1", 8888);
            //2.获取输出流，用来向服务器发送信息
            OutputStream os = socket.getOutputStream();//字节输出流
            //转换为打印流
            pw = new PrintWriter(os);
            pw.flush();//刷新缓存，向服务器端输出信息
            //关闭输出流
            //socket.shutdownOutput();
            //3.获取输入流，用来读取服务器端的响应信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("我是客户端，服务器端返回的信息是：" + info);
            }
            //4.关闭资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
