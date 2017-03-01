package AbstractGraph;
import java.util.*;
public abstract class AbstractGraph<V> implements Graph<V>{
	protected  List<V> vertices;//Store vertices
	protected List<List<Integer>>neighbors;// Adjacency lists
	
	/**Construct a graph from edges and vertices stored in arrays*/
	protected AbstractGraph(int [][]edges,V[]vertices){
		this.vertices = new ArrayList<V>();
		for (int i=0;i<vertices.length;i++)
			this.vertices.add(vertices[i]);
		createAdjacencyLists(edges,vertices.length);
		
	}
	/**Construct a graph from edges and vertices stored in List*/
	protected AbstractGraph(List<Edge> edges,List<V>vertices){
		this.vertices = vertices;
		createAdjacencyLists(edges,vertices.size());
		
	}
	/**Construct a graph from edges and vertices 0,1,2 and edge list*/
	protected AbstractGraph(List <Edge>edges,int numberOfVertices){
		vertices = new ArrayList<V>();//Create vertices
		for (int i=0;i<numberOfVertices;i++)
			vertices.add((V)(new Integer(i)));//vertices is {0,1,2,....}
		createAdjacencyLists(edges, numberOfVertices);
		
	}
	/**Construct a graph from edges and vertices 0,1,and edge array*/
	protected AbstractGraph(int [][]edges,int numberOfVertices){
		vertices = new ArrayList<V>();//Create vertices
		for (int i=0;i<numberOfVertices;i++)
			vertices.add((V)(new Integer(i)));//vertices is {0,1,....}
		createAdjacencyLists(edges, numberOfVertices);
		
	}
	/**Create adjacency lists for each vertex*/
	private void createAdjacencyLists(
			int [][]edges,int numberOfVertices){
		//create a linked list
		neighbors = new ArrayList<List<Integer>>();
		for (int i=0;i<numberOfVertices;i++)
		{neighbors.add(new ArrayList<Integer>());
		}
		for (int i=0;i<edges.length;i++){
			int u = edges[i][0];
			int v = edges[i][1];
			neighbors.get(u).add(v);
		}
		
	}
	
	/**Create adjacency lists for each vertex*/
	private void createAdjacencyLists(
			List<Edge> edges,int numberOfVertices){
		//create a linked list
		neighbors = new ArrayList<List<Integer>>();
		for (int i=0;i<numberOfVertices;i++)
		{
			neighbors.add(new ArrayList<Integer>());
		}
		for (Edge edge:edges){
			neighbors.get(edge.u).add(edge.v);
		}
		
	}
	
	/**Return the number of vertices in the graph*/
	public int getSize(){
		return vertices.size();
	}
	
	/** Return the vertices in the graph*/
	public List<V> getVertice(){
		return vertices;
	}
	
	/**Return the object for the specified vertex*/
	public V getVertex(int index){
		return vertices.get(index);
		
	}
	/**Return the index for the specified vertex object */
	public int getIndex(V v){
		return vertices.indexOf(v);
	}
	
	/**Return the neighbors of vertex with the specified index*/
	public List<Integer> getNeighbors(int index){
		return neighbors.get(index);
	}
	
	/**Return the degree for a specified vertex*/
	public int getDegree(int v){
		return neighbors.get(v).size();
	}
	/**Return the adjacency matrix*/
	public int [][] getAdjacencyMatrix(){
		int [][]adjacencyMatrix = new int [getSize()][getSize()];
		for(int i =0;i<neighbors.size();i++){
			for(int j=0;j<neighbors.get(i).size();j++)
			{
				int v =neighbors.get(i).get(j);
				adjacencyMatrix [i][v]= 1;
			}
		}
		return adjacencyMatrix ;
	}
	
	/**print the adjacency matrix*/
	public void printAdjacencyMatrix(){
		int [][]adjacencyMatrix = getAdjacencyMatrix();
		for(int i =0;i<adjacencyMatrix.length;i++){
			for(int j=0;j<adjacencyMatrix[0].length;j++){
				System.out.print(adjacencyMatrix[i][j] + " ");
			}
			System.out.println();
				}
		
	}
	
