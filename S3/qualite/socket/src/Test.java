import java.net.*;

public class Test {
	public static void main(String[] args) {
		try {
			InetAddress localMachine = InetAddress.getLocalHost();
			System.out.println(localMachine.getHostName());
			System.out.println(localMachine.getHostAddress());
		} 
		catch (UnknownHostException e) {e.printStackTrace();}
	}
} 