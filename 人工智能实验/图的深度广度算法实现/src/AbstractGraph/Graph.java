package AbstractGraph;
import java.util.*;
public interface Graph<V> {
	/**Return the number of vertices in the graph*/
	public int getSize();
	
	/**Return the vertices*/
	public java.util.List<V> getVertices();
	
	/**Return the object for the specified vertex index*/
	public V getVertex(int index);
	
	/**Return the index for the specified vertex object*/
	public int getIndex(V v);
	
	/**Return the neighbors of vertex with the specified index*/
	public java.util.List<Integer> getNeighbors(int index);
	
	/**Return degree for a specified vertex*/
	public int getDegree(int v);
	
	/**Return the adjacency matrix*/
	public int [][]getAdjacencyMatrix();
	
	/**Print the adjacency matrix*/
	public void printAdjacencyMatrix();
	
	/**Print the edges*/
	public void printEdges();
	
	/**Obtain a DFS tree*/
	public AbstractGraph<V>.Tree dfs(int v);
	
	/**Obtain a BFS tree*/
	public AbstractGraph<V>.Tree bfs(int v);
	

}
