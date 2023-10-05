package PilhaEstatica;

public class PilhaEstatica<T> {
    private Object pilhaEstatica[];
    private int topo;

    public PilhaEstatica(int maxSize) {
        this.pilhaEstatica = new Object[maxSize];
        this.topo = -1;
    }
    public PilhaEstatica() {
        this.pilhaEstatica = new Object[10];
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

    public T peek() {
        T elemento;
        if (isEmpty()) {
            return null;
        } else {
            return elemento = (T) pilhaEstatica[topo];
        }
    }

    public T pop() {
        T elemento;
        if (!isEmpty()) {
            return elemento = (T) pilhaEstatica[topo--];
        } else {
            return null;
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
