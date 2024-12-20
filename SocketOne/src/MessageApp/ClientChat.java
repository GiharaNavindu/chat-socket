package MessageApp; // Package declaration

import java.io.BufferedReader; // Import for reading input
import java.io.IOException; // Import for handling IO exceptions
import java.io.InputStreamReader; // Import for converting byte streams to character streams
import java.io.PrintWriter; // Import for writing output
import java.net.Socket; // Import for client socket
import java.util.Scanner; // Import for reading user input

public class ClientChat {

    static String host = "localhost"; // Define the server address (localhost for local testing)
    static int port = 7999;           // Define the port number for the server

    public static void main(String[] args) throws IOException { // Main method
        System.out.println("\t\tSimple Socket Client"); // Print client title
        System.out.println("\t\t======================="); // Print separator

        // Connect to the server
        Socket socket = new Socket(host, port); // Create a socket to connect to the server
        System.out.println("Server is connected\n\n"); // Notify that the client is connected to the server

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Create input stream to read messages from the server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Create output stream to send messages to the server
            Scanner scannerInput = new Scanner(System.in); // Create a scanner for user input
            String messageFromServer = in.readLine(); // Read welcome message from the server

            // Display the message from the server
            System.out.println("Message from Server: " + messageFromServer); // Print the welcome message

            // Chat loop
            String clientInput; // Variable to hold client input
            while (true) { // Infinite loop for chatting
                System.out.print("Client: "); // Prompt for client input
                clientInput = scannerInput.nextLine(); // Read input from the console
                out.println(clientInput); // Send client input to the server

                // Exit condition
                if (clientInput.equalsIgnoreCase("exit")) { // Check if the client wants to exit
                    System.out.println("Exiting chat..."); // Notify that the chat is ending
                    break; // Exit the loop
                }

                // Read response from server
                String responseFromServer = in.readLine(); // Read response from the server
                System.out.println("Message from Server: " + responseFromServer); // Print the server's response
            }

            scannerInput.close(); // Close the scanner after use
        } finally {
            // Close the socket
            socket.close(); // Close the socket connection to the server
        }
    }
}
