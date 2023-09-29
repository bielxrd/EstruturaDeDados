package PilhaEstatica;

public class Main {
    public static void main(String[] args) {
        PilhaEstatica minhaPilha = new PilhaEstatica(10);

        minhaPilha.push(20);
        minhaPilha.push(40);
        minhaPilha.push(60);
        minhaPilha.push(80);
        
        while(!minhaPilha.isEmpty()) {
            int value = minhaPilha.pop();
            System.out.print(value + " ");
        }
        System.out.println("");
        System.out.println(minhaPilha.indexOf(40));
    }
    
}
