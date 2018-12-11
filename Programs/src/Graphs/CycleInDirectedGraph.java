package Graphs;
import java.util.HashSet;
import java.util.Set;

/**
 * http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 * 
 * Video Link : https://www.youtube.com/watch?v=rKQaZuoUR4M
 */
public class CycleInDirectedGraph {

	public boolean hasCycle(Graph<Integer> graph) {
		Set<Vertex<Integer>> whiteSet = new HashSet<>();// White set has all the vertices which have not been visited at all.
		Set<Vertex<Integer>> graySet = new HashSet<>();// Grey set has all the vertices which are being visited right now. 
		Set<Vertex<Integer>> blackSet = new HashSet<>();// Black set has all the vertices which have totally been visited meaning that all its children have also been visited.
		/*In this scenario, we need to maintain three above set, while doing DFS, if we encounter a vertex in a grey set, it means
		 * that we found a cycle. Why ? Because when a vertex is in grey set , it means that its neighbors, or ,its neighbor's neighbors
   or somebody in that hierarchy is still being explored and that vertex found a path back to the vertex in a grey set , indicating 
   that there's presence of a cycle 
		 */        
		for (Vertex<Integer> vertex : graph.getAllVertex()) {
			whiteSet.add(vertex);
		}

		while (whiteSet.size() > 0) {
			Vertex<Integer> current = whiteSet.iterator().next();
			if(dfs(current, whiteSet, graySet, blackSet)) {
				return true;
			}
		}
		return false;
	}

	private boolean dfs(Vertex<Integer> current, Set<Vertex<Integer>> whiteSet,
			Set<Vertex<Integer>> graySet, Set<Vertex<Integer>> blackSet ) {
		//move current to gray set from white set and then explore it.
		moveVertex(current, whiteSet, graySet);
		for(Vertex<Integer> neighbor : current.getAdjacentVertexes()) {
			//if in black set means already explored so continue.
			if (blackSet.contains(neighbor)) {
				continue;
			}
			//if in gray set then cycle found.
			if (graySet.contains(neighbor)) {
				return true;
			}
			if(dfs(neighbor, whiteSet, graySet, blackSet)) {
				return true;
			}
		}
		//move vertex from gray set to black set when done exploring.
		moveVertex(current, graySet, blackSet);
		return false;
	}

	private void moveVertex(Vertex<Integer> vertex, Set<Vertex<Integer>> sourceSet,
			Set<Vertex<Integer>> destinationSet) {
		sourceSet.remove(vertex);
		destinationSet.add(vertex);
	}

	public static void main(String args[]){
		Graph<Integer> graph = new Graph<>(true);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(4, 1);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(6, 4);
		CycleInDirectedGraph cdg = new CycleInDirectedGraph();
		System.out.println(cdg.hasCycle(graph));
	}
}