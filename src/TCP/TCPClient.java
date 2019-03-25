package TCP;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) throws Exception {

		// Inicializa socket
		Socket socket = new Socket(InetAddress.getByName("localhost"), 5000);

		// Arquivo que sera enviado para o server
		File file = new File("enviado.txt");
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);

		// Get socket's output stream
		OutputStream os = socket.getOutputStream();

		// Le conteudo do arquivo que sera enviado
		byte[] contents;
		long fileLength = file.length();
		long current = 0;

		long start = System.nanoTime();
		while (current != fileLength) {
			int size = 10000;
			if (fileLength - current >= size)
				current += size;
			else {
				size = (int) (fileLength - current);
				current = fileLength;
			}
			contents = new byte[size];
			bis.read(contents, 0, size);
			System.out.println(contents);
			os.write(contents);
			System.out.print("Enviando arquivo... " + (current * 100) / fileLength + "% concluido!");
		}

		os.flush();
		socket.close();

		System.out.println("Arquivo enviado com sucesso!");
	}
}
