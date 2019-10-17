/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cg3002012
 */
public class thr2 extends Thread {

    static Timer timer;
    static int interval;
    Socket connection;
    String teste;
    ArrayList<Socket> con = new ArrayList();
    tempo time = new tempo();

    public thr2(Socket conection) {
        this.connection = conection;

    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public boolean tempo() {
        while (true) {
            long inicio = System.currentTimeMillis();
            long fim = System.currentTimeMillis();
            long tempo = fim - inicio;
            if (tempo == 1) {
                return true;
            }
        }
    }

    @Override
    public void run() {

        try {
            Scanner read = new Scanner(System.in);
            PrintStream saida = new PrintStream(connection.getOutputStream());

            OUTER:
            while (read.hasNextLine()) {
                System.out.println("Lido Teclado: " + this.getId());
//                if (read.hasNextLine()) {
                    teste = read.nextLine();
                    saida.println(teste);
//                    time.run();
//                    try {
//                        time.sleep(1000);
//                        saida.println(getDateTime());
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(thr2.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                    
                    switch (teste) {
                        case "quit":
                        case "Quit":
                        case "QUit":
                        case "QUIt":
                        case "QUIT":
                        case "quiT":
                        case "quIT":
                        case "qUIT":
                            break OUTER;
                        case "time":
                        case "Time":
                        case "TIME":
                            //                    saida.println(getDateTime());
                            System.out.println(getDateTime());
                            break;

                    }
//                }

            }

            saida.close();
        } catch (IOException ex) {
            Logger.getLogger(thr2.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
