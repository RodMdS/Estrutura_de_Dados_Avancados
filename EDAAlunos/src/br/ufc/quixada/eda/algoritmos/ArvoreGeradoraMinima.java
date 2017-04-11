package br.ufc.quixada.eda.algoritmos;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.eda.conjuntosdisjuntos.ConjuntoDisjunto;
import br.ufc.quixada.eda.grafos.Aresta;
import br.ufc.quixada.eda.grafos.Grafo;
import br.ufc.quixada.eda.util.EDAUtil;

public class ArvoreGeradoraMinima {

	public List<Aresta> kruskal(Grafo g){
		List<Aresta> solucao = new ArrayList<Aresta>();
		ConjuntoDisjunto conj = new ConjuntoDisjunto(g.getQtdVertices());

		for(int i = 0; i < g.getQtdVertices(); i++){
			conj.make_set(i);
		}

		EDAUtil.quickSort(g.getArestas(), 0, g.getArestas().length - 1);
		
		for(int i = 0; i < g.getQtdArestas(); i++){
			Aresta a = g.getArestas(i);
			if(conj.find_set(a.getV()) != conj.find_set(a.getU())){
				solucao.add(a);
				conj.union(a.getV(), a.getU());
			}
		}

		return solucao;
	}

}
