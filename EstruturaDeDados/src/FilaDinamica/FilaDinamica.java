package FilaDinamica;

public class FilaDinamica {
    private Node inicio;
    private Node fim;

    public FilaDinamica() {
        this.inicio = null;
        this.fim = null;

    }

    public boolean isEmpty() {
        return (this.inicio == null);
    }

    // Inserir elemento
    public void enqueue(int dado) {
        Node novoNode = new Node(dado);

        if (inicio == null) {
            inicio = novoNode;
            fim = inicio;
        } else {

            fim.setNext(novoNode);
            fim = novoNode;
        }
    }

    public int dequeue() {

        if (isEmpty())
            return -1;

        Node tmp = inicio;
        inicio = inicio.getNext();
        if (inicio == null) {
            fim = null;
        }

        return tmp.getDado();

    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Fila vazia");
        } else {
            Node atual = inicio;
            while (atual != null) {
                System.out.println(atual.getDado());
                atual = atual.getNext();
            }

            System.out.println();

        }
    }

}
