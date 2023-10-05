package PilhaEstatica;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        PilhaEstatica<Integer> minhaPilha = new PilhaEstatica<Integer>();

        minhaPilha.push(20);
        minhaPilha.push(40);
        minhaPilha.push(60);
        minhaPilha.push(80);
        
        while(!minhaPilha.isEmpty()) {
            int value = minhaPilha.pop();
            System.out.print(value + " ");
        }

        minhaPilha.push(20);
        minhaPilha.push(40);
        minhaPilha.push(60);
        minhaPilha.push(80);
        System.out.println("");

        System.out.println("peek: "+minhaPilha.peek());
        System.out.println(minhaPilha.toString());

    }
    
}
