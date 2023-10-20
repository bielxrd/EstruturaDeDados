package FilaEstatica;

/**
 * @(#)Fila.java
 */


public class Fila <T> {

    private Object vetorFila[];
    private int fim;

    public Fila(int maxSize) {
        vetorFila = new Object[maxSize];
        fim = -1;
    }

    //Verifica se a Fila esta vazia
    public boolean isEmpty() {
        return (fim == -1);
    }

    //Verifica se a Fila esta cheia
    public boolean isFull() {
        return (fim == vetorFila.length - 1);
    }

    //Retorna o primeiro elemento da Fila
    public T peek(){
        if (!isEmpty())
            return (T) vetorFila[0];
        else
            return null;
    }

    //Insere elemento na Fila
    public void enqueue(T elemento){
        if (!isFull()) {
            fim++;
            vetorFila[fim] = elemento;
        }
    }

    //Remove elemento da Fila
    public T dequeue(){
        int i;
        T elemento;
        if (!isEmpty()) {
            elemento = (T) vetorFila[0];
            for (i = 0; i < fim; i++) {
                vetorFila[i] = vetorFila[i + 1];
            }
            fim--;
            return elemento;
        } else {
            return null;
        }
    }

    public void mostrarFila() {
        for (int i = 0; i < vetorFila.length; i++) {
            System.out.print(vetorFila[i] + "-");
        }
    }
}