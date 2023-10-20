package PilhaDinamica;

public class PilhaDinamica {
    private Node topo;

    public PilhaDinamica() {
        topo = null; // Pilha vazia
    }

    public boolean isEmpty() {
        return (topo == null);
    }

    public void push(int dd) {
        Node novoNode = new Node(dd);

        if (novoNode != null) {
            novoNode.next = topo;
            topo = novoNode;
        }
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        Node temp = topo;
        topo = topo.next;
        return temp.dado;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Pilha vazia");
        } else {
            Node atual = topo;

            while (atual != null) {
                atual.displayNode();
                atual = atual.next;
            }
            System.out.println();
        }
    }
}
