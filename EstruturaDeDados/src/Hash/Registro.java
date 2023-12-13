package Hash;

import java.util.Objects;

public class Registro<K,V> {

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
        return key.hashCode() % 100;
    }

    public Registro<K, V> getProximo() {
        return proximo;
    }

    public void setProximo(Registro<K, V> proximo) {
        this.proximo = proximo;
    }
}
