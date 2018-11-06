// File Name GreetingServer.java
import java.net.*;
import java.io.*;

public class SimpleServer extends Thread {
   private ServerSocket serverSocket;
   
   public SimpleServer(int port) throws IOException {
      serverSocket = new ServerSocket(port);
      serverSocket.setSoTimeout(10000);
   }

   public void run() {
         try {
            System.out.println("Waiting for client on port " + 
               serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            
            System.out.println("Just connected to " + server.getLocalAddress());
           /* DataInputStream in = new DataInputStream(server.getInputStream());
            
            System.out.println(in.readUTF());
            DataOutputStream out = new DataOutputStream(server.getOutputStream());*/
            System.out.println("Thank you for connecting to " + server.getLocalSocketAddress()
               + "\nGoodbye!");
            server.close();
            
         } catch (SocketTimeoutException s) {
            System.out.println("Socket timed out!");
            
         } catch (IOException e) {
            e.printStackTrace();
          
         }
      
   }
   
   public static void main(String [] args) {
      int port = 8081;
      try {
         Thread t = new SimpleServer(port);
         t.start();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}