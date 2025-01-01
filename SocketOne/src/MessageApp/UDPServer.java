package MessageApp;

public class UDPServer {
    public static void main(String[] args) {

        DatagramSocket server = new DatagramSocket();
        InetAddress ipAddress = InetAddress.getLocalHost();



        String str = "Hello WOrld";
        byte[]buf = str.getBytes();// get the string and converts to byte array



        DatagramPacket pac = new DatagramPacket(buf, buf.length, ipAddress, 8888);

        server.send(pac);

        server.close();

    }
}