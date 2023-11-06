package Exercicio;

public class Cliente {
    private String nome;
    private boolean vip;
    private int mesa;

    public Cliente(String nome, boolean isVip) {
        this.nome = nome;
        this.vip = isVip;
    }

    public Cliente(String nome, boolean vip, int mesa) {
        this.nome = nome;
        this.vip = vip;
        this.mesa = mesa;
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

}
