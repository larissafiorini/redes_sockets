import java.io.*; // classes para input e output streams e
import java.net.*;// DatagramaSocket,InetAddress,DatagramaPacket

import java.io.*; // classes para input e output streams e
import java.net.*;// DatagramaSocket,InetAddress,DatagramaPacket

class UDPClient {
	public static void main(String args[]) throws Exception {

		// declara socket cliente
		DatagramSocket clientSocket = new DatagramSocket();

		// obtem endereco IP do servidor com o DNS
		InetAddress IPAddress = InetAddress.getByName("localhost");

		FileInputStream f = new FileInputStream("enviado.txt");

		int i = 0;
		byte b[] = new byte[12048];
		while (f.available() != 0) {
			b[i] = (byte) f.read();
			i++;
		}
		f.close();
		clientSocket.send(new DatagramPacket(b, i, IPAddress, 9875));

		// fecha o cliente
		clientSocket.close();
	}

}
