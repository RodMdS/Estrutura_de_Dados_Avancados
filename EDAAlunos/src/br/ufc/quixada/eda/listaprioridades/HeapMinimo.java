package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

public class HeapMinimo {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int id[] = null;
	private int n = 0;

	public HeapMinimo(int Nmaximo){
		nMaximo = Nmaximo + 1;
		vetor = new int[nMaximo];
		id = new int[nMaximo];
	}

	private void subir(int i){
		int j = i/2;
		if(j >= 1){
			if(vetor[j] > vetor[i]){
				int aux = vetor[j];
				int aux2 = id[j];
				vetor[j] = vetor[i];
				id[j] = id[i];
				vetor[i] = aux;
				id[i] = aux2;
				this.subir(j);
			}
		}
	}

	private void descer(int i){
		int j = 2 * i;
		if(j < n){
			if((j + 1 <= n) && (vetor[j + 1] < vetor[j])) j++;
			if(vetor[j] < vetor[i]){
				int aux = vetor[j];
				int aux2 = id[j];
				vetor[j] = vetor[i];
				id[j] = id[i];
				vetor[i] = aux;
				id[i] = aux2;
				this.descer(j);
			}
		}
	}

	public void construir(List<Integer> prioridade, int tam){
		for(int i = 0; i < prioridade.size(); i++){
			vetor[i + 1] = prioridade.get(i); 
			n++;
		}
		
		for(int i = 1; i <= tam; i++)
			id[i] = i;

		for(int i = n/2; i >= 1; i--)
			this.descer(i);

	}

	public int getMinimaPrioridade(){
		return id[1];
	}

	public int remove(){
		if(n >= 1){
			//int aux = vetor[1];
			int aux2 = id[1];
			vetor[1] = vetor[n];
			id[1] = id[n];
			n--;
			this.descer(1);
			return aux2;
		}

		return 0;
	}	

	public void inserir(int prioridade){
		if(n + 1 <= nMaximo){
			n++;
			vetor[n] = prioridade;
			id[n] = n;
			this.subir(n);
		}
	}

	public void alterarPrioridade(int id, int novaPrioridade){
		if(n >= 1){
			for(int i = 1; i <= n; i++){
				if(this.id[i] == id){
					if(vetor[i] > novaPrioridade){
						vetor[i] = novaPrioridade;
						this.subir(i);
					} else if(vetor[i] < novaPrioridade){
						vetor[i] = novaPrioridade;
						this.descer(i);
					}
				}
			}
		}
	}
}
