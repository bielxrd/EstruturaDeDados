package InsertionSort;

public class InsertionSort {

    private int vetor[] = {25, 57, 48, 37, 12, 92, 33};

    public void insertionSort() {
        int carta, it, j;

        // A iteracao vai selecionar a carta da vez,e a partir disso, puxar todos os elementos que sao maiores do que ele
        for (it = 1; it < vetor.length; it++) {
            carta = vetor[it]; // Guardo a carta

            for (j = it - 1; (j >= 0) && vetor[j] > carta; j--) {
                vetor[j + 1] = vetor[j]; // Estou trocando todos que sao maiores do que eu
            }
            vetor[j+1] = carta;
            System.out.println("Iteracao = " + it);
            mostraVetor();
        }
    }

    public void mostraVetor() {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
    }

}
