package MessageApp;

public class UDPServer {
    public static void main(String[] args) {

        DatagramSocket server = new DatagramSocket();
        InetAddress ipAddress = InetAddress.getLocalHost();




        byte[] buf = new byte[256];



        DatagramPacket pac = new DatagramPacket(buf, buf.length);

        //reading data from client

        server.recieve(pac);

        String response = new String(packet.getData());
        System.out.println("Recieved: " + response);

        server.close();

    }
}