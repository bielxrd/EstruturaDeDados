package Exercicio;

public class Pilha<T> {
    private Object pilha[];
    private int topo;

    public Pilha(int maxSize) {
        this.pilha = new Object[maxSize];
        this.topo = -1;
    }

    public void push(T item) {
        if (isFull())
            System.out.println("Pilha cheia!");
        else {
            topo++;
            pilha[topo] = item;
        }
    }

    public T peek() {
        T elemento;
        if(isEmpty())
            return null;
        else {
            return elemento = (T) pilha[topo];
        }
    }

    public boolean isFull() {
        if (pilha.length - 1 == topo)
            return true;
        else
            return false;
    }

    public T pop() {
        T elemento;
        if(!isEmpty()) {
            return elemento = (T) pilha[topo--];
        }
        else {
            return null;
        }
    }

    public boolean isEmpty() {
        if (topo == -1)
            return true;
        else
            return false;
    }

}
