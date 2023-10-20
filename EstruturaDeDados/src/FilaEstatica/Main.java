package FilaEstatica;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
         Fila<Integer> fila = new Fila<>(3);

        fila.poll(15);
        fila.poll(15);
        fila.poll(15);
        
        fila.mostrarPilha();

        Integer teste = fila.offer();
    }

}
