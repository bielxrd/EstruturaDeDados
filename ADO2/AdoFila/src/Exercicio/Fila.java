package Exercicio;

public class Fila<T> {
    private Node inicio;
    private Node fim;

    public Fila() {
        this.inicio = null;
        this.fim = null;
    }

    public void enqueue(T elemento) {
        Node novoNodo = new Node<T>(elemento);

        if (inicio == null) {
            inicio = novoNodo;
            fim = inicio;
        } else {
            fim.setNext(novoNodo);
            fim = novoNodo;
        }

    }

    public T dequeue() {

        if(isEmpty())
        return null;

        Node temp = inicio;
        inicio = inicio.getNext();

        if(inicio == null) {
            fim = null;
        } 

        return (T) temp.getElemento();

    }

    public boolean isEmpty() {
        return (this.inicio == null);
    }

}
