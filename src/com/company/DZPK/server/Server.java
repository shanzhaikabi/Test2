package com.company.DZPK.server;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static List<ServerThread> threadList = new ArrayList<ServerThread>();
    public InetAddress address = null;
    public void openServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = null;
            while (true){
                socket = serverSocket.accept();
                //创建线程
                ServerThread serverThread = new ServerThread(socket);
                //线程——启动
                serverThread.start();
                threadList.add(serverThread);
                address = socket.getInetAddress();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class ServerThread extends Thread {
        // 和本线程相关的Socket
        Socket socket = null;

        public ServerThread(Socket socket) {
            this.socket = socket;
        }

        //线程执行的操作，响应客户端的请求
        public void run() {
            InputStream is = null;
            InputStreamReader isr = null;
            BufferedReader br = null;
            OutputStream os = null;
            PrintWriter pw = null;
            try {
                //获取输入流，并读取客户端信息
                is = socket.getInputStream();
                isr = new InputStreamReader(is,"UTF-8");
                br = new BufferedReader(isr);
                String info = "";
                while ((info = br.readLine()) != null) {//循环读取客户端的信息
                    System.out.println("我是服务器，" + info);
                }
                socket.shutdownInput();//关闭输入流
                //获取输出流，响应客户端的请求
                os = socket.getOutputStream();
                pw = new PrintWriter(os);
                pw.write("欢迎您！");
                pw.flush();//调用flush()方法将缓冲输出
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                //关闭资源
                try {
                    pw.close();
                    os.close();
                    br.close();
                    isr.close();
                    is.close();
                    socket.close();
                    threadList.remove(this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args){
        try{
            Server server = new Server();
            server.openServer();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
