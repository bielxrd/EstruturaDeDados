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

    public void calcularBalanceamento() {
        if (this.dir == null && this.esq == null) {
            this.bal = 0;
        } else if (this.esq == null && this.dir != null) {
            this.bal = this.dir.calcularAltura() - 0;
        } else if (this.esq != null && this.dir == null) {
            this.bal = 0 - this.esq.calcularAltura();
        } else {
            this.bal = this.dir.calcularAltura() - this.esq.calcularAltura();
        }

        if (this.dir != null) this.dir.calcularBalanceamento();
        if (this.esq != null) this.esq.calcularBalanceamento();


    }


    public ArvoreAVL verificarBalanceamento() {

        if (this.bal >= 2 || this.bal <= -2) {
            if (this.bal >= 2) {
                if (this.bal * this.dir.getBalanceamento() > 0) {
                    System.out.println("ROTACAO SIMPLES A DIREITA");
                    return rotacaoSimplesDireita();
                } else {
                    System.out.println("ROTACAO DUPLA A DIREITA");
                    return rotacaoDuplaDireita();
                }
            } else {
                if (this.bal * this.esq.getBalanceamento() > 0) {
                    System.out.println("ROTACAO SIMPLES A ESQUERDA");
                    return rotacaoSimplesEsquerda();
                } else {
                    System.out.println("ROTACAO DUPLA A ESQUERDA");
                    return rotacaoDuplaEsquerda();
                }
            }
        }
        this.calcularBalanceamento();
        if (this.esq != null) this.esq = this.esq.verificarBalanceamento();
        if (this.dir != null) this.dir = this.dir.verificarBalanceamento();
        return this;
    }

    public ArvoreAVL rotacaoSimplesDireita() {
        ArvoreAVL filhoDir;
        ArvoreAVL filhoDoFilho = null;

        filhoDir = this.getDireita();
        if (this.dir != null) {
            if (this.dir.getEsquerda() != null) {
                filhoDoFilho = filhoDir.getEsquerda();
            }
        }
        filhoDir.setEsquerda(this);
        this.setDireita(filhoDoFilho);

        return filhoDir;

    }

    public ArvoreAVL rotacaoSimplesEsquerda() {
        ArvoreAVL filhoEsq;
        ArvoreAVL filhoDoFilho = null;

        filhoEsq = this.getEsquerda();
        if (this.esq != null) {
            if (this.esq.getDireita() != null) {
                filhoDoFilho = filhoEsq.getDireita();
            }
        }
        filhoEsq.setDireita(this);
        this.setEsquerda(filhoDoFilho);

        return filhoEsq;
    }

    public ArvoreAVL rotacaoDuplaDireita() {
        ArvoreAVL arvore = this;
        ArvoreAVL filhoDir = this.getDireita();
        ArvoreAVL filhoDoFilho = filhoDir.getEsquerda();
        ArvoreAVL noInserido = filhoDoFilho.getDireita();

        // Primeiro passo - alinhar

        filhoDir.setEsquerda(noInserido);
        filhoDoFilho.setDireita(filhoDir);
        this.setDireita(filhoDoFilho);

        // parte 2

        ArvoreAVL novoFilhoDireita = this.getDireita();
        arvore.setDireita(null);
        novoFilhoDireita.setEsquerda(arvore);

        return novoFilhoDireita;


    }

    public ArvoreAVL rotacaoDuplaEsquerda() {
        ArvoreAVL arvore = this;
        ArvoreAVL filhoEsq = this.getEsquerda();
        ArvoreAVL filhoDoFilho = filhoEsq.getDireita();
        ArvoreAVL noInserido = filhoDoFilho.getEsquerda();

        // Primeiro passo - alinhar

        filhoEsq.setDireita(noInserido);
        filhoDoFilho.setEsquerda(filhoEsq);
        this.setEsquerda(filhoDoFilho);

        // parte 2

        ArvoreAVL novoFilhoEsquerda = this.getEsquerda();
        arvore.setEsquerda(null);
        novoFilhoEsquerda.setDireita(arvore);

        return novoFilhoEsquerda;
    }

    public ArvoreAVL remover(Elemento elem) {
        // Achei o elemento
        if (this.elemento.getValor() == elem.getValor()) {
            // Caso simples - Elemento está em um nó folha (não tem filhos)
            if (this.esq == null && this.dir == null) {
                return null;
            } else {
                // Caso 2 - Tenho filhos à esquerda, mas não tenho à direita
                if (this.esq != null && this.dir == null) {
                    return this.esq;

                    // Caso 3 - Tenho filhos à direita, mas não tenho à esquerda
                } else if (this.dir != null && this.esq == null) {
                    return this.dir;
                }
                // Caso 4 - Tenho filhos dos dois lados
                else {
                    // Estratégia do menor entre os maiores
                    ArvoreAVL aux = this.esq;

                    while (aux.dir != null) {
                        aux = aux.dir;
                    }

                    // Troco os elementos da árvore
                    this.elemento = aux.getElemento(); // o nó atual recebe o elemento do aux (o maior entre os menores)
                    aux.setElemento(elem); // Insiro no nó folha (lá embaixo do maior entre os menores) o elemento a ser removido

                    this.esq = esq.remover(elem);
                }
            }
        } else if (this.elemento.getValor() > elem.getValor()) {
            // Delegar a responsabilidade para a subárvore da esquerda
            this.esq = this.esq.remover(elem);
        } else if (this.elemento.getValor() < elem.getValor()) {
            // Delegar a responsabilidade para a subárvore da direita
            this.dir = this.dir.remover(elem);
        }

        // Após a remoção, calcular o balanceamento e verificar se ajustes são necessários
        this.calcularBalanceamento();
        return this.verificarBalanceamento();
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
                    this.esq = this.esq.inserir(novo); // Insere na esquerda e atualiza a referência
                }
            } else if (novo.getValor() > this.elemento.getValor()) { // Inserir na direita
                if (this.dir == null) {
                    this.dir = novaArvore;
                } else {
                    this.dir = this.dir.inserir(novo); // Insere na direita e atualiza a referência
                }
            }

            // Após a inserção, calcular o balanceamento e verificar se ajustes são necessários
            this.calcularBalanceamento();
            return this.verificarBalanceamento();
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

            str += "+-DIR: " + this.dir.printArvore(level + 1);

        } else {
            str += "+-DIR: NULL";
        }
        str += "\n";

        return str;
    }

    public String toString() {
        return "[" + this.getElemento().getValor() + "] (" + this.bal + ")";
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
