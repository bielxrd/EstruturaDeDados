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

    public int buscaBinaria(int valor) {
        this.valores = ordenar();
        int meio, inicio, fim;
        inicio = 0;
        fim = valores.length - 1;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            if (valores[meio] == valor) {
                return meio;
            } else {
                if (valor > valores[meio]) {
                    inicio = meio + 1;
                } else {
                    fim = meio - 1;
                }
            }
        }
        return -1;

    }

    public int[] ordenar() {
        for (int i = 0; i < valores.length; i++) {
            for (int j = 0; j < valores.length - i - 1; j++) {
                if (valores[j] > valores[j + 1]) {
                    int aux = valores[j];
                    valores[j] = valores[j + 1];
                    valores[j + 1] = aux;
                }
            }
        }
        return this.valores;
    }

    public void mostrarArray() {
        for (int valores: valores) {
            System.out.print(valores + " - ");
        }
    }


}
