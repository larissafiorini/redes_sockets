
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

		byte[] receiveData = new byte[12048];
		while (true) {

			byte b[] = new byte[12048];

			FileOutputStream f = new FileOutputStream("recebido.txt");
			while (true) {
				// declara o pacote a ser recebido
				DatagramPacket dp = new DatagramPacket(b, b.length);
				// recebe o pacote do cliente
				serverSocket.receive(dp);
				f.write(dp.getData(), 0, dp.getLength());
				System.out.println("Arquivo salvo com sucesso!");
				System.out.println(new String(dp.getData(), 0, dp.getLength()));
				
			}

		}

	}
}
