package BuscaSequencialeBinaria;

public class minhaApp {
    public static void main(String[] args) {

        Colecao colecao = new Colecao();

        System.out.println("Posicao do elemento 23: "+colecao.buscaSequencial(23));
        System.out.println("Posicao do elemento 12: "+colecao.buscaSequencial(12));
        System.out.println("Posicao do elemento 76: "+colecao.buscaSequencial(76));
        System.out.println("Posicao do elemento 100: "+colecao.buscaSequencial(100));



    }
}
