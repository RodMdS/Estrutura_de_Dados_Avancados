package br.ufc.quixada.eda.grafos;

public class Aresta {

	private int u; // vertice
	private int v; // vertice
	private int custo; // valor da aresta
	
	public Aresta(int u, int v, int custo){
		this.u = u;
		this.v = v;
		this.custo = custo;
	}
	
	public int getU() {
		return u;
	}
	
	public int getV() {
		return v;
	}
	
	public int getCusto() {
		return custo;
	}
	
}
