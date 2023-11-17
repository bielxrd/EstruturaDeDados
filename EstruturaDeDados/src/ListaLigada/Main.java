package ListaLigada;

public class Main {

	public static void main( String args[] ){
		ListaLigada lista = new ListaLigada();  
		
		Boolean bool = Boolean.TRUE;
		Character character = new Character('$');
		Integer integer = new Integer(12345);
		String string = "OPA!";
		
		lista.insertAtFront(bool);
		lista.print();
		lista.insertAtFront(character);
		lista.print();
		lista.insertAtBack(integer);
		lista.print();
		lista.insertAtBack(string);
		lista.print();
		
		Object removedObject = lista.removeFromFront();
		System.out.println(removedObject.toString() + " foi removido" );
		lista.print();
		
		removedObject = lista.removeFromFront();
		System.out.println(removedObject.toString() + " foi removido" );
		lista.print();
		
		removedObject = lista.removeFromBack();
		System.out.println(removedObject.toString() + " foi removido" );
		lista.print();
		
		removedObject = lista.removeFromBack();
		System.out.println(removedObject.toString() + " foi removido" );
		lista.print();

		lista.insertAtBack(200);
		lista.insertAtBack(50);
	

		System.out.println("Quantidade: "+lista.count());
		System.out.println("Pos na lista: "+lista.find(30));
		lista.print();
		lista.remove(200);
		lista.remove(50);
		lista.print();
	}  
}