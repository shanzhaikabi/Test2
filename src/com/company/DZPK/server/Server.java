package com.company.DZPK.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static List<ServerThread> threadList = new ArrayList<ServerThread>();
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
                InetAddress address = socket.getInetAddress();
            }
        } catch (IOException e) {
            e.printStackTrace();
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
