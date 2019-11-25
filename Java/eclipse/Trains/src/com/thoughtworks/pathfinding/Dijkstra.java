package com.thoughtworks.pathfinding;


public class Dijkstra {
  private int predecessor[];
  private double p[];
  private Graph graph;

  public Dijkstra (Graph graph) { 
	  this.graph = graph; 
  }  
  
  public int[] getPredecessor() {
	return predecessor;
  }

	public void setPredecessor(int[] predecessor) {
		this.predecessor = predecessor;
	}



	public double[] getP() {
		return p;
	}



	public void setP(double[] p) {
		this.p = p;
	}



	public Graph getGraph() {
		return graph;
	}



	public void setGraph(Graph graph) {
		this.graph = graph;
	}


	/*This method get the least-cost path based on the graph*/
	public void getTreeLCP (int root) throws Exception {
	    int n = this.graph.numVertex();
	    this.p = new double[n]; // weight of vertex
	    int vs[] = new int[n+1]; // vertex
	    this.predecessor = new int[n];
	    
	    for (int u = 0; u < n; u ++) {
	      this.predecessor[u] = -1;
	      p[u] = Double.MAX_VALUE; // infinity
	      vs[u+1] = u; // Indirect heap to be build
	    }
	    p[root] = 0;
	    IndirectMinFPHeap heap = new IndirectMinFPHeap (p, vs); 
	    heap.build ();
	    while (!heap.empty ()) {
	      int u = heap.withdrawsMin (); 
	      if (!this.graph.emptyListAdj(u)) {
	        Graph.Edge adj = graph.firstListAdj(u);
	        while (adj != null) {
	          int v = adj.v2 ();
	          if (this.p[v] > (this.p[u] + adj.weight())) {
	            predecessor[v] = u; 
	            heap.keyDecreases (v, this.p[u] + adj.weight());
	          }
	          adj = graph.nextAdj(u);
	        }
	      }
	    }
	  }
  
  public int predecessor (int u) { 
	  return this.predecessor[u]; 
  }
  
  public double weight (int u) { 
	  return this.p[u]; 
  }
  

}