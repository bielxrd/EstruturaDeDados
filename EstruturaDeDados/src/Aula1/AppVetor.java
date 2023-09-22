package Aula1;
/**
 * @(#)AppVetor.java
 *
 */
public class AppVetor {

    public static void main(String[] args) {
        int tamanho = 100;
        Vetor arr = new Vetor(tamanho);

        arr.add(77);
        arr.add(99);
        arr.add(44);
        arr.add(55);
        arr.add(22);
        arr.add(88);
        arr.display();

        if (arr.procurar(35))
            System.out.println("Achou " + 35);
        else
            System.out.println("O valor " + 35+" nao foi cadastrado");

        arr.remover(55);
    }
}