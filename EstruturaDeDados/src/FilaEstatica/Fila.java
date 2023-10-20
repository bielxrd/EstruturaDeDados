package FilaEstatica;

public class Fila<T> {
    private Object[] filaEstatica;
    private int fim;

    public Fila(int maxSize) {
        filaEstatica = new Object[maxSize];
        fim = -1;
    }

    public void poll(T elemento) {
        
    }

    public T offer() {
        return (T) filaEstatica[];
    }

    public boolean isEmpty() {
        if (fim == -1)
            return true;
        else
            return false;
    }

    public T peek() {
        return (T) filaEstatica[0];
    }

    public boolean isFull() {
        if (fim == filaEstatica.length)
            return true;
        else
            return false;

    }

    public void mostrarPilha() {
        for (int i = 0; i < filaEstatica.length; i++) {
            System.out.print(filaEstatica[i] + "-");
        }
    }

}