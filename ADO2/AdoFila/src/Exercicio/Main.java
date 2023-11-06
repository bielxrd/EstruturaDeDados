package Exercicio;

import java.util.Scanner;

public class Main {
    static Scanner ler = new Scanner(System.in);
    public static FilaMesas<Mesas> mesas = new FilaMesas();
    public static Fila<Cliente> clientesN = new Fila<>();
    public static Fila<Cliente> clientesVip = new Fila<>();

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
                    System.out.println("Cliente vip adicionado com sucesso");
                } else {
                    clientesN.enqueue(new Cliente(nome));
                    System.out.println("Cliente padrao adicionado com sucesso");
                }

            } else if (opcao == 2) {
                opcaoMesas = menuMesas();

                if (opcaoMesas == 1) {
                    mesas.exibirDisponivel(mesas);

                    Cliente cliente = clientesVip.dequeue();

                    System.out.println("Escolha a mesa disponivel: ");
                    int n = ler.nextInt();

                    mesas.alocarMesa(mesas, cliente, n);

                } else if (opcaoMesas == 2) {
                    mesas.exibirDisponivel(mesas);
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
        return ler.nextInt();
    }

}
