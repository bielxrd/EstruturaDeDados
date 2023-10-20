package PilhaDinamica;

public class PilhaDinamica<T> {
    private Node topo;

    public PilhaDinamica() {
        topo = null; // Pilha vazia
    }

    public boolean isEmpty() {
        return (topo == null);
    }

    public void push(T elemento) {
        Node novoNode = new Node(elemento);

        if (novoNode != null) {
            novoNode.next = topo;
            topo = novoNode;
        }
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        Node temp = topo;
        topo = topo.next;
        return (T) temp.dado;
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
