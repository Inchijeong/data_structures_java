package my.graph;

class GraphDFSR extends Graph {
	GraphDFSR(int size) {
		super(size);
	}
	void dfsR(Node r) {
		if(r == null) return;
		r.marked = true;
		visit(r);
		for(Node n : r.adjacent) {
			if(n.marked == false) {
				dfsR(n);
			}
		}
	}
	void dfsR(int index) {
		Node r = nodes[index];
		dfsR(r);
	}
	void dfsR() {
		dfsR(0);
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
DFS(0) - Recursive
0 1 2 4 3 5 6 8 7
------------------
DFS(3) - Recursive
3 1 0 2 4 5 6 8 7
------------------
*/
public class DFSRTest {
	public static void main(String[] args) {
		GraphDFSR g = new GraphDFSR(9);
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
		System.out.println("DFS(0) - Recursive : ");
		g.dfsR();
	}
}
