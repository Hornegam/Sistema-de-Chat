/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cg3002012
 */
public class thr1 extends Thread {
    Socket connection ;
    ArrayList users ;
    
    public thr1(Socket conection){
        this.connection = conection ;
    }
    
    tempo time = new tempo();
    @Override
    public void run(){
        
        try {
            Scanner read = new Scanner(connection.getInputStream());
            while(read.hasNextLine()) {
                String aux = read.nextLine();
                System.out.println("Lido Socket: " + this.getId());
//                System.out.println(connection.getInetAddress().getHostAddress()+" : "+ read.nextLine());
                System.out.println(aux);
//                if (tempo.currentThread().equals(true)) {
////                    time.start();
//                }
            
            }
            read.close();
        } catch (IOException ex) {
            Logger.getLogger(thr1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    
    }
    
    
    
}
