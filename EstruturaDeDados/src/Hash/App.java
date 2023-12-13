package Hash;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        String texto;
        int chave;
        int continua = 0;
        MapaHash<Integer, String> mapaHash = new MapaHash<>();

        Registro r;

        do {
            System.out.println("Digite uma chave");
            texto = ler.next();
            chave = Integer.parseInt(texto);
            System.out.println("Digite um valor");
            texto = ler.next();

            r = new Registro(chave, texto);

            mapaHash.put(r);

            System.out.println("Continua (1 - sim) (0 - nao)");
            continua = Integer.parseInt(ler.next());

        } while (continua != 0);

        System.out.println("---------------");

        do {
            System.out.println("Digite uma chave");
            chave = Integer.parseInt(ler.next());


            if (chave != -1) {
                r = mapaHash.get(chave);

                if (r != null) {
                    System.out.println("Registro = " + r.getValue());
                } else {
                    System.out.println("Registro nao existe");
                }
            }
        } while (chave != -1);

    }
}
