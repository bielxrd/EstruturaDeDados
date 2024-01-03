package QuickSort;

public class MainQuick {
    public static void main(String[] args) {
        QuickSort alg = new QuickSort();

        alg.quickSort(0, alg.getVetor().length-1);
        alg.mostraVetor();
    }
}
