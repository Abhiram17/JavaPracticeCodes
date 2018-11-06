

	import java.io.PrintStream;
	import java.net.ServerSocket;
	import java.net.Socket;

	import javax.net.ssl.SSLServerSocketFactory;

	public class SslServer {
	  public static void main(String args[]) throws Exception {
	    SSLServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
	    ServerSocket ss = ssf.createServerSocket(5432);
	    
	    while (true) {
	      Socket s = ss.accept();
	      System.out.println("Start...");
	      PrintStream out = new PrintStream(s.getOutputStream());
	      out.println("<html><body><p>Hi How are u</p></body></html>"); 
	      out.close();
	      System.out.println("End!!!");
	      s.close();
	    }

	  }
	}

