package com.company.DZPK.client;

import com.company.DZPK.frame.login_frame;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client {
    public static PrintWriter pw = null;
    private OutputStream os = null;
    private Socket socket = null;
    public void load(){
        try {
            //1.创建客户端Socket，指定服务器地址和端口号
            socket = new Socket("127.0.0.1", 8888);
            //2.获取输出流，用来向服务器发送信息
            os = socket.getOutputStream();//字节输出流
            //转换为打印流
            pw = new PrintWriter(os);
            pw.flush();//刷新缓存，向服务器端输出信息
            //关闭输出流
            //socket.shutdownOutput();
            //3.获取输入流，用来读取服务器端的响应信息
            //改为启动线程监听服务端消息
            ClientThread clientThread = new ClientThread();
            clientThread.start();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                //4.关闭资源
                os.close();
                socket.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    //监听服务器消息
    class ClientThread extends Thread {
        private BufferedReader br = null;
        private InputStream is = null;
        private InputStreamReader isr = null;
        @Override
        public void run() {
            try {
                is = socket.getInputStream();
                isr = new InputStreamReader(is,"UTF-8");
                br = new BufferedReader(isr);
                while (true) {
                    String result = br.readLine();
                    if (result.equals("quit")) { // 遇到退出标识时表示服务端返回确认退出
                        System.out.println("I'm client,and I'm out.");
                        break;
                    } else { // 输出服务端回复的消息
                        System.out.println(result);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                    is.close();
                    isr.close();
                    // 关闭连接
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //监听窗口消息
    class ListenFrame extends Thread{
        private BufferedReader br = null;
        @Override
        public void run(){
            try {
                br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                login_frame loginFrame = new login_frame();
                loginFrame.show();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                    // 关闭连接
                    pw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.load();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
