
package Exercicio;

import java.time.Duration;
import java.time.LocalDateTime;

public class Cliente {
    private String nome;
    private boolean vip;
    private int mesa;
    private LocalDateTime date;

    public Cliente(String nome, boolean isVip) {
        this.nome = nome;
        this.vip = isVip;
        this.date = date.now();
    }

    public Cliente(String nome, boolean vip, int mesa) {
        this.nome = nome;
        this.vip = vip;
        this.mesa = mesa;
        this.date = date.now();
    }

    public Cliente(String nome) {
        this.nome = nome;
        this.date = date.now();
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setChegada(LocalDateTime chegada) {
        this.date = chegada;
    }

}
