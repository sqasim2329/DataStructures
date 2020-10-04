package com.data.graphs; 
import java.util.ArrayList; 
import java.util.LinkedList; 
import java.util.List; 
//Can use simple indgree solution
public class DetectCycleInGraph { 
	
	private final int V; 
	private final List<List<Integer>> adj; 

	public DetectCycleInGraph(int V) 
	{ 
		this.V = V; 
		adj = new ArrayList<>(V); 
		
		for (int i = 0; i < V; i++) 
			adj.add(new LinkedList<>()); 
	} 
	
	// This function is a variation of DFSUtil() in 
	// https://www.geeksforgeeks.org/archives/18212 
	private boolean isCyclicUtil(int i, boolean[] visited, 
									boolean[] recStack) 
	{ 
		
		// Mark the current node as visited and 
		// part of recursion stack 
		if (recStack[i]) 
			return true; 

		if (visited[i]) 
			return false; 
			
		visited[i] = true; 

		recStack[i] = true; 
		List<Integer> children = adj.get(i); 
		
		for (Integer c: children) 
			if (isCyclicUtil(c, visited, recStack)) 
				return true; 
				
		recStack[i] = false; 

		return false; 
	} 

	private void addEdge(int source, int dest) { 
		adj.get(source).add(dest); 
	} 

	// Returns true if the graph contains a 
	// cycle, else false. 
	// This function is a variation of DFS() in 
	// https://www.geeksforgeeks.org/archives/18212 
	private boolean isCyclic() 
	{ 
		
		// Mark all the vertices as not visited and 
		// not part of recursion stack 
		boolean[] visited = new boolean[V]; 
		boolean[] recStack = new boolean[V]; 
		
		
		// Call the recursive helper function to 
		// detect cycle in different DFS trees 
		for (int i = 0; i < V; i++) 
			if (isCyclicUtil(i, visited, recStack)) 
				return true; 

		return false; 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		DetectCycleInGraph graph = new DetectCycleInGraph(4); 
		graph.addEdge(0, 1); 
		graph.addEdge(0, 2); 
		graph.addEdge(1, 2); 
		graph.addEdge(2, 0); 
		graph.addEdge(2, 3); 
		graph.addEdge(3, 3); 
		
		if(graph.isCyclic()) 
			System.out.println("Graph contains cycle"); 
		else
			System.out.println("Graph doesn't "
									+ "contain cycle"); 
	} 
} 

// This code is contributed by Sagar Shah.



class GFG  
{ 
    
    static int WHITE = 0, GRAY = 1, BLACK = 2; 
  
    static class Graph  
    { 
            int V; 
            LinkedList<Integer>[] adjList; 
              
            // Constructor  
            Graph(int ver) 
            { 
                V = ver; 
                adjList = new LinkedList[V]; 
                for (int i = 0; i < V; i++) 
                    adjList[i] = new LinkedList<>(); 
            } 
    } 
  
   
    static void addEdge(Graph g, int u, int v) 
    { 
            g.adjList[u].add(v); // Add v to u's list.  
    } 
  
    // Recursive function to find if there is back edge  
    // in DFS subtree tree rooted with 'u'  
    static boolean DFSUtil(Graph g, int u, int[] color)  
    { 
            // GRAY : This vertex is being processed (DFS  
            // for this vertex has started, but not  
            // ended (or this vertex is in function  
            // call stack)  
            color[u] = GRAY; 
              
            // Iterate through all adjacent vertices 
            for (Integer in : g.adjList[u])  
            { 
                // If there is 
                if (color[in] == GRAY) 
                    return true; 
  
                // If v is not processed and there is a back  
                // edge in subtree rooted with v  
                if (color[in] == WHITE && DFSUtil(g, in, color) == true) 
                    return true; 
            } 
  
            // Mark this vertex as processed  
            color[u] = BLACK; 
            return false; 
    } 
  
    // Returns true if there is a cycle in graph 
    static boolean isCyclic(Graph g) 
    { 
            // Initialize color of all vertices as WHITE 
            int[] color = new int[g.V]; 
            for (int i = 0; i < g.V; i++) 
            { 
                color[i] = WHITE; 
            } 
  
            // Do a DFS traversal beginning with all  
            // vertices  
            for (int i = 0; i < g.V; i++)  
            { 
                if (color[i] == WHITE) 
                { 
                    if(DFSUtil(g, i, color) == true)  
                        return true; 
                }  
            } 
            return false; 
  
    } 
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
            // Create a graph given in the above diagram 
            Graph g = new Graph(4); 
            addEdge(g, 0, 1); 
            addEdge(g, 0, 2); 
            addEdge(g, 1, 2); 
            addEdge(g, 2, 0); 
            addEdge(g, 2, 3); 
            addEdge(g, 3, 3); 
            if (isCyclic(g)) 
                System.out.println("Graph contains cycle"); 
            else
                System.out.println("Graph doesn't contain cycle"); 
    } 
}
