package PilhaEstatica.Exercicio;

public class PilhaExc {
    private char vetorPilha[];
    private int topo;

    public PilhaExc(int maxSize) {
        this.vetorPilha = new char[maxSize];
        this.topo = -1;
    }

    public boolean isEmpty() {
        if (topo == -1) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isFull() {
        if (topo == vetorPilha.length - 1) {
            return true;
        } else {
            return false;
        }
    }
    
    public void push(char j) {
        if(isFull()) {
            System.out.println("Pilha cheia");
        } else {
            topo++;
            vetorPilha[topo] = j;
        }
    }

    public char pop() {
        if(!isEmpty()) {
            return vetorPilha[topo--];
        }
        else {
            return '\0';
        }
    }

    public int indexOf(int j) {
        for (int i = 0; i < vetorPilha.length; i++) {
            if (vetorPilha[i] == j) {
                return i;
            }
        }
        return -1;
    }
    public int size() {
        return vetorPilha.length;
    }
    
}
