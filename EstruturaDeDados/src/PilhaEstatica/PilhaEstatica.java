package PilhaEstatica;

public class PilhaEstatica {
    private int pilhaEstatica[];
    private int topo;

    public PilhaEstatica(int maxSize) {
        this.pilhaEstatica = new int[maxSize];
        this.topo = -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Pilha cheia!");
        } else {
            topo++;
            pilhaEstatica[topo] = x;
        }
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        } else {
            return pilhaEstatica[topo];
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return pilhaEstatica[topo--];
        } else {
            return -1;
        }
    }

    public String toString() {
        StringBuilder aux = new StringBuilder();

        aux.append("[");
        for (int i = 0; i <= topo; i++) {
            aux.append(pilhaEstatica[i]);

            if (i < topo)
                aux.append(", ");
        }
        aux.append("]");
        return aux.toString();

    }

    public boolean isEmpty() {
        if (topo == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (pilhaEstatica.length - 1 == topo) {
            return true;
        } else {
            return false;
        }
    }
}
