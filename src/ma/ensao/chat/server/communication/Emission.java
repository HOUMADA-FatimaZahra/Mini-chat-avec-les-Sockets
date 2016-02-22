package ma.ensao.chat.server.communication;

import java.io.PrintWriter;
import java.util.Scanner;

public class Emission implements Runnable {

	private PrintWriter out;
	private String message = null;
	private Scanner sc = null;

	public Emission(PrintWriter out) {
		this.out = out;
	}

	@Override
	public void run() {
		sc = new Scanner(System.in);
		while (true) {
			System.out.println("Votre message :");
			message = sc.nextLine();

			out.println(message);
			out.flush();
		}
	}
}