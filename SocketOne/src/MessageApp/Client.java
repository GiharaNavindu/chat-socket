
package MessageApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    static String host = "localhost"; // Server hostname (IP Adress)since we are using the same computer we use localhost
    static int port = 9999;           // Server port

    public static void main(String[] args) throws IOException {
        System.out.println("\t\tSimple Socket Client");
        System.out.println("\t\t=======================");

        // Connect to the server
        Socket socket = new Socket(host, port);
        System.out.println("Server is connected\n\n");

        try {
            // Read message using BufferReader which is sent from the server using PrintWriter
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String messageFromServer = in.readLine();

            // Display the message
            System.out.println("Message from Server: " + messageFromServer);
            in.close();
        } finally {
            // Close the socket
            socket.close();
            
        }
    }
    
}
