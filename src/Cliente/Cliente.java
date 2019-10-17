package Cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
     public static void main(String[] args) throws UnknownHostException, IOException {
     
        Socket cliente = new Socket("192.168.100.6", 12345);
     
        System.out.println("O cliente "+cliente.getInetAddress().getHostAddress()+ " se conectou ao servidor!");
   
   
        thr1 ler = new thr1(cliente);
        thr2 escrever = new thr2(cliente);
        
        
        ler.start();
        escrever.start();
        
        
        
        
   }
}
