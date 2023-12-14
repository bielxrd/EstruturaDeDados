package BubbleSort;

public class AlgoritmosDeOrdenacao {
    private int[] vetor = {25, 57, 48, 37, 12, 92, 33};

    public void setVetor(int[] vetor) {
        this.vetor = vetor;
    }

    public void bubbleSort() {
        int i;
        int pos;
        int temp;

        for (i = 0; i < vetor.length - 1; i++) {
            for (pos = 0; pos < vetor.length - i - 1; pos++) {
                // Comparo o elemento da posicao com seu proximo
                if (vetor[pos] > vetor[pos + 1]) {
                    // Entao troca
                    temp = vetor[pos];
                    vetor[pos] = vetor[pos + 1];
                    vetor[pos + 1] = temp;
                }
            }
        }
        System.out.println("Final da iteracao: "+i);
        mostraVetor();
    }

    public void mostraVetor() {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println("");
    }

}
