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

    public int size() {
        int contador = 0;
        Node<T> currentNode = inicio;
    
        while (currentNode != null) {
            contador++;
            currentNode = currentNode.getNext();
        }
    
        return contador;
    }

    public T get(int position) {
        if (position < 0 || position >= size()) {
            throw new IndexOutOfBoundsException("Posição fora dos limites da fila");
        }
    
        Node <T> nodeAtual = inicio;
        for (int i = 0; i < position; i++) {
            nodeAtual = nodeAtual.getNext();
        }
    
        return nodeAtual.getElemento();
    }
    
}
