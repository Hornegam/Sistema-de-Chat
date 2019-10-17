package Servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Servidor {
        
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(12345);
        ArrayList <ThrServidor> login = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        System.out.println("Porta 12345 aberta! Aguardando conexão...");
        
        boolean aux = true;
        while (aux) {
            Socket cliente = servidor.accept();
            ThrServidor f2 = new ThrServidor(cliente, login, name);
            f2.start();
            System.out.println("\nNova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
            System.out.println("\nEsse socket ficará aberto até que o cliente se desconecte");
            login.add(f2);
        }

        servidor.close();
    }
}
