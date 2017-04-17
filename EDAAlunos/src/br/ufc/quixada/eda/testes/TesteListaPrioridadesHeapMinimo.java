package br.ufc.quixada.eda.testes;

import java.util.List;
import java.util.ArrayList;

import br.ufc.quixada.eda.listaprioridades.HeapMinimo;

public class TesteListaPrioridadesHeapMinimo {

	public static void main(String[] args) {
		List<Integer> vetor = new ArrayList<Integer>();
		
		vetor.add(95);
		vetor.add(60);
		vetor.add(78);
		vetor.add(39);
		vetor.add(28);
		vetor.add(66);
		vetor.add(70);
		vetor.add(33);
		vetor.add(31);
		
		HeapMinimo prioridades = new HeapMinimo(vetor.size());
		
		prioridades.construir(vetor, vetor.size());
		
		System.out.println(prioridades.getMinimaPrioridade());
		
		prioridades.remove();
		System.out.println(prioridades.getMinimaPrioridade());
		
		prioridades.remove();
		System.out.println(prioridades.getMinimaPrioridade());
		
		prioridades.inserir(17);
		System.out.println(prioridades.getMinimaPrioridade());
		
		prioridades.alterarPrioridade(4, 10);
		System.out.println(prioridades.getMinimaPrioridade());
	}

}
