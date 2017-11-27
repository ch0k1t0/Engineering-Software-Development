import java.util.ArrayList;
import java.util.Scanner;
import java.net.*;
import java.io.*;

public class Main {

	static String serverName = "";
	static Integer port = 19989;
	static ArrayList<Shapes> arrayShape = new ArrayList<Shapes>();
	private static boolean isConnected = false;
	private static Socket socket = null;
	private static ObjectOutputStream outputStream = null;

	public static void main(String[] args) throws Exception {
		Menu mainMenu = new Menu();
		Shapes selectedShape = null;
		String menu1Selection = mainMenu.CreateFirstMenu();

		if (menu1Selection.equals("1")) {
			// create the 2d menu
			try {
				selectedShape = mainMenu.Create2DMenu();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (menu1Selection.equals("2")) {
			// create the 3d menu
		} else {
			System.out.println("Invalid Selection");
		}

		//add shape to arraylist
		arrayShape.add(selectedShape);
		
		//send shape to server
		SendShapes(selectedShape);
	}

	private static void SendShapes(Shapes clientShape) {
		// https://www.tutorialspoint.com/java/java_networking.htm
		/*
		 * try { System.out.println("Connecting to " + serverName + " on port " + port);
		 * Socket client = new Socket(serverName, port);
		 * 
		 * System.out.println("Just connected to " + client.getRemoteSocketAddress());
		 * OutputStream outToServer = client.getOutputStream(); DataOutputStream out =
		 * new DataOutputStream(outToServer);
		 * 
		 * out.writeUTF("Hello from " + client.getLocalSocketAddress()); InputStream
		 * inFromServer = client.getInputStream(); DataInputStream in = new
		 * DataInputStream(inFromServer);
		 * 
		 * System.out.println("Server says " + in.readUTF()); client.close(); } catch
		 * (IOException e) { e.printStackTrace(); }
		 */

		System.out.println("start");

		// http://www.coderpanda.com/java-socket-programming-transferring-of-java-objects-through-sockets/
		while (!isConnected) {
			try {
				socket = new Socket("localHost", port);
				System.out.println("Connected");
				isConnected = true;
				outputStream = new ObjectOutputStream(socket.getOutputStream());
				//Triangle student = new Triangle(1, 1, 1);
				System.out.println("Object to be written = " + clientShape.getName());
				outputStream.writeObject(clientShape);
				socket.close();
			} catch (SocketException se) {
				// se.printStackTrace();
				// System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("End Connection");

	}

	/*
	 * private static ArrayList<Shapes> ReceiveShapes() {
	 * 
	 * }
	 */

}
