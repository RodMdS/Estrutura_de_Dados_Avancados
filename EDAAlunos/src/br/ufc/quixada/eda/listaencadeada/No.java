package br.ufc.quixada.eda.listaencadeada;

public class No {

	private Integer chave;
	private String valor;
	private No proximo;
	
	public No(Integer chave, String valor, No prox){
		this.chave = chave;
		this.valor = valor;
		this.proximo = prox;
	}
	
	public Integer getChave() {
		return chave;
	}

	public void setChave(Integer chave) {
		this.chave = chave;
	}
	
	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}

	public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
}
