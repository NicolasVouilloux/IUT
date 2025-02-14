import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	int id ;
	Socket socket ;
	
	public ServerThread(int i, Socket socket) {
		this.id = i;
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			int readValue;
			
			BufferedReader inputStream = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			PrintWriter outputStream = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));
			
			outputStream.println("Go");
			outputStream.flush();
			
			do {
				readValue = Integer.valueOf(inputStream.readLine());
				Server.nb_etapes[this.id]++ ;
				
				if(readValue > Server.nb_secret) {
					outputStream.println("Plus petit");
					outputStream.flush();
				}
				else if(readValue < Server.nb_secret) {
					outputStream.println("Plus grand");
					outputStream.flush();
				}
				else {
					outputStream.println("Trouve");
					outputStream.flush();
					Server.est_fini[this.id] = true ;
				}
			}while(readValue != Server.nb_secret);
			
			System.out.println("Annonce du résultat coté " + this.id);
			
			while(Server.est_fini[1-this.id]==false) {this.sleep(500);};
			
			if(Server.nb_etapes[this.id] <= Server.nb_etapes[1-this.id]) {
				outputStream.println("Gagne");
				outputStream.flush();
				System.out.println("Le joueur " + this.id + " a gagne" );
			}
			else {
				outputStream.println("Perdu");
				outputStream.flush();
				System.out.println("Le joueur " + this.id + " a perdu" );
			}
			
			inputStream.close();
			outputStream.close();
			this.socket.close();
			
		} catch (IOException | InterruptedException e) {
			
			e.printStackTrace();
		}	
	}
}