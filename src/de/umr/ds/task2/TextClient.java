package de.umr.ds.task2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TextClient {

	public static void main(String[] args) {

		String URL = "localhost";
		int PORT = 1024;
		Socket socket = null;
		System.out.println("Client : input Text");
		BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
		try {
			while (true) {
				socket = new Socket(URL, PORT);
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				pw.println(readerConsole.readLine());
				pw.flush();

				InputStreamReader isr = new InputStreamReader(socket.getInputStream());
				BufferedReader reader = new BufferedReader(isr);

				System.out.println("Client : " + reader.readLine());

			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}