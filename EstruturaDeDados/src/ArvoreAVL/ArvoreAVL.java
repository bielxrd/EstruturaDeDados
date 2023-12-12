package ArvoreAVL;

public class ArvoreAVL {

    private Elemento elemento;
    private ArvoreAVL dir;
    private ArvoreAVL esq;
    private int bal;


    public ArvoreAVL() {
        this.elemento = null;
        this.dir = null;
        this.esq = null;
    }

    public ArvoreAVL(Elemento elemento) {
        this.elemento = elemento;
        this.dir = null;
        this.esq = null;
        this.bal = 0;
    }

    public int calcularAltura() {
        // Nao tenho nenhum filho
        if (this.esq == null && this.dir == null) {
            return 1;
        } else if (this.esq != null && this.dir == null) {
            return 1 + this.esq.calcularAltura();
        } else if (this.esq == null && this.dir != null) {
            return 1 + this.dir.calcularAltura();
        } else {
            return 1 + Math.max(this.esq.calcularAltura(), this.dir.calcularAltura());
        }

    }

    public ArvoreAVL remover(Elemento elem) {
        // Achei o elemento
        if (this.elemento.getValor() == elem.getValor()) {
            // Caso simples - Elemento esta em um no folha (Nao tem filhos)
            if (this.esq == null && this.dir == null) {
                return null;
            } else {
                // caso 2 - caso eu tenho filhos a esquerda, porem nao tenho a direita
                if (this.esq != null && this.dir == null) {
                    return this.esq;

                    // caso 3 - caso eu tenho filhos a direita, porem nao tenho a esquerda
                } else if (this.dir != null && this.esq == null) {
                    return this.dir;
                }
                // caso 4 - tenho filhos dos dois lados
                else {
                    //Estrategia do menor dentro os maiores
                    ArvoreAVL aux = this.esq;

                    while (aux.dir != null) {
                        aux = aux.dir;
                    }

                    //Troco os elementos da arvore
                    this.elemento = aux.getElemento(); // o nó atual recebe o elemento do aux (o maior dentro dos os menores)
                    aux.setElemento(elem); // Insiro no nó folha (la embaixo do maior entre os menores) o elemento a ser removido

                    this.esq = esq.remover(elem);

                }

            }

        } else if (this.elemento.getValor() > elem.getValor()) {
            //Delegar a responsabilidade para a sub arvore da esquerda
            this.esq = this.esq.remover(elem);
        } else if (this.elemento.getValor() < elem.getValor()) {
            // Delegar a responsabilidade para a sub arvore da direita
            this.dir = this.dir.remover(elem);
        }
        return this;
    }

    public boolean isEmpty() {
        return this.elemento == null;
    }

    public void imprimirPreOrdem() {
        if (!isEmpty()) {
            System.out.print(this.elemento.getValor() + "  ");
            if (this.esq != null) {
                this.esq.imprimirPreOrdem();
            }
            if (this.dir != null) {
                this.dir.imprimirPreOrdem();
            }
        }
    }

    public void imprimirInOrdem() {
        if (!isEmpty()) {
            if (this.esq != null) {
                this.esq.imprimirInOrdem();
            }
            System.out.print(this.elemento.getValor() + "  ");
            if (this.dir != null) {
                this.dir.imprimirInOrdem();
            }

        }
    }

    public void imprimirPosOrdem() {
        if (!isEmpty()) {
            if (this.esq != null) {
                this.esq.imprimirPosOrdem();
            }
            if (this.dir != null) {
                this.dir.imprimirPosOrdem();
            }
            System.out.print(this.elemento.getValor() + "  ");
        }
    }


    public boolean busca(int valor) {
        if (isEmpty()) {
            return false;
        }
        if (this.elemento.getValor() == valor) {
            return true;
        } else {
            if (valor < this.elemento.getValor()) {
                if (this.esq == null) {
                    return false;
                } else {
                    return this.esq.busca(valor); // Repassar a responsabilidade para a esquerda
                }
            } else if (valor > this.elemento.getValor()) {
                if (this.dir == null) {
                    return false;
                } else {
                    return this.dir.busca(valor);
                }
            }
            return false;
        }
    }

    public ArvoreAVL inserir(Elemento novo) {
        if (isEmpty()) {
            this.elemento = novo;
        } else {
            ArvoreAVL novaArvore = new ArvoreAVL(novo);
            if (novo.getValor() < this.elemento.getValor()) { // Inserir na esquerda
                if (this.esq == null) { // Nó folha
                    this.esq = novaArvore;
                } else {
                    this.esq = this.esq.inserir(novo); //Insere na esuqerda caso ja tenha uma raiz da esquerda (verifica recursivamnete o esq dentro da arvore esq que é null e adiciona)
                }
            } else if (novo.getValor() > this.elemento.getValor()) { // Inserir na direita
                if (this.dir == null) {
                    this.dir = novaArvore;
                } else {
                    this.dir = this.dir.inserir(novo); //Insere na direita caso ja tenha uma raiz da direita (verifica recursivamnete o esq dentro da arvore esq que é null e adiciona)
                }
            }
        }
        return this;
    }

    public String printArvore(int level) {
        String str = this.toString() + "\n";
        for (int i = 0; i < level; i++) {
            str += "\t";
        }
        if (this.esq != null) {
            str += "+-ESQ: " + this.esq.printArvore(level + 1);

        } else {
            str += "+-ESQ: NULL";
        }

        str += "\n";

        for (int i = 0; i < level; i++) {
            str += "\t";
        }
        if (this.dir != null) {

            str = "+-DIR: " + this.dir.printArvore(level + 1);

        } else {
            str += "+-DIR: NULL";
        }
        str += "\n";

        return str;
    }

    public String toString() {
        return "[" + this.getElemento().getValor() + "]";
    }


    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

    public ArvoreAVL getDireita() {
        return dir;
    }

    public void setDireita(ArvoreAVL dir) {
        this.dir = dir;
    }

    public ArvoreAVL getEsquerda() {
        return esq;
    }

    public void setEsquerda(ArvoreAVL esq) {
        this.esq = esq;
    }

    public int getBalanceamento() {
        return bal;
    }

    public void setBalanceamento(int bal) {
        this.bal = bal;
    }
}
