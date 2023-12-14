package BuscaSequencialeBinaria;

import java.sql.SQLOutput;

public class minhaApp {
    public static void main(String[] args) {

        Colecao colecao = new Colecao();


        System.out.println("------------------------- BUSCA SEQUENCIAL -------------------------");
        System.out.println("Posicao do elemento 23: "+colecao.buscaSequencial(23));
        System.out.println("Posicao do elemento 12: "+colecao.buscaSequencial(12));
        System.out.println("Posicao do elemento 76: "+colecao.buscaSequencial(76));
        System.out.println("Posicao do elemento 100: "+colecao.buscaSequencial(100));


        System.out.println("------------------------- BUSCA BINARIA -------------------------");
        System.out.println("Posicao do elemento 12: "+colecao.buscaBinaria(12));
        System.out.println("Posicao do elemento 23: "+colecao.buscaBinaria(23));
        System.out.println("Posicao do elemento 87: "+colecao.buscaBinaria(87));
    }
}
