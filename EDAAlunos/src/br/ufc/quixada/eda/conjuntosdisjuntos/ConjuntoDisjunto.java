package br.ufc.quixada.eda.conjuntosdisjuntos;

public class ConjuntoDisjunto {

	private int nMaximo = 0;
	private int pai[] = null;
	private int ordem[] = null;


	public ConjuntoDisjunto(int nMaximo){
		this.nMaximo = nMaximo;
		pai = new int[this.nMaximo + 1];
		ordem = new int[this.nMaximo + 1];
	}

	public void make_set(int ele){
		pai[ele] = ele;
		ordem[ele] = 0;
	}

	public void make_set_all(){
		for(int i = 0; i < nMaximo; i++){
			make_set(i);
		}
	}

	public int find_set(int ele){ // inteligente
		if(pai[ele] == ele) return ele;
		pai[ele] = find_set(pai[ele]);
		return pai[ele];
	}

	private void link(int ele1, int ele2){ // inteligente
		if(ordem[ele1] < ordem[ele2])
			pai[ele1] = ele2;
		else{
			if(ordem[ele1] == ordem[ele2])
				ordem[ele1]++;
			pai[ele2] = ele1;
		}
	}

//	public int find_set(int ele){ // burro
//		if(pai[ele] == ele) return ele;
//		else return find_set(pai[ele]);
//	}
//
//	private void link(int ele1, int ele2){ // burro
//		pai[ele1] = ele2;
//	}

	public void union(int ele1, int ele2){
		link(find_set(ele1), find_set(ele2));
	}
}
