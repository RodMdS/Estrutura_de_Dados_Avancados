package br.ufc.quixada.eda.testes;

import br.ufc.quixada.eda.listaencadeada.ListaEncadeada;

public class TesteListaEncadeada {

	public static void main(String[] args) {
		
		ListaEncadeada le = new ListaEncadeada();
		
		le.add(1, "a");
		le.add(2, "b");
		le.add(3, "c");
		
		le.print();
		
		System.out.println(le.size());
		
		System.out.println(le.get(2, null).getValor());
		
		le.remove(1, le.get(1, null).getValor());
		le.remove(3, le.get(3, null).getValor());
		
		le.print();
		
		System.out.println(le.size());
	}

}
