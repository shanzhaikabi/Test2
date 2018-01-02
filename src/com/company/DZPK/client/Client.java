package com.company.DZPK.client;

import com.company.DZPK.frame.login_frame;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    public String toPush = null;
    public static Client client;
    public PrintWriter pw;
    public void load(){
        try {
            //1.创建客户端Socket，指定服务器地址和端口号
            Socket socket = new Socket("127.0.0.1", 18888);
            //2.获取输出流，用来向服务器发送信息
            OutputStream os = socket.getOutputStream();//字节输出流
            //转换为打印流
            pw = new PrintWriter(os);
            pw.println("wtf");
            pw.flush();//刷新缓存，向服务器端输出信息
            //关闭输出流
            //socket.shutdownOutput();
            //3.获取输入流，用来读取服务器端的响应信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            boolean flag = true;
            while (flag) {
                if (toPush != null){
                    pw.println(toPush);
                    System.out.println("message from client:" + toPush);
                    toPush = null;
                    pw.flush();
                }
                if ((info = br.readLine()) != null) System.out.println("message from server:" + info);
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
    public static void main(String[] args) {
        try {
            client = new Client();
            client.load();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void pushUp(String string){
        System.out.println("message from client:" + toPush);
        pw.println(string);
        pw.flush();
    }
}
