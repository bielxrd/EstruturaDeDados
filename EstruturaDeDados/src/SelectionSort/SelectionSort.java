package SelectionSort;

public class SelectionSort {
    private int vetor[] = {25, 57, 48, 37, 12, 92, 33};

    public void selectionSort() { // SelectionSort
        int it, temp; // Iterador
        int posMenor; // Posicao do menor elemento
        int posMenorInicial; // Posicao do menor elemento inicial
        int i;

        for (it = 0; it < vetor.length - 1; it++) { // Itera sobre o vetor

            posMenorInicial = it; // Posicao do menor elemento inicial
            posMenor = it + 1;
            for (i = posMenorInicial + 1; i < vetor.length; i++) {
                if (vetor[i] < vetor[posMenor]) { // Se o elemento atual for menor que o menor elemento
                    posMenor = i; // Atualiza a posicao do menor elemento
                }

            }
            System.out.println("Menor elemento encontrado na iteracao: " + posMenor);
            if (vetor[posMenor] < vetor[posMenorInicial]) { // Se o menor elemento for menor que o menor elemento inicial
                // Troca
                temp = vetor[posMenorInicial];
                vetor[posMenorInicial] = vetor[posMenor];
                vetor[posMenor] = temp;
            }
            System.out.println("Iteracao = "+it);
            mostraVetor();
        }

    }

    public void mostraVetor() {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }
}
