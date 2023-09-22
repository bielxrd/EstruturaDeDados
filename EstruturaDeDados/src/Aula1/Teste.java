package Aula1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Teste {
    public static void main(String[] args) {
        Vetor vetor = new Vetor(5);
        ArrayList<Integer> lista = new ArrayList<Integer>(5);
        Stack<Integer> pilha = new Stack<Integer>();
        Queue<Integer> fila = new LinkedList<Integer>();
        LinkedList<Integer> listaLigada = new LinkedList<Integer>();
        HashMap<Integer, String> mapa = new HashMap<Integer, String>();
        HashSet<Integer> conjunto = new HashSet<Integer>();
        
       mapa.put(1, "Joao");
       mapa.put(5, "Maria");    
       System.out.println(mapa.get(5));
        

        System.out.println(vetor.isEmpty());
        System.out.println(vetor.isFull());

        vetor.add(1);
        vetor.add(2);
        vetor.add(3);
        vetor.add(4);
        vetor.add(5);

        System.out.println(vetor.isFull());

        System.out.println("O indice esta na posicao: "+vetor.procurar(3));
        
    }
    
}
