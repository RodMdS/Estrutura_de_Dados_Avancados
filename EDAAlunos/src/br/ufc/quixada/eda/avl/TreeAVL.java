package br.ufc.quixada.eda.avl;

public class TreeAVL<T> {
	private NodeAVL<T> root = null;

	private int height(NodeAVL<T> node){
		return (node != null ? node.getHeight() : 0);
	}

	private NodeAVL<T> leftRotation(NodeAVL<T> node){
		NodeAVL<T> aux = node.getRight();
		node.setRight(aux.getLeft());
		aux.setLeft(node);
		node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
		return aux;
	}

	private NodeAVL<T> rightRotation(NodeAVL<T> node){
		NodeAVL<T> aux = node.getLeft();
		node.setLeft(aux.getRight());
		aux.setRight(node);
		node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
		return aux;
	}

	private NodeAVL<T> doubleLeftRotation(NodeAVL<T> node){
		node.setRight(rightRotation(node.getRight()));
		return leftRotation(node);
	}

	private NodeAVL<T> doubleRightRotation(NodeAVL<T> node){
		node.setLeft(leftRotation(node.getLeft()));
		return rightRotation(node);
	}

	private NodeAVL<T> insert_r(NodeAVL<T> node, int key, T info){
		if(node == null){
			NodeAVL<T> no = new NodeAVL<T>(key, info);
			return no;
		}else if(node.getKey() > key){
			node.setLeft(insert_r(node.getLeft(), key, info));
			if(height(node.getLeft()) - height(node.getRight()) == 2){
				if(height(node.getLeft().getLeft()) > height(node.getLeft().getRight()))
					node = rightRotation(node);
				else
					node = doubleRightRotation(node);
			}
		}else if(node.getKey() < key){
			node.setRight(insert_r(node.getRight(), key, info));
			if(height(node.getRight()) - height(node.getLeft()) == 2){
				if(height(node.getRight().getRight()) > height(node.getRight().getLeft()))
					node = leftRotation(node);
				else
					node = doubleLeftRotation(node);
			}
		}
		node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
		return node;
	}

	public void insert(int key, T info){
		this.root = insert_r(this.root, key, info);
	}

	// METHODS FOR SHOW THE TREE
	private String str(int nivel, char c){
		String res = "";
		if(nivel == 0)
			return res;
		while(nivel > 0){
			res += " ";
			nivel--;
		}

		return res;
	}

	private void rshow(NodeAVL<T> node, int nivel){
		if(node == null)
			return;

		rshow(node.getLeft(), nivel + 1);
		System.out.println((str(4 * nivel, ' ')) + node.getKey());
		rshow(node.getRight(), nivel + 1);
	}

	public void show(){
		rshow(this.root, 0);
	}
}
