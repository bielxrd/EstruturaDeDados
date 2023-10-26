package FilaDinamica;

public class Node {
    private int dado;
    private Node next;

    public Node(int dado) {
        this.dado = dado;
        this.next = null;

    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
