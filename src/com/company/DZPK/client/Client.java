package com.company.DZPK.client;

import com.company.DZPK.frame.login_frame;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client {
    public PrintWriter pw = null;
    private OutputStream os = null;
    private Socket socket = null;
    public static SendThread sendThread;
    //public Client client;
    public void load(){
        try {
            //1.创建客户端Socket，指定服务器地址和端口号
            socket = new Socket("127.0.0.1", 18888);
            //启动线程监听服务端消息
            ClientThread clientThread = new ClientThread(socket);
            clientThread.start();
            sendThread = new SendThread(socket);
            sendThread.start();
            login_frame.show();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                //4.关闭资源
                //os.close();
                //socket.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    //监听服务器消息
    class ClientThread extends Thread {
        private Socket socket = null;
        private BufferedReader br = null;
        private InputStream is = null;
        private InputStreamReader isr = null;
        public ClientThread(Socket x){socket = x;}
        @Override
        public void run() {
            try {
                is = socket.getInputStream();
                isr = new InputStreamReader(is,"UTF-8");
                br = new BufferedReader(isr);
                while (true) {
                    String result = br.readLine();
                    if (result != null)
                        if (result.equals("quit")) { // 遇到退出标识时表示服务端返回确认退出
                            System.out.println("I'm client,and I'm out.");
                            break;
                        } else { // 输出服务端回复的消息
                            System.out.println("server:" + result);
                            StringToAction.StringToAction(result);
                        }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    isr.close();
                    // 关闭连接
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //发送消息
    public class SendThread extends Thread{
        private Socket socket = null;
        private OutputStream os = null;
        private PrintWriter pw = null;
        private InputStream is = null;
        private InputStreamReader isr = null;
        private BufferedReader br = null;
        public SendThread(Socket x){socket = x;}
        public void run(){
            try {
                //字节输出流
                os = socket.getOutputStream();
                //转换为打印流
                pw = new PrintWriter(os);
                while(true){
                    if (is != null) {
                        isr = new InputStreamReader(is, "UTF-8");
                        br = new BufferedReader(isr);
                        String msg = br.readLine();
                        if (msg != null) {
                            System.out.println("message:" + msg);
                            pw.println(msg);
                            pw.flush();
                        }
                        is = null;
                    }
                    sleep(100);
                }

            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try {
                    //关闭输出流
                    socket.shutdownOutput();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        public void setIs(String x){
            is = new ByteArrayInputStream(x.getBytes());
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
