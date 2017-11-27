
// File Name GreetingServer.java
import java.net.*;
import java.io.*;

public class Server extends Thread {

	private static ServerSocket serverSocket = null;
	private static Socket socket = null;
	private static ObjectInputStream inStream = null;
	private static Integer port = 19989;
	private static String filePathSave = "D:/text.txt";

	private static void communicate() {
		System.out.println("Server started");

		while (true) {
			try {
				serverSocket = new ServerSocket(port);
				socket = serverSocket.accept();
				System.out.println("Connected");
				inStream = new ObjectInputStream(socket.getInputStream());

				Shapes clientShape = (Shapes) inStream.readObject();
				System.out.println("Object received = " + clientShape.getName());

				socket.close();

			} catch (SocketException se) {
				se.printStackTrace();
				System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException cn) {
				cn.printStackTrace();
			}			
		}
	}

	@SuppressWarnings("unused")
	private static void WriteToFile(Shapes clientShape) throws Exception, UnsupportedEncodingException {
		// write object to file
		FileOutputStream fos = new FileOutputStream(filePathSave);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(clientShape);
		oos.close();

		// read object from file -- not working!!
		FileInputStream fis = new FileInputStream(filePathSave);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Shapes result = (Shapes) ois.readObject();
		ois.close();
	}

	public static void main(String[] args) {		
		communicate();
	}
}
