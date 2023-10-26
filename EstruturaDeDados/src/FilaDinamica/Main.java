package FilaDinamica;



public class Main {
    public static void main(String[] args) {
        FilaDinamica fila = new FilaDinamica();

        fila.enqueue(15);
        fila.enqueue(30);
        fila.enqueue(45);
        

        System.out.println("Fila:");
        fila.display();

        while(!fila.isEmpty()) {
            System.out.println("Removendo: "+fila.dequeue());
        }

    }
}
