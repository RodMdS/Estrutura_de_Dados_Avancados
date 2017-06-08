package br.ufc.quixada.eda.testes;

import br.ufc.quixada.eda.avl.TreeAVL;

public class TesteTreeAVL {

	public static void main(String[] args) {
		TreeAVL avl = new TreeAVL();
		
		avl.insert(20);
		avl.insert(10);
		
		avl.show();
		
		avl.insert(5);
		
		avl.show();
		
		avl.insert(30);
		
		avl.show();
		
		avl.insert(40);
		
		avl.show();
		
		avl.insert(15);
		
		avl.show();
		
		avl.insert(18);
		
		avl.show();
		
		avl.insert(17);
		
		avl.show();
		
		avl.insert(24);
		avl.insert(28);
		avl.insert(25);
		
		avl.show();
		
		
	}

}
