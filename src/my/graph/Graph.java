package my.graph;

import java.util.LinkedList;

public class Graph {
	class Node{
		int data;
		LinkedList<Node> adjacent;
		boolean marked;
		Node (int data) {
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<Node>();
		}
	}
	Node[] nodes;
	Graph(int size) {
		nodes = new Node[size];
		for(int i = 0; i < size; i++) {
			// 편의상 인덱스를 값으로 사용
			nodes[i] = new Node(i);
		}
	}
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		if(!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if(!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}
	void visit(Node n) {
		System.out.println(n.data + " ");
	}
}
