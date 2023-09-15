package Aula1;

public class Vetor {

    private int vetor[];
    private int quantidade;

    public Vetor(int tamanho) {
        this.vetor = new int[tamanho];
        this.quantidade = -1;
    }

    public boolean isEmpty() {
        if (quantidade == -1) {
            return true;
        } else {
            return false;
        }

    }
    public boolean isFull() {
        if(quantidade == vetor.length) {
            return true;
        }
        else {
            return false;
        }
    }

}
