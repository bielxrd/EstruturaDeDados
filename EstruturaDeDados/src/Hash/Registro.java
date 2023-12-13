package Hash;

import java.util.Objects;

public class Registro<K, V> {

    private K key;
    private V value;

    private Registro<K, V> proximo;

    public Registro() {
        this.proximo = null;
    }

    public Registro(K key, V value) {
        this.key = key;
        this.value = value;
        this.proximo = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public int hashCode() {
        if (key instanceof String) {
//            return calcularHashString((String) key); Impossivel implementar no momento.
            return (Integer) key % 100;
        } else if (key instanceof Integer) {
            return (Integer) key % 100;
        } else {
            return (Integer) key % 100;
        }
    }

    private int calcularHashString(String str) {
        int valorHash = 0;
        for (int i = 0; i < str.length(); i++) {
            valorHash += (int) (str.charAt(i) * Math.pow(31, str.length() - 1 - i));
        }
        return valorHash;
    }


    public Registro<K, V> getProximo() {
        return proximo;
    }

    public void setProximo(Registro<K, V> proximo) {
        this.proximo = proximo;
    }
}
