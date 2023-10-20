package PilhaDinamica;

public class Node {
    public int dado;
    public Node next;

    public Node(int dd) {
        dado = dd;
        next = null;

    }

    public void displayNode() {
        System.out.println(dado);
    }
}
