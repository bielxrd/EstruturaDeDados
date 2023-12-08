package ArvoreBinaria;

public class ArvoreBinaria {

    private Elemento elemento;
    private ArvoreBinaria dir;
    private ArvoreBinaria esq;

    public ArvoreBinaria() {
        this.elemento = null;
        this.dir = null;
        this.esq = null;
    }

    public ArvoreBinaria(Elemento elemento) {
        this.elemento = elemento;
        this.dir = null;
        this.esq = null;
    }

    public ArvoreBinaria remover(Elemento elem) {
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
                    ArvoreBinaria aux = this.esq;

                    while(aux.dir != null) {
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

    public void inserir(Elemento novo) {
        if (isEmpty()) {
            this.elemento = novo;
        } else {
            ArvoreBinaria novaArvore = new ArvoreBinaria(novo);
            if (novo.getValor() < this.elemento.getValor()) { // Inserir na esquerda
                if (this.esq == null) { // Nó folha
                    this.esq = novaArvore;
                } else {
                    this.esq.inserir(novo); //Insere na esuqerda caso ja tenha uma raiz da esquerda (verifica recursivamnete o esq dentro da arvore esq que é null e adiciona)
                }
            } else if (novo.getValor() > this.elemento.getValor()) { // Inserir na direita
                if (this.dir == null) {
                    this.dir = novaArvore;
                } else {
                    this.dir.inserir(novo); //Insere na direita caso ja tenha uma raiz da direita (verifica recursivamnete o esq dentro da arvore esq que é null e adiciona)
                }
            }
        }
    }


    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

    public ArvoreBinaria getDireita() {
        return dir;
    }

    public void setDireita(ArvoreBinaria dir) {
        this.dir = dir;
    }

    public ArvoreBinaria getEsquerda() {
        return esq;
    }

    public void setEsquerda(ArvoreBinaria esq) {
        this.esq = esq;
    }
}
