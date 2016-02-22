package ma.ensao.chat.server.communication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AccepterConnexion implements Runnable {
	private ServerSocket socketserver = null;
	private Socket socket = null;
	public Thread t1;

	public AccepterConnexion(ServerSocket ss) {
		this.socketserver = ss;
	}

	@Override
	public void run() {
		try {
			while (true) {
				socket = socketserver.accept();
				System.out.println("Un client veut se connecter ");
				t1 = new Thread(new Authentification(socket));
				t1.start();
			}
		} catch (IOException e) {
			System.err.println("Erreur serveur");
		}
	}
}