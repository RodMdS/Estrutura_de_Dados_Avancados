package br.ufc.quixada.eda.testes;

import br.ufc.quixada.eda.splay.TreeSplay;

public class TesteTreeSplay {

	public static void main(String[] args) {
		TreeSplay<String> tree = new TreeSplay<String>();
		
		tree.insert(20, "1");
		
		tree.show();
		
		tree.insert(10, "2");
		
		tree.show();
		
		tree.insert(30, "3");
		
		tree.show();
		
		System.out.println(tree.get(10));
		
		tree.show();
		
		tree.remove(20);
		
		tree.show();
		
		System.out.println(tree.get(20));
		
		tree.show();
	}

}
