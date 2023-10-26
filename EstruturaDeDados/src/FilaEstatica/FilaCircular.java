package FilaEstatica;

public class FilaCircular<T> {


    private Object[] fila;
    private int fim;
    private int inicio;

    public FilaCircular(int maxSize) {
        fila = new Object[maxSize];
        fim = -1;
        inicio = -1;
    }

    public boolean isEmpty() {
        return (fim == -1);
    }

    public boolean isFull() {
        return (fim == fila.length - 1);
    }

    public Object peek() {
        if (!isEmpty()) {
            return fila[inicio];
        } else {
            return null;
        }
    }

    public void enqueue(T elemento) {
        if (!isFull()) {
            if (isEmpty()) {
                inicio++;
            }
            fim++;
            fila[fim] = elemento;
        } else {
            System.out.println("fila cheia");
        }
    }

    public Object dequeue() {
        T elemento;
        if (!isEmpty()) {
            elemento = (T) fila[inicio];
            if (inicio == fim) {
                inicio = -1;
                fim = -1;
            } else {
                inicio++;
            }
            return elemento;
        } else {
            return null;
        }
    }

    public void mostrarFila() {
        int i;
        if (!isEmpty()) {
            for (i = inicio; i <= fim; i++) {
                System.out.println(fila[i]);
            }
        }
    }

    
}
