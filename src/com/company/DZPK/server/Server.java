package com.company.DZPK.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
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

                InetAddress address = socket.getInetAddress();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args){
    }
}
