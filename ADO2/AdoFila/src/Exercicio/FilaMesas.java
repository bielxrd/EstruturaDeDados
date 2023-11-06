package Exercicio;

import java.util.Scanner;

public class FilaMesas<T> extends Fila {
    static Scanner ler = new Scanner(System.in);

    public void quantidadeDisponivel(Fila<Mesas> mesas) {

        int quantidade = 0;
        for (int i = 0; i < mesas.size(); i++) {
            Mesas mesa = mesas.get(i);
            quantidade = mesa.getQuantidade();
        }

        System.out.println("Quantidade de mesas disponiveis: " + quantidade);
    }

    public void mesasDisponiveis(Fila<Mesas> mesas) {

        StringBuilder bd = new StringBuilder();

        Mesas mesa = null;
        for (int i = 0; i < mesas.size(); i++) {
            mesa = mesas.get(i);
        }

        bd.append("[");
        for (int i = 0; i < mesa.getMesas().length; i++) {

            if (mesa.getMesas()[i] == "Disponivel") {
                bd.append(i + ". " + mesa.getMesas()[i]);

                if (i < mesa.getMesas().length)
                    bd.append(", ");

            }

        }
        bd.append("]");
        System.out.println("Mesas Disponiveis: ");
        System.out.println(bd.toString());

    }

    public void allMesas(Fila<Mesas> mesas) {

        StringBuilder bd = new StringBuilder();

        Mesas mesa = null;
        for (int i = 0; i < mesas.size(); i++) {
            mesa = mesas.get(i);
        }

        bd.append("[");
        for (int i = 0; i < mesa.getMesas().length; i++) {

            if (mesa.getMesas()[i] == "Disponivel" || mesa.getMesas()[i] == "Ocupado") {
                bd.append(i + ". " + mesa.getMesas()[i]);

                if (i < mesa.getMesas().length)
                    bd.append(", ");

            }

        }
        bd.append("]");
        System.out.println("Mesas Disponiveis: ");
        System.out.println(bd.toString());

    }

    public void exibirDisponivel(Fila<Mesas> mesas) {
        quantidadeDisponivel(mesas);
        mesasDisponiveis(mesas);
    }

    public void alocarMesa(Fila<Mesas> mesas, Cliente cliente, int index) {
        Mesas mesa = mesas.dequeue();

        if (mesa.getMesas()[index] == "Ocupado") {

            while (mesa.getMesas()[index] == "Ocupado") {
                System.out.println("Mesa ocupada, informe outra.");
                index = ler.nextInt();
            }
        }

        mesa.setMesas(cliente, index);
        mesa.setQuantidade(mesa.getQuantidade() - 1);

        mesas.enqueue(mesa);

    }

    public void acessarMesa(Fila<Mesas> mesas, Fila<Cliente> clientes) {
        System.out.println("Qual mesa deseja acessar?");
        allMesas(mesas);
        int index = ler.nextInt();

        Mesas mesa = mesas.dequeue();

        System.out.println("Situacao = "+mesa.getMesas()[index]);
        System.out.println("Cliente na mesa = " +mesa.getNome(index));
        System.out.println("Vip = " +mesa.isVip(index));
        System.out.println("N da mesa = "+mesa.numeroMesa(index));

        mesas.enqueue(mesa);

    }

}
