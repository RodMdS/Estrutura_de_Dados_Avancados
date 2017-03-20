package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

/**
 * Implementa a lista de prioridade usando vetor ordenado.
 * Reparem que aqui voc� devem utilizar obrigat�riamente o quickSort 
 * para realizar a ordena��o, quando for necess�rio.
 * @author fabio
 *
 */
public class LPMaximaOrdenada {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public LPMaximaOrdenada(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}
	
	public void contruir(List<Integer> entrada){
		for(int i = 0; i < entrada.size(); i++){
			vetor[i] = entrada.get(i);
		}
		n = entrada.size();
		this.quickSort(0, n - 1);
	}
	
	public int getMaximaPrioridade(){
		if(n > 0){
			return vetor[n - 1];
		}
		return 0;
	}
	
	public int remove(){
		int valor = 0;
		if(n > 0){
			valor = vetor[n - 1];
			n--;
		}
		return valor;
	}	
	
	public void inserir(int prioridade){ // *lógica entendida com dificuldade
		if(n + 1 <= nMaximo){
			int i = n - 1;
			while(vetor[i] > prioridade && i >= 0){
				vetor[i + 1] = vetor[i];
				i--;
			}
			vetor[i + 1] = prioridade;
			n++;
		}
	}
	
	public void alterarPrioridade(int prioridade, int novaPrioridade){
		if(n > 0){
			int i = 0;
			for(; i < n; i++){
				if(vetor[i] == prioridade){
					break;
				}
			}
			if(novaPrioridade > prioridade){
				while(vetor[i + 1] < novaPrioridade){
					vetor[i] = vetor[i + 1];
					vetor[i + 1] = novaPrioridade;
					i++;
				}
			} else {
				while(vetor[i - 1] > novaPrioridade){
					vetor[i] = vetor[i - 1];
					vetor[i - 1] = novaPrioridade;
					i--;
				}
			}
		}
	}
	
	// métodos de ordenação
	private void quickSort(int ini, int fim){
		if(ini < fim){
			int meio = particiona(ini, fim);
			quickSort(ini, meio - 1);
			quickSort(meio + 1, fim);
		}
	}
	
	private int particiona(int p, int r){		
		int pivo = vetor[p];
		int i = p + 1;
		int f = r;
		while(i <= f){
			if(vetor[i] <= pivo)
				i++;
			else if(pivo < vetor[f])
				f--;
			else {
				int troca = vetor[i];
				vetor[i] = vetor[f];
				vetor[f] = troca;
				i++;
				f--;
			}
		}
		vetor[p] = vetor[f];
		vetor[f] = pivo;
		return f;
	}
	
	// método pra me axiliar nos testes
	public int[] getVetor(){
		return vetor;
	}
}
