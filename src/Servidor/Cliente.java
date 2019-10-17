package Servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException {

      Socket cliente = new Socket("192.168.100.20", 12345);

        System.out.println("O cliente se conectou ao servidor!");

        Scanner teclado = new Scanner(System.in);

        PrintStream saida = new PrintStream(cliente.getOutputStream());
        Scanner entrada = new Scanner(cliente.getInputStream());

        
        while (teclado.hasNextLine()){
            saida.println(teclado.nextLine());
            System.out.println(entrada.nextLine());
        }

        saida.close();

        teclado.close();
    }
}
