package QuickSort;

public class QuickSort {

    private int vetor[] = {25, 57, 48, 37, 12, 92, 33};

    public int partition(int inicio, int fim) {
        int ref, up, down, temp;

        ref = vetor[inicio];
        down = inicio;
        up = fim;

        while (down < up) {


            // Encontrando um numero maior que o pivo(ref)

            while (vetor[down] <= ref && down < fim) {
                down++; // Avanco para encontrar um valor maior
            }

            // Encontrar a partir do fim um velor menor que o meu de referencia

            while (vetor[up] > ref) {
                up--;
            }

            if (down < up) { // Eles nao se cruzaram nos indicies
                // Troca
                temp = vetor[down];
                vetor[down] = vetor[up];
                vetor[up] = temp;

            }
        }
        vetor[inicio] = vetor[up];
        vetor[up] = ref;
        return up; // Posicao que denota onde esta o pivo.

    }

    public void quickSort(int inicio, int fim) {
        int pivo;

        if (inicio >= fim) {
            return;
        }
        pivo = partition(inicio, fim);
        quickSort(inicio, pivo - 1);
        quickSort(pivo + 1, fim);

    }

    public void mostraVetor() {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
    }

    public int[] getVetor() {
        return vetor;
    }

    public void setVetor(int[] vetor) {
        this.vetor = vetor;
    }
}



