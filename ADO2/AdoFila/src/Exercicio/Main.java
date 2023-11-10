package Exercicio;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.Duration;
public class Main {
    static Scanner ler = new Scanner(System.in);
    public static FilaMesas<Mesas> mesas = new FilaMesas();
    public static Fila<Cliente> clientesN = new Fila<>();
    public static Fila<Cliente> clientesVip = new Fila<>();
    public static Fila<Cliente> clientesPrio = new Fila<>();
    
    public static void main(String[] args) {
        mesas.enqueue(new Mesas(30));

        int opcao = 0;
        int opcaoMesas = 0;

        do {
          

            opcao = menu();

            

            if (opcao == 1) {

                System.out.println("Informe o nome do cliente: ");
                ler.nextLine();
                String nome = ler.nextLine();
                System.out.println("Informe se e vip? (true/false)");
                boolean vip = ler.nextBoolean();

                if (vip == true) {
                    clientesVip.enqueue(new Cliente(nome, vip));
                    System.out.println("\n|Cliente vip adicionado com sucesso|\n");
                } else {
                    clientesN.enqueue(new Cliente(nome));
                    System.out.println("\n|Cliente padrao adicionado com sucesso|\n");
                }

            } else if (opcao == 2) {
               try{
                    reorgFilas();
                    } catch (Exception e){

                        } 
                    
                System.out.println();
                opcaoMesas = menuMesas();
                

                if (opcaoMesas == 1) {
                    mesas.exibirDisponivel(mesas);
                    //Inserir verificação se tem mesas disponíveis e só realocar com base na disponibilidade
                    
                    if(!clientesPrio.isEmpty()){
                        Cliente cliente = clientesPrio.dequeue();
                        System.out.println("Cliente na Lista prioritária");
                        System.out.println("Escolha a mesa disponivel: (Cliente: " +cliente.getNome()+ ")");
                        int n = ler.nextInt();

                        mesas.alocarMesa(mesas, cliente, n);
                    }
                    else if(!clientesVip.isEmpty()){
                         while (!clientesVip.isEmpty()) {
                        Cliente cliente = clientesVip.dequeue();
                        /*System.out.println(cliente.getDate());
                        LocalDateTime teste = null;
                        teste = teste.now();*/
                        System.out.println("Cliente na lista Vip encontrado");
                        System.out.println("Escolha a mesa disponivel: (Cliente " +cliente.getNome()+ ")");
                        int n = ler.nextInt();

                        mesas.alocarMesa(mesas, cliente, n);
                    } 
                    }
                        else if(!clientesN.isEmpty()){
                        System.out.println("Lista prioritária vazia");
                        System.out.println("Lista vip vazia");
                        System.out.println("Chamando clientes da lista comum: ");
                        Cliente cliente = clientesN.dequeue();

                        System.out.println("Escolha a mesa disponivel: (Cliente: " +cliente.getNome()+ ")");
                        int n = ler.nextInt();

                        mesas.alocarMesa(mesas, cliente, n);
                    }
                    else{
                        System.out.println("Ninguém na fila");
                    }

                } else if (opcaoMesas == 2) {
                    mesas.exibirDisponivel(mesas);
                } else if(opcaoMesas == 3) {
                    mesas.acessarMesa(mesas, clientesVip);
                }
            }

        } while (opcao != 0);

    }

    public static int menu() {
        System.out.println("1. Cadastrar cliente");
        System.out.println("2. Alocar mesa");
        System.out.println("0. Sair");
        return ler.nextInt();
    }

    public static int menuMesas() {
        System.out.println("1. Alocar cliente");
        System.out.println("2. Disponivel");
        System.out.println("3. Acessar mesa");
        return ler.nextInt();
    }

    public static boolean reorg(){
        Cliente c = front();
        LocalDateTime t = c.getDate();
        int hourClient = hoursToMinute(t);
        int minuteClient = t.getMinute();
        int totalMinuteCLient = hourClient + minuteClient;
        int totalMinuteWait = totalMinuteCLient + 20;
        LocalDateTime now = null;
        now = now.now();
        int HourNow = hoursToMinute(now);
        int MinuteNow = now.getMinute();
        int MinuteNowTotal = HourNow + MinuteNow;
        return (MinuteNowTotal>=totalMinuteWait);
    }
    public static int hoursToMinute(LocalDateTime t){
        int hourClient = t.getHour();
        int hourToMinute = hourClient * 60;
        return hourToMinute;
    }
    public static void reorgFilas(){
        boolean check = reorg();
        //System.out.println("check" + check);
        if(check == true){
            Cliente n = clientesN.dequeue();
            clientesPrio.enqueue(n);
           // System.out.println(n.getNome()+" Na lista prioritária");
        }
    }
    public static Cliente front(){
        return clientesN.get(0);
    }
}
