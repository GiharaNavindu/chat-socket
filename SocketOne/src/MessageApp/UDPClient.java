package MessageApp;

public class UDPClient {
    public static void main(String[] args) {

        DatagramSocket client = new DatagramSocket();
        InetAddress ipAddress = InetAddress.getLocalHost();



        String str = "Hello WOrld";
        byte[]buf = str.getBytes();// get the string and converts to byte array



        DatagramPacket pac = new DatagramPacket(buf, buf.length, ipAddress, 8888);

        client.send(pac);

        client.close();

    }
}