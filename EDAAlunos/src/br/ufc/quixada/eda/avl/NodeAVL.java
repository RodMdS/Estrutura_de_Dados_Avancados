package br.ufc.quixada.eda.avl;

public class NodeAVL<T> {
	private NodeAVL<T> left, right;
	private int height, key;
	private T info;
	
	public NodeAVL(int key, T info){
		this.left = null;
		this.right = null;
		this.height = 1;
		this.key = key;
		this.setInfo(info);
	}

	public NodeAVL<T> getLeft() {
		return left;
	}

	public void setLeft(NodeAVL<T> left) {
		this.left = left;
	}

	public NodeAVL<T> getRight() {
		return right;
	}

	public void setRight(NodeAVL<T> right) {
		this.right = right;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
}
