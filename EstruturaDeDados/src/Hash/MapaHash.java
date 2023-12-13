package Hash;

public class MapaHash<K, V> {
    private Registro<K, V>[] valores;

    public MapaHash() {
        valores = (Registro<K, V>[]) new Registro<?, ?>[100];
    }

    public void put(Registro registro) {
        int posicao = registro.hashCode();
        if (valores[posicao] == null) {
            valores[posicao] = registro;
            System.out.println("Posicao vazia!! Novo Registro");
        } else {
            System.out.print("Ops… colisao");
            Registro reg = valores[posicao];

            // especial para tratar o primeiro elemento
            if (reg.getKey().equals(registro.getKey())) { // O registro que quero inserir é o mesmo que ja existe?
                reg.setValue(registro.getValue()); // Substituo
                System.out.println("É o primeiro Registro Existente – atualizando");
                return;
            }

            // se ele tá no meio da lista
            while (reg.getProximo() != null) {
                if (reg.getKey().equals(registro.getKey())) { // O registro que quero inserir é o mesmo que ja existe?
                    reg.setValue(registro.getValue()); // Substituo
                    System.out.println("Tá no meio da lista – Registro Existente – atualizando…");
                    return;
                }
                reg = reg.getProximo();
            }

            // se ele é o último da lista
            if (reg.getKey().equals(registro.getKey())) {
                reg.setValue(registro.getValue());
                System.out.println("É o ultimo! Registro Existente – atualizando…");
                return;
            }

            reg.setProximo(registro); // COloquei o nvoo registro na ultima posicao
            System.out.println("Novo Registro!");
        }
    }


    public Registro<K, V> get(K key) {
        Registro<K, V> r = new Registro();
        try {
            r.setKey(key);
            int posicao = r.hashCode();
            Registro resultado = valores[posicao]; //Tento encontrar o registro
            if (resultado != null && resultado.getKey().equals(key)) { // é este o registro?
                return resultado; //s
            } else {
                while (resultado != null) { //enquanto tiver na lista
                    resultado = resultado.getProximo(); // vou pro proximo
                    if (resultado != null && resultado.getKey().equals(key)) { // é o cara? return
                        return resultado;
                    }
                }
            }
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return null;
        }


    }


}
