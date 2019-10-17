/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author cg3002012
 */
public class Mensagem {

    Socket connection;

    public Mensagem(Socket conection) {
        connection = conection;

    }

    public void saida() throws IOException {
        Scanner read = new Scanner(System.in);
        PrintStream saida = new PrintStream(connection.getOutputStream());

        while (read.hasNextLine()) {
            System.out.println("Eu : ..");
            saida.println(read.nextLine());
            if (read.nextLine() == "quit") {
                break;
            }
        }
        read.close();
        saida.close();

    }
    
    public void entrada() throws IOException{
        Scanner read = new Scanner(connection.getInputStream());
        while(read.hasNextLine()){
            System.out.println("O cliente digitou :"+ read.nextLine());
            System.out.println("Digite sua resposta : ");
        
        
        }
        read.close();
    
    
    
    }
}
