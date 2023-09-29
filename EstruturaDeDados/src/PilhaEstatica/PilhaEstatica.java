package PilhaEstatica;

public class PilhaEstatica {
    private int vetorPilha[];
    private int topo;

    public PilhaEstatica(int maxSize) {
        this.vetorPilha = new int[maxSize];
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
    
    public void push(int j) {
        if(isFull()) {
            System.out.println("Pilha cheia");
        } else {
            topo++;
            vetorPilha[topo] = j;
        }
    }

    public int pop() {
        if(!isEmpty()) {
            return vetorPilha[topo--];
        }
        else {
            return -1;
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

    

    
}
