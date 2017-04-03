package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

public class HeapTernario {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public HeapTernario(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo + 1];
	}
	
	private void subir(int i){
		int pai = i/3;
		if(pai >= 1){
			if(vetor[pai] < vetor[i]){
				int aux = vetor[pai];
				vetor[pai] = vetor[i];
				vetor[i] = aux;
				this.subir(pai);
			}
		}
	}
	
	private void descer(int i){
		int filho = 3 * i;
		if(filho < n){
			if((filho + 1 <= n) && (vetor[filho + 1] > vetor[filho])) filho++;
			else if(vetor[filho - 1] > vetor[filho]) filho--;
			
			if(vetor[filho] > vetor[i]){
				int aux = vetor[filho];
				vetor[filho] = vetor[i];
				vetor[i] = aux;
				this.descer(filho);
			}
		}
	}
	
	public void contruir(List<Integer> entrada){
		for(int i = 0; i < entrada.size(); i++){
			vetor[i + 1] = entrada.get(i);
		}		
		for(int i = n/2; i >= 1; i--){
			this.descer(i);
		}
	}
	
	public int getMaximaPrioridade(){
		return vetor[1];
	}
	
	public int remove(){
		if(n >= 1){
			int aux = vetor[1];
			vetor[1] = vetor[n];
			n--;
			this.descer(1);
			return aux;
		}
		
		return 0;
	}	
	
	public void inserir(int prioridade){
		if(n + 1 <= nMaximo){
			n++;
			vetor[n] = prioridade;
			this.subir(n);
		}
	}
	
	public void alterarPrioridade(int prioridade, int novaPrioridade){
		if(n >= 1){
			for(int i = 1; i <= n; i++){
				if(vetor[i] == prioridade){
					vetor[i] = novaPrioridade;
					if(prioridade < novaPrioridade){
						this.subir(i);
					} else if(prioridade > novaPrioridade){
						this.descer(i);
					}
				}
			}
		}
	}	
}
