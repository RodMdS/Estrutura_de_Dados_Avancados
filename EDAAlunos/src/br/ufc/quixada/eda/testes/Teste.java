package br.ufc.quixada.eda.testes;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.eda.listaprioridades.HeapMaximo;

public class Teste {

	public static void main(String[] args) {
		
		HeapMaximo heap = new HeapMaximo(13);
		
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(100);
		lista.add(50);
		lista.add(65);
		lista.add(25);
		lista.add(30);
		lista.add(57);
		lista.add(62);
		lista.add(14);
		lista.add(21);
		lista.add(28);
		lista.add(55);
		lista.add(20);
		lista.add(10);
		
		heap.contruir(lista);
		
		//heap.inserir(67);
		
		heap.mostrar();

	}
}
