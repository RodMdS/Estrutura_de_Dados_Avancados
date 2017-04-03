package br.ufc.quixada.eda.conjuntosdisjuntos;

public class ConjuntosDisjuntos {
	
	private int nMaximo = 0;
	private int pai[] = null;
	private int ordem[] = null;
	
	
	public ConjuntosDisjuntos(int nMaximo){
		this.nMaximo = nMaximo;
		pai = new int[this.nMaximo + 1];
		ordem = new int[this.nMaximo + 1];
	}
	
	public void makeSet(int v){
		pai[v] = v;
		ordem[v] = 0;
	}
	
	public int findSet(int v){
		if(pai[v] == v) return v;
		pai[v] = findSet(pai[v]);
		return pai[v];
	}
	
	private void link(int v, int u){
		if(ordem[v] < ordem[u])
			pai[v] = u;
		else{
			if(ordem[v] == ordem[u])
				ordem[v]++;
			pai[u] = v;
		}
	}
	
	public void union(int v, int u){
		link(findSet(v), findSet(u));
	}

}
