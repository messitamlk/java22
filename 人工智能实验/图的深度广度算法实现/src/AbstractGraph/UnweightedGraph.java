package AbstractGraph;
import java.util.*;
public  class UnweightedGraph<V> extends AbstractGraph<V> {
	
	public UnweightedGraph(int[][] edges,V[] vertices){
		super (edges,vertices);
	}
	public UnweightedGraph(List<Edge> edges,List<V> vertices){
		super (edges,vertices);
	}
	public UnweightedGraph(List<Edge> edges,int NumberOfVertices){
		super (edges,NumberOfVertices);
		
	}
	public UnweightedGraph(int[][] edges,int NumberOfVertices){
		super (edges,NumberOfVertices);
	}
	
	
	
}
