package my.graph;

import java.util.LinkedList;
import java.util.Queue;

class GraphBFS extends Graph {
	GraphBFS(int size) {
		super(size);
	}
	void bfs() {
		bfs(0);
	}
	void bfs(int index) {
		Node root = nodes[index];
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		root.marked = true;
		while(!queue.isEmpty()) {
			Node r = queue.poll();
			for(Node n : r.adjacent) {
				if(n.marked == false) {
					n.marked = true;
					queue.offer(n);
				}
			}
			visit(r);
		}
	}
}

/*
------------------
 0
/
1 -- 3    7
│  / │ \ /
│ /  │  5
2 -- 4   \
          6 - 8
------------------
BFS(0)
0 1 2 3 4 5 6 7 8
------------------
BFS(3)
3 1 2 4 5 0 6 7 8
------------------
*/
public class BFSTest {
	public static void main(String[] args) {
		GraphBFS g = new GraphBFS(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		System.out.println("BFS(0) : ");
		g.bfs();
	}
}
