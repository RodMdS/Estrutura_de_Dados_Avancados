package br.ufc.quixada.eda.testes;

import br.ufc.quixada.eda.hash.EnderecamentoExterno;
import br.ufc.quixada.eda.hash.Hash;

public class TesteHashEnderecamentoExterno {

	public static void main(String[] args) {
		
		Hash tabela = new EnderecamentoExterno();
		
		tabela.add(1, "a");
		tabela.add(10, "b");
		tabela.add(2, "iana");
		tabela.add(22, "rod");
		
		System.out.println(tabela.get(10));
		
		System.out.println(tabela.get(1));
		
		System.out.println(tabela.remove(1));
		
		System.out.println(tabela.get(2));
		
		System.out.println(tabela.get(22));
		
		System.out.println(tabela.remove(22));
		
		System.out.println(tabela.get(22));

	}

}
