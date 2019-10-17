package Servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ThrServidor extends Thread {

    Socket cliente;
    ArrayList<ThrServidor> login = new ArrayList<>();
    ArrayList<String> name = new ArrayList<>();
    String aux, nome, nome2;

    public ThrServidor(Socket cliente, ArrayList<ThrServidor> login, ArrayList<String> name) {
        this.cliente = cliente;
        this.login = login;
        this.name = name;
    }

    public ThrServidor(Socket cliente) {
        this.cliente = cliente;
    }

    public void run() {
        try {
            Scanner entrada = new Scanner(cliente.getInputStream());
            nome = entrada.nextLine();
            if (nomeDuplicado(nome)) {
                while (entrada.hasNextLine()) {
                    aux = entrada.nextLine();
                    //if(aux.contains("id_")){
                    //  String vet[] = new String[2];
                    //vet = aux.split("_");
                    //nome = vet[1];
                    //}
                    System.out.printf("\nO Cliente " + nome2 + " digitou: " + aux);
                    for (ThrServidor cliente : login) {
                        cliente.enviar(name.toString());
                        cliente.enviar("O cliente " + nome2 + " enviou: " + aux);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Deu ruim!");
        }
    }

    /**
     *
     */
    public String toString(){
    
    return "lista_usuarios "+name+" ;";
    }
    
    
    public void enviar(String aux) throws IOException {

        PrintStream saida = new PrintStream(cliente.getOutputStream());
        saida.println(aux);
    }

    private boolean nomeDuplicado(String nome) throws IOException {
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        Scanner read = new Scanner(cliente.getInputStream());
        for (ThrServidor conectado : this.login) {
            for (int i = 0; i < name.size(); i++) {
                while(nome.equals(name.get(i))) {
                    saida.println("O nome do usuário não pôde ser registrado pois é inválido ou já está em uso");
                    nome = read.nextLine();
//                    return false;
                }
            }
        }
        this.nome2 = nome ;
        saida.println("O nome de usuário foi registrado com sucesso");
        name.add(nome2);
        return true;
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ThrServidor> getLogin() {
        return login;
    }

    public void setLogin(ArrayList<ThrServidor> login) {
        this.login = login;
    }

    public String getAux() {
        return aux;
    }

    public void setAux(String aux) {
        this.aux = aux;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
