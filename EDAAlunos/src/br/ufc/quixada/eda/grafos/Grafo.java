package br.ufc.quixada.eda.grafos;

public class Grafo {

	private int qtdVertices; // qtd de vertices
	private int qtdArestas; // qtd de arestas
	private Aresta arestas[] = null;
	
	public Grafo(int n, int m){
		this.qtdVertices = n;
		this.qtdArestas = m;
		arestas = new Aresta[m];
	}

	public int getQtdVertices() {
		return qtdVertices;
	}

	public int getQtdArestas() {
		return qtdArestas;
	}

	public Aresta[] getArestas() {
		return arestas;
	}
	
	public Aresta getArestas(int i){
		return arestas[i];
	}
}
