package br.ufc.quixada.eda.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.ufc.quixada.eda.grafos.Aresta;
import br.ufc.quixada.eda.grafos.Grafo;

public class EDAUtil {

	/**
	 * Ler o arquivo que contém as prioridades iniciais da lista de prioridades.
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static List<Integer> getDadosIniciais(String path) throws IOException {
		List<Integer> entrada = new ArrayList<Integer>();
		Scanner scanner = new Scanner(new FileReader(path)).useDelimiter("\r\n");

		while (scanner.hasNext())
			entrada.add(scanner.nextInt());

		scanner.close();
		return entrada;
	}

	/**
	 * Ler as operações que serão realizadas na lista de prioridades após a sua criação.
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static List<Operacao> getOperacoes(String path) throws IOException {
		List<Operacao> operacoes = new ArrayList<Operacao>();
		Scanner scanner = new Scanner(new FileReader(path)).useDelimiter(" |\r\n");	
		while (scanner.hasNext())
			operacoes.add(new Operacao(scanner.next(), scanner.nextInt(), scanner.nextInt()));

		scanner.close();
		return operacoes;
	}

	// métodos para ordenação
	private static int particiona(Aresta[] arestas, int p, int u){		
		Aresta pivo = arestas[p];
		int i = p + 1;
		int f = u;
		while(i <= f){
			if(arestas[i].getCusto() <= pivo.getCusto())
				i++;
			else if(pivo.getCusto() < arestas[f].getCusto())
				f--;
			else {
				Aresta troca = arestas[i];
				arestas[i] = arestas[f];
				arestas[f] = troca;
				i++;
				f--;
			}
		}
		arestas[p] = arestas[f];
		arestas[f] = pivo;
		return f;
	}
	
	public static void quickSort(Aresta[] arestas, int inicio, int fim){
		if(inicio < fim){
			int meio = particiona(arestas, inicio, fim);
			quickSort(arestas, inicio, meio - 1);
			quickSort(arestas, meio + 1, fim);
		}
	}
	
	public static Grafo getGrafo(String path) throws IOException {
		Grafo g = null;
		Scanner scanner = new Scanner(new FileReader(path)).useDelimiter(" |\r\n");

		if(scanner.hasNext()){
			g = new Grafo(scanner.nextInt(), scanner.nextInt());

			int i = 0;
			//int tam = g.getArestas().length;
			while(scanner.hasNext()){
				//if(i < tam){
				g.getArestas()[i] = new Aresta(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
				i++;
				//}
			}
		}

		scanner.close();
		return g;
	}
}