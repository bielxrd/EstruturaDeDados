package PilhaEstatica.Exercicio;

public class Main {
    public static void main(String[] args) {
        PilhaExc minPilhaExc = new PilhaExc(5);

        minPilhaExc.push('k');
        minPilhaExc.push('a');
        minPilhaExc.push('u');
        minPilhaExc.push('a');
        minPilhaExc.push('n');

        while(!minPilhaExc.isEmpty()) {
            char value = minPilhaExc.pop();
            System.out.print(value + " ");
        }
        System.err.println("");
    }
}
