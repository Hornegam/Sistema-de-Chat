/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author cg3002012
 */
public class thrServidor extends Thread {

    Socket connection;
    ArrayList<thrServidor> user = new ArrayList<>();

    public thrServidor(Socket conection, ArrayList<thrServidor> login) {
        this.connection = conection;
        this.user = login;
    }
    public thrServidor(Socket conection) {
        this.connection = conection;
        
    }

    @Override
    public void run() {
//        System.out.println("Nova conexão com o cliente " + connection.getInetAddress().getHostAddress());
        thr1 ler = new thr1(connection);
        thr2 escrever = new thr2(connection);

        ler.start();
        escrever.start();

    }

}
