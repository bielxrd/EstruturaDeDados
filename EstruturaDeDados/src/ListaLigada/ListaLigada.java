package ListaLigada;

public class ListaLigada {

    private Node firstNode;

    private Node lastNode;

    public ListaLigada() {
        firstNode = lastNode = null;
    }

    public boolean isEmpty() {
        return (firstNode == null);
    }

    public void insertAtFront(Object data) {
        if (this.isEmpty())
            firstNode = lastNode = new Node(data);
        else
            firstNode = new Node(data, firstNode);
    }

    public void insertAtBack(Object data) {
        Node insertData = new Node(data);

        if (this.isEmpty())
            firstNode = lastNode = insertData;

        else {
            lastNode.setNextNode(insertData);
            lastNode = insertData;
        }
    }

    public Object removeFromFront() {
        if (this.isEmpty()) {
            return null;
        }

        Object removedItem = firstNode.getData();

        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else
            firstNode = firstNode.getNextNode();

        return removedItem;

    }

    public Object removeFromBack() {
        if (this.isEmpty()) {

        }

        Object removedItem = lastNode.getData();

        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            Node current = firstNode;

            while (current.getNextNode() != lastNode) {
                current = current.getNextNode();
            }

            lastNode = current;
            current.setNextNode(null);
        }

        return removedItem;
    }

    public void print() {

        if(this.isEmpty()) {
            System.out.println("LISTA vazia");
            return;
        }

        System.out.println("ELEMENTOS DA LISTA: ");
        Node current = firstNode;

        while (current != null) {
            System.out.println(current.getData() + " ");
            current = current.getNextNode();
        }

        System.out.println("\n");
    }

}
