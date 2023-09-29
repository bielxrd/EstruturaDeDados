package Aula1;

public class Vetor {

    private int vetor[];
    private int quantidade;

    public Vetor(int tamanho) {
        this.vetor = new int[tamanho];
        this.quantidade = 0;
    }

    public boolean isEmpty() { // verifica se o vetor esta vazio
        if (quantidade == 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isFull() { // verifica se o vetor esta cheio
        if (quantidade == vetor.length) {
            return true;
        } else {
            return false;
        }
    }

    public boolean add(int valor) { // adiciona um elemento no vetor
        if (isFull()) {
            System.out.println("Vetor cheio");
            return false;
        } else {
            if(procurar(valor)) {
                System.out.println("Valor ja existe no vetor");
                return false;
            }
            vetor[quantidade] = valor;
            quantidade++;
            return true;
        }
    }

    public boolean procurar(int valor) { // procura um elemento no vetor
        int i;
        for (i = 0; i < quantidade; i++)
            if (vetor[i] == valor) // encontrou o elemento
                break;

        if (i == quantidade) // nao encontrou o elemento e retorna falso(nao tem o elemento)
            return false;
        else
            return true; // encontrou o elemento e retorna verdadeiro(tem o elemento)
    }

    public void display() { // imprime o conteudo do vetor
        for (int i = 0; i < quantidade; i++) {
            System.out.print(vetor[i] + " ");

            System.out.println("");
        }
    }

    public boolean remover(int valor) { // remove um elemento do vetor
        int i;
        for (i = 0; i < quantidade; i++) {
            if (valor == vetor[i]) // encontrou o elemento
                break;
        }
        if (i == quantidade) { // nao encontrou o elemento e retorna falso(nao tem o elemento)
            return false;
        } else {
            for (int j = i; j < quantidade; j++) {
                if (j == vetor.length - 1) // se for o ultimo elemento, coloca 0
                    vetor[j] = 0;
                else // se nao for o ultimo elemento, coloca o proximo elemento no lugar
                    vetor[j] = vetor[j + 1];
            }
            quantidade--;
            return true;
        }
    }

    public int getPosicao(int valor) {
        int i;
        for (i = 0; i < quantidade; i++) {
            if (valor == vetor[i]) // encontrou o elemento
                break;
        }
        if (i == quantidade)
            return -1;
        else
            return i;

    }
    public boolean alterar(int atual, int novo) {
        if(isEmpty()) {
            System.out.println("Vetor vazio");
            return false;
        }
        int i;
        for ( i = 0; i < quantidade; i++) { // procura o elemento
            if(atual==vetor[i]) { // encontrou o elemento
                break; 
            }
        }
        if(i == quantidade) { // nao encontrou o elemento e retorna falso(nao tem o elemento)
            System.out.println("Valor nao existe no vetor");
            return false;
        }
        else { 
            vetor[i] = novo; 
            return true;
        }
    }

}
