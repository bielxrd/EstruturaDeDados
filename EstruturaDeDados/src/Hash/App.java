package Hash;

import java.util.Scanner;

public class App {
    public static <T> void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        int key;

        Registro r1, r2, r3, r4;
        MapaHash<Integer, String> mapaHash  = new MapaHash<>();

        mapaHash.put(new Registro<>(5, "Gabriel"));
        mapaHash.put(new Registro<>(123, "Herison"));
        mapaHash.put(new Registro<>(987, "Jose"));
        mapaHash.put(new Registro<>(9832, "Henrique"));



        do {
            System.out.println("Informe um registro");
            key = ler.nextInt();
            Registro r = mapaHash.get(key);

            if (r != null) {
                System.out.println("Registro: "+r.getKey() + " Value: " + r.getValue() + " HashCode: "+r.hashCode());
            } else {
                System.out.println("Registro nao existente");
                key = -1;
            }
        } while(key != -1);


    }
}
