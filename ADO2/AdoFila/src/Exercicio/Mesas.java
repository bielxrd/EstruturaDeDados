package Exercicio;
import java.util.Arrays;

public class Mesas {
    private int quantidade;
    private String[] mesas;
    private String nome;

    public Mesas(int tamanho) {
        this.mesas = new String[tamanho];
        this.quantidade = tamanho;
        Arrays.fill(this.mesas, "Disponivel");
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public String[] getMesas() {
        return mesas;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setMesas(String nome, int index) {
        this.mesas[index] = "Ocupado";
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    

    

    
    
}
