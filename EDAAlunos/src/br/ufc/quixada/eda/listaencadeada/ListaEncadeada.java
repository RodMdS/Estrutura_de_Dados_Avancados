package br.ufc.quixada.eda.listaencadeada;

public class ListaEncadeada {

	private No head = null;
	
	public ListaEncadeada(){
		this.head = null;
	}
	
	// add, remove, size, get
	private int size_aux(No node){
		if(node == null)
			return 0;
		return 1 + size_aux(node.getProximo());
	}
	public int size(){
		return size_aux(head);
	}
	
	private No get_aux(Integer chave, String valor, No node){
		if(node == null)
			return null;
		if(node.getChave() == chave || node.getValor().equals(valor))
			return node;
		
		return get_aux(chave, valor, node.getProximo());
	}
	public No get(Integer chave, String valor){
		return get_aux(chave, valor, head);
	}
	
	private boolean contains_aux(Integer chave, String valor, No node){
		if(node == null)
			return false;
		if(node.getChave() == chave || node.getValor().equals(valor))
			return true;
		
		return contains_aux(chave, valor, node.getProximo());
	}
	public boolean contains(Integer chave, String valor){
		return contains_aux(chave, valor, head);
	}
	
	private No add_aux(Integer chave, String valor){
		if(head == null){
			return new No(chave, valor, null);
		}
		
		return new No(chave, valor, head);
		
	}
	public void add(Integer chave, String valor){
		head = add_aux(chave, valor);
	}
	
	private void remove_aux(Integer chave, String valor, No node){
		if(node != null){
			if(head.getChave() == chave && head.getValor().equals(valor))
				head = head.getProximo();
			if(node.getProximo() != null){
				if(node.getProximo().getChave() == chave && node.getProximo().getValor().equals(valor)){
					node.setProximo(node.getProximo().getProximo());
					return;
				}
				remove_aux(chave, valor, node.getProximo());
			}
		}
	}
	public void remove(Integer chave, String valor){
		remove_aux(chave, valor, head);
	}
	
	private void print_aux(No node){
		while(node != null){
			System.out.println(node.getValor());
			node = node.getProximo();
		}
	}
	public void print(){
		print_aux(head);
	}
}
