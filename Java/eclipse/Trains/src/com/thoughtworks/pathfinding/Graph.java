package com.thoughtworks.pathfinding;

public class Graph {
  public static class Edge {
    private int vertex1, vertex2, weight;
    
    public Edge (int v1, int v2, int weight) {
      this.vertex1 = v1; 
      this.vertex2 = v2; 
      this.weight = weight;
    }
    
    public int weight () { 
    	return this.weight; 
    }
    
    public int v1 () { 
    	return this.vertex1; 
    }
    
    public int v2 () { 
    	return this.vertex2; 
    }
  }
  
  private int matrix[][]; // This is the matrix of weights of int type
  private int numVertex;
  private int position[]; // This is a actual position roam on adjacencies of a v

  public Graph (int numVertex) {
    this.matrix = new int[numVertex][numVertex];
    this.position = new int[numVertex]; 
    this.numVertex = numVertex; 
    for (int i = 0; i < this.numVertex; i++) {
      for (int j = 0; j < this.numVertex; j++) this.matrix[i][j] = 0;
      this.position[i] = -1; 
    }
  }
  
  public void insertEdge (int v1, int v2, int weight) {
    this.matrix[v1][v2] = weight; 
  }
  
  public boolean existEdge (int vertex1, int vertex2) {
    return (this.matrix[vertex1][vertex2] > 0);
  }
  
  public boolean emptyListAdj (int v) {
    for (int i =0; i < this.numVertex; i++)
      if (this.matrix[v][i] > 0) {
    	  return false;
      }
    return true;
  }
  
  public Edge firstListAdj (int v) {
    /*This return the first edge which the vertex v participate or 
     * if the list of adjacencie of v is empty*/
    this.position[v] = -1; return this.nextAdj (v);
  }
  
  public Edge nextAdj (int v) {
    /*This method return the next edge which the vertex v participate or
     * if the list of adjacencies of v to be at the end.*/
    this.position[v] ++;
    while ((this.position[v] < this.numVertex) && 
           (this.matrix[v][this.position[v]] == 0)){
    	this.position[v]++;
    }
    if (this.position[v] == this.numVertex){
    	return null;
    }
    else {
    	return new Edge (v, this.position[v], this.matrix[v][this.position[v]]);
    }
  }
  
  public Edge withDrawsEdge (int v1, int v2) {
    if (this.matrix[v1][v2] == 0) {
    	return null; // the edge not exist
    }else {
      Edge edge = new Edge (v1, v2, this.matrix[v1][v2]);
      this.matrix[v1][v2] = 0; 
      return edge;
    }
  }
  
   
  public int numVertex () { 
	  return this.numVertex; 
  }
  
  public Graph graphTransposed () {
    Graph graphTransposed = new Graph (this.numVertex); 
    for (int v = 0; v < this.numVertex; v++)
      if (!this.emptyListAdj (v)) {
        Edge adj = this.firstListAdj (v);
        while (adj != null) {
          graphTransposed.insertEdge (adj.v2 (), adj.v1 (), adj.weight());
          adj = this.nextAdj (v);
        }
      }
    return graphTransposed;
  }

	public int[][] getMat() {
		return matrix;
	}
	
	public void setMat(int[][] mat) {
		this.matrix = mat;
	}
	
	public int getNumVertices() {
		return numVertex;
	}
	
	public void setNumVertices(int numVertices) {
		this.numVertex = numVertices;
	}
	
	public int[] getPos() {
		return position;
	}
	
	public void setPos(int[] pos) {
		this.position = pos;
	}
  
  
  
}
