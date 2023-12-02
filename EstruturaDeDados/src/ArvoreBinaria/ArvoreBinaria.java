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
        if(!isEmpty()) {
            if(this.esq != null) {
                this.esq.imprimirInOrdem();
            }
            System.out.print(this.elemento.getValor() + "  ");
            if (this.dir != null) {
                this.dir.imprimirInOrdem();
            }

        }
    }

    public void imprimirPosOrdem() {
        if(!isEmpty()) {
            if(this.esq != null) {
                this.esq.imprimirPosOrdem();
            }
            if(this.dir != null) {
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
