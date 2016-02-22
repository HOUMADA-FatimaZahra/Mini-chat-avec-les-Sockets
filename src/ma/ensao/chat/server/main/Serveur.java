package ma.ensao.chat.server.main;

import java.io.IOException;
import java.net.ServerSocket;

import ma.ensao.chat.server.communication.AccepterConnexion;

public class Serveur {

	public static ServerSocket ss = null;
	public static Thread t;

	public static void main(String[] args) {
		try {
			ss = new ServerSocket(2009);
			System.out.println("Le serveur est à l'écoute du port " + ss.getLocalPort());
			t = new Thread(new AccepterConnexion(ss));
			t.start();
		} catch (IOException e) {
			System.err.println("Le port " + ss.getLocalPort() + " est déjà utilisé !");
		}
	}
}