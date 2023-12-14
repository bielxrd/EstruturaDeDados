package BuscaSequencialeBinaria;

public class Colecao {

    private int valores[] = {12, 56, 87, 23, 96, 43, 27, 76, 33, 11};

    public int buscaSequencial(int valor) {
        int pos;
        for (pos = 0; pos < valores.length; pos++) {
            if (valores[pos] == valor) {
                return pos;
            }
        }
        return -1;
    }

}
