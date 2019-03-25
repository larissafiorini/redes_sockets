
// Recebe um pacote de algum cliente
// Separa o dado, o endere�o IP e a porta deste cliente
// Imprime o dado na tela

//Recebe um pacote de algum cliente
//Separa o dado, o endereco IP e a porta deste cliente
//Imprime o dado na tela

import java.io.*;
import java.net.*;

class UDPServer {
	public static void main(String args[]) throws Exception {
		// cria socket do servidor com a porta 9876
		DatagramSocket serverSocket = new DatagramSocket(9875);

		byte[] receiveData = new byte[1024];
		while (true) {
			// declara o pacote a ser recebido
//			DatagramPacket receivePacket = new DatagramPacket(receiveData,
//					receiveData.length);

			// recebe o pacote do cliente
//			serverSocket.receive(receivePacket);

			// pega os dados, o endereco IP e a porta do cliente
			// para poder mandar a msg de volta
//			String sentence = new String(receivePacket.getData());
//			InetAddress IPAddress = receivePacket.getAddress();
//			int port = receivePacket.getPort();

			byte b[] = new byte[3072];

			FileOutputStream f = new FileOutputStream(
					"C:\\Users\\ESCOLA VILA GRAN\\Documents\\labredes\\recebido.txt");
			while (true) {
				DatagramPacket dp = new DatagramPacket(b, b.length);
				serverSocket.receive(dp);
				f.write(dp.getData(), 0, dp.getLength());
				System.out.println(new String(dp.getData(), 0, dp.getLength()));
				
				

			}

//			System.out.println("Mensagem recebida: " + sentence);
		}

	}
}

