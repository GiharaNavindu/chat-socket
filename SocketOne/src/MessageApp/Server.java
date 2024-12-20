package MessageApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	static int port =9999;
	
	
	public static void main(String[] args) throws IOException {//throw away all the exceptions
		// TODO Auto-generated method stub
		System.out.println("\t\tSimple Socket Server");
		System.out.println("\t\t======================");
		
		ServerSocket serversocket = new ServerSocket(port);
		
		
		try {
			while(true){//never ending loop
				Socket socket = serversocket.accept();
				System.out.println("Client is connected....\n\n");
				
				
				
				//message to the the client side
				//we use printwriter
				
				try {
					PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
					out.println("Welcome to Socket Programming");
				}
				finally {
					socket.close();// socket is closed after sending the message to the client side
				}
			}
		}
		
		//No catch bcz we use IOException in the main class
		
		finally {
			serversocket.close();
		}
	}

}

