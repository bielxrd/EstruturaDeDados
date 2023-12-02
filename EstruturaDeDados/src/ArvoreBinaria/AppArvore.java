package ArvoreBinaria;

public class AppArvore {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria(new Elemento(10));

        arvoreBinaria.inserir(new Elemento(5));
        arvoreBinaria.inserir(new Elemento(1));
        arvoreBinaria.inserir(new Elemento(8));
        arvoreBinaria.inserir(new Elemento(15));
        arvoreBinaria.inserir(new Elemento(12));
        arvoreBinaria.inserir(new Elemento(18));

        arvoreBinaria.imprimirPreOrdem();
        System.out.println();
        arvoreBinaria.imprimirInOrdem();
        System.out.println();
        arvoreBinaria.imprimirPosOrdem();
    }
}