	/**print the edges */
	public void printEdges(){
		for(int u=0;u<neighbors.size();u++){
			System.out.print("Vertex "+u+": ");
			for(int j =0;j<neighbors.get(u).size();j++){
				System.out.print("("+u+", "+neighbors.get(u).get(j)+") ");
			}
			System.out.println();
		}
	}
	
	/**Edges inner class inside the AbstreactGraph class*/
	public static class Edge {
		public int u;//Starting vertex of the edge
		public int v;//Ending vertex of the edge
		/**Construct an edge for (u,v)*/
		public Edge (int u,int v){
			this.u=u;
			this.v= v;
		}
	}
	/**obtain a dfs  tree starting form vertex v*/
	public Tree dfs(int v){
		List<Integer>searchOrders = new ArrayList<Integer>();
		int []parent =  new int [vertices.size()];
		for(int i = 0 ;i<parent.length;i++)
			parent[i]=-1;//Initialize parent[i]=-1
		//Mark visited vertices
		boolean[]isVisited = new boolean[vertices.size()];
		//Recursively search
		dfs(v,parent,searchOrders,isVisited);
		//Return a search tree
		return new Tree(v,parent,searchOrders);
		
	}
	
	/**Recursive method for dfs search*/
	private void dfs(int v,int []parent,List<Integer>searchOrders,
			boolean[]isVisited){
		//Store the visited vertex
		searchOrders.add(v);
		isVisited[v] = true;//Vertex v visvited
		for(int i:neighbors.get(v)){
			if(isVisited[i])//vertex
			{
				parent[i]=v;//the parent of vertex i is v
				dfs(i,parent,searchOrders,isVisited);//Recursive search
			}
		}
		
	}
	/**Starting bfs search from vertex v*/
	public Tree bfs(int v){
		List<Integer>searchOrders = new ArrayList<Integer>();
		int []parent =  new int [vertices.size()];
		for(int i = 0 ;i<parent.length;i++)
			parent[i]=-1;//Initialize parent[i]=-1
		java.util.LinkedList<Integer>queue=
			new java.util.LinkedList<Integer>();//list use a queue
			boolean[]isVisited = new boolean[vertices.size()];
			queue.offer(v);
			isVisited[v] = true;
			while(!queue.isEmpty()){
				int u = queue.poll();//Dequeue to u
				searchOrders.add(u);
				for(int w:neighbors.get(u)){
					if(!isVisited[w]){
						queue.offer(w);
						parent[w]=u;
						isVisited[w] =true;
						
					}
				}
			}
		
		return new Tree(v,parent,searchOrders);
	}
	/**Tree inner class Abstractgraph class*/
	public class Tree{
		private int root;//the root of the tree
		private int []parent ;//Store the parent of each vertex
		private List<Integer>searchOrders;//Store the search order
		public Tree (int root ,int []parent,List<Integer>searchOrders){
			this.root=root;
			this.parent=parent;
			this.searchOrders = searchOrders;
		}
		public Tree(int root,int []parent){
			this.root=root;
			this.parent=parent;
		}
		public int getRoot(){
			return root;
		}
		public int getParent(int v){
			return parent[v];
		}
		public List<Integer> getsearchOrders(){
			return searchOrders;
		} 
		public int getNumberOfverticesFound(){
			return searchOrders.size();
		}
		public List<V>getPath(int index){
			ArrayList<V> path = new ArrayList<V>();
			do{
				path.add(vertices.get(index));
				
				
			}
			while(index!=-1);
			return path;
			
		}
		public void printPath(int index){
			
			List<V> path= getPath(index); 
			System.out.print("A path from "+ vertices.get(root)+" to "+
					vertices.get(index)+": ");
			for(int i = path.size()-1;i>=0;i--)
				System.out.print(path.get(i)+" ");
		}
		public void printTree(){
			System.out.print("Root is :"+ vertices.get(root));
			System.out.print("Edges: ");
			for(int i = 0; i<parent.length;i++){
				if(parent[i]!=-1){
					System.out.print("("+vertices.get(parent[i])+", "+
							vertices.get(i)+") ");
				}
			}
			System.out.println();
			
			
		}
	}
	
}