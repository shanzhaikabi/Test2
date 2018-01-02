package com.company.DZPK.server;

import com.company.DZPK.controller.Holdem;
import com.company.DZPK.model.UserData;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    private static List<ServerThread> threadList = new ArrayList<ServerThread>();
    public static Map<Integer,ServerThread> threadMap = new HashMap<Integer,ServerThread>();
    private static List<GameThread> tableList = new ArrayList<GameThread>();
    private static int playerNumber = 0;
    private static int tableNumber = 0;
    public static Queue<UserData> userDataQueue = new ArrayDeque<UserData>();
    public InetAddress address = null;
    public void openServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(18888);
            Socket socket = null;
            while (true){
                socket = serverSocket.accept();
                //创建线程
                ServerThread serverThread = new ServerThread(socket);
                //线程——启动
                serverThread.start();
                threadList.add(serverThread);
                address = socket.getInetAddress();
                playerNumber++;
                if(userDataQueue.size() > 0 && userDataQueue.size() % 2 == 0){
                    System.out.println("new holdem");
                    Holdem holdem = new Holdem(new Socket("127.0.0.1",18888));//新建主机
                    GameThread gameThread = new GameThread(holdem);
                    gameThread.start();
                    tableList.add(gameThread);
                    tableNumber++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class ServerThread extends Thread {
        // 和本线程相关的Socket
        Socket socket = null;

        public ServerThread(Socket socket) {
            this.socket = socket;
        }
        public void sendMessage(String string){
            OutputStream os = null;
            PrintWriter pw = null;
            try {
                //获取输入流，并读取客户端信息
                os = socket.getOutputStream();
                pw = new PrintWriter(os);
                pw.println(string);
                pw.flush();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                //关闭资源
                try {
                    pw.close();
                    os.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
                os = socket.getOutputStream();
                pw = new PrintWriter(os);
                String info = "";
                while ((info = br.readLine()) != null) {//循环读取客户端的信息
                    String result = StringToAction.StringToAction(info,this);
                    pw.println(result);
                    pw.flush();
                }
                socket.shutdownInput();//关闭输入流
                //获取输出流，响应客户端的请求
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
                    playerNumber--;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class GameThread extends Thread {
        Holdem table = null;
        Socket socket = null;
        public GameThread(Holdem holdem) {
            table = holdem;
            socket = table.getSocket();
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
                os = socket.getOutputStream();
                pw = new PrintWriter(os);
                System.out.println("load");
                table.load();
                socket.shutdownInput();//关闭输入流
                //获取输出流，响应客户端的请求
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //关闭资源
                try {
                    pw.close();
                    os.close();
                    br.close();
                    isr.close();
                    is.close();
                    tableList.remove(this);
                    socket.close();
                    tableNumber--;
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
