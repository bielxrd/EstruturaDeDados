package FilaEstatica;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Fila<Integer> fila = new Fila<>(4);
        FilaCircular<Integer> filaCircular = new FilaCircular<>(4);

        filaCircular.enqueue(15);
        filaCircular.enqueue(30);
        filaCircular.enqueue(45);
        filaCircular.enqueue(60);
        filaCircular.enqueue(150);
        filaCircular.mostrarFila();
        filaCircular.dequeue();

        filaCircular.mostrarFila();


     
        System.out.print("\n");


    }

}
