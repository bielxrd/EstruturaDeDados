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

        if (this.isEmpty()) {
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

    /* Metodos sugeridos pelo professor (exercicios) */

    public int count() {
        int contador = 0;
        if (firstNode == null) {
            return 0;
        } else {
            Node atual = firstNode;

            while (atual != null) {
                atual = atual.getNextNode();
                contador++;
            }
        }

        return contador;
    }

    public int find(Object item) {
        if (isEmpty()) {
            return -1;
        }

        Node current = firstNode;
        int pos = 0;

        while (current != null) {
            if (current.data == item) {
                return (pos);
            }
            current = current.getNextNode();
            pos++;
        }
        return -1;
    }

    public boolean joinList(ListaLigada listaAux) {
        if (isEmpty() || listaAux.isEmpty()) {
            return false;
        } else {
            lastNode.nextNode = listaAux.firstNode;
            lastNode = listaAux.lastNode;
            return true;
        }
    }

    public boolean remove(Object valor) {
        Node atual = firstNode;
        Node anterior;
    
        if (firstNode == null) {
            return false;
        } else {
            if (atual.data.equals(valor)) {
                firstNode = firstNode.nextNode;
                return true;
            } else {
                anterior = atual;
                atual = atual.nextNode;
                while (atual != null) {
                    if (atual.data.equals(valor)) {
                        anterior.nextNode = atual.nextNode;
                        return true;
                    }
                    anterior = atual;
                    atual = atual.nextNode;
                }
                return false;
            }
        }
    }

    public boolean insert(int pos, Object valor) {

        Node novoNode = new Node(valor);

        Node atual = firstNode;

        Node anterior;

        int contador = 0;

        int quantidade = count();

        if(quantidade < pos) {
            return false;
        }

        if(pos == 1) {
            insertAtFront(valor);
            return true;
        } else {
            contador++;
            anterior = atual;
            atual = atual.nextNode;

            while(atual.getNextNode() != null) {
                if(contador == pos) {
                    anterior.setNextNode(novoNode);
                    novoNode.setNextNode(atual);
                    return true;
                }
                anterior = atual;
                atual = atual.nextNode;
                contador++;
            }
            return false;
        }

    }
    

    

}
