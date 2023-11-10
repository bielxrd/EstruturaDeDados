package ListaLigada;

public class Node {

    public Object data;

    public Node nextNode;

    public Node(Object object) {
        this(object, null);
    }

    public Node(Object object, Node node) {
        this.data = object;
        this.nextNode = node;

    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

}
