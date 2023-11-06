package Exercicio;

public class Node<T> {

    private T elemento;
    private Node next;

    public Node(T elemento) {
        this.elemento = elemento;
        this.next = null;

    }

    public T getElemento() {
        return this.elemento;
    }

    public void setElemento(T aux) {
        this.elemento = aux;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
