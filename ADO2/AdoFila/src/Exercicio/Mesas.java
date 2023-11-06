package Exercicio;
import java.util.Arrays;

public class Mesas {
    private int quantidade;
    private String[] mesas;
    private Cliente[] nomes;

    public Mesas(int tamanho) {
        this.mesas = new String[tamanho];
        this.quantidade = tamanho;
        this.nomes = new Cliente[tamanho];
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

    public void setMesas(Cliente cliente, int index) {
        this.mesas[index] = "Ocupado";
        this.nomes[index] = cliente;
        this.nomes[index].setMesa(index);
    }

    public String getNome(int index) {
        return this.nomes[index].getNome();
    }

    public int numeroMesa(int index) {
        return this.nomes[index].getMesa();
    }

    public boolean isVip(int index) {
        return this.nomes[index].isVip();
    }

    

    

    
    
}
