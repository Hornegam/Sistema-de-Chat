/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author cg3002012
 */
public class tempo extends Thread {

    public tempo() {
    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

//     public void keyPressed(KeyEvent evt) {
//        //abaixo é só mudar o ENTER para o código que da tecla que vc deseja...
//        while (KeyEvent.VK_ENTER == true) {
//            run();
//        }
//    }public void keyTyped(KeyEvent evt) {
//
//    }
//
//    public void keyPressed(KeyEvent evt) {
//        //abaixo é só mudar o ENTER para o código que da tecla que vc deseja...
//        while (KeyEvent.VK_ENTER == true) {
//            run();
//        }
//    }

    @Override
    public void run() {
        while (true) {
            try {

                
                Thread.sleep(1000);

            } catch (Exception e) {
            }
        }

    }
}
