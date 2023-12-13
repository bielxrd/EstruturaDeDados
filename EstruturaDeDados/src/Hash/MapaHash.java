package Hash;

public class MapaHash<K, V> {
    private Registro<K, V>[] valores;

    public MapaHash() {
        valores = (Registro<K, V>[]) new Registro<?, ?>[100];
    }

    public void put(Registro<K, V> registro) {
        int posicao = registro.hashCode();

        if (valores[posicao] == null) {
            valores[posicao] = registro;
        } else {
            Registro reg = valores[posicao];

            while(reg.getProximo() != null) {
                if (reg.getKey() == registro.getKey()) { // Registro novo igual a um existente ?
                    reg.setValue(registro.getValue()); // Substituo o valor
                } else {
                    reg = reg.getProximo();
                }
            }
            reg.setProximo(registro); // Coloquei o novo registro na ultima posicao
        }
    }

    public Registro<K, V> get(K key) {
        Registro<K, V> r = new Registro();
        try {
            r.setKey(key);
            int posicao = r.hashCode();
            return valores[posicao];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return null;
        }


    }


}
