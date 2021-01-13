package my.graph;

import java.util.Stack;

class GraphDFS extends Graph {
	GraphDFS(int size) {
		super(size);
	}
	void dfs() {
		dfs(0);
	}
	void dfs(int index) {
		Node root = nodes[index];
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		root.marked = true;
		while(!stack.isEmpty()) {
			Node r = stack.pop();
			for(Node n : r.adjacent) {
				if(n.marked == false) {
					n.marked = true;
					stack.push(n);
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
DFS(0)
0 1 3 5 7 6 8 4 2
------------------
DFS(3)
3 5 7 6 8 4 2 1 0
------------------
*/
public class DFSTest {
	public static void main(String[] args) {
		GraphDFS g = new GraphDFS(9);
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
		System.out.println("DFS(0) : ");
		g.dfs();
	}
}
