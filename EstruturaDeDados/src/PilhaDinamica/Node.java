package PilhaDinamica;

public class Node <T> {
    public T dado;
    public Node next;

    public Node(T elemento) {
        dado = elemento;
        next = null;

    }

    public void displayNode() {
        System.out.println(dado);
    }
}
