package Cliente;



import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(12345);
        ArrayList arm = null;
        System.out.println("Porta 12345 aberta! Aguardando conexão...");
        Scanner read = new Scanner(System.in);
        boolean aux = true;

        while (aux != false) {
            Socket cliente = servidor.accept();
            thrServidor server = new thrServidor(cliente);
            server.start();
            System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
            System.out.println("Esse socket ficará aberto até que o cliente se desconecte");
            arm.add(server);
        }

//
//        thr1 ler = new thr1(cliente);
//        thr2 escrever = new thr2(cliente);
//
//        ler.start();
//        escrever.start();
        servidor.close();

    }
}
