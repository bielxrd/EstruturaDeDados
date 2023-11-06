package Exercicio;

public class FilaMesas<T> extends Fila {

    public void quantidadeDisponivel(Fila<Mesas> mesas) {

        int quantidade = 0;
        for (int i = 0; i < mesas.size(); i++) {
            Mesas mesa = mesas.get(i);
            quantidade = mesa.getQuantidade();
        }

        System.out.println("Quantidade de mesas disponiveis: " + quantidade);
    }

    public void mesasDisponiveis(Fila<Mesas> mesas) {
        
        StringBuilder bd = new StringBuilder();

        Mesas mesa = null;
        for (int i = 0; i < mesas.size(); i++) {
            mesa = mesas.get(i);
        }

        bd.append("[");
        for (int i = 0; i < mesa.getMesas().length; i++) {
            
            if (mesa.getMesas()[i] == "Disponivel") { 
            bd.append(i+". "+mesa.getMesas()[i]);

            if(i < mesa.getMesas().length) 
                bd.append(", ");

            }    
            
        }
        bd.append("]");
        System.out.println("Mesas Disponiveis: ");
        System.out.println(bd.toString());

    }

    public void exibirDisponivel(Fila<Mesas> mesas) {
        quantidadeDisponivel(mesas);
        mesasDisponiveis(mesas);
    }

    public void alocarMesa(Fila<Mesas> mesas, Cliente cliente, int index) {
        Mesas mesa = mesas.dequeue();

        mesa.setMesas(cliente.getNome(), index);
        mesa.setQuantidade(mesa.getQuantidade()-1);

        mesas.enqueue(mesa);


    }
 
}
