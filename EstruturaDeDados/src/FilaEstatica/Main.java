package FilaEstatica;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Fila<Integer> fila = new Fila<>(4);

        fila.enqueue(20);
        fila.enqueue(40);
        fila.enqueue(60);
        fila.enqueue(80);

        fila.mostrarFila();
        fila.dequeue();
        System.out.println();
        fila.mostrarFila();

        System.out.print("\n");
    }

}
