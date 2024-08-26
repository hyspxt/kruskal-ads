package src.algorithm.MST;

import java.util.ArrayList;
import java.util.HashMap;

import src.algorithm.sorting.Sorting;
import src.datastructure.graph.*;
import src.datastructure.unionfind.*;

/**
 * This class contains the implementation of the Kruskal's algorithm for the
 * construction of a Minimum Spanning Tree (MST) of a weighted graph.
 * 
 * @param <D> type of the data stored in the nodes of the graph
 */
public class Kruskal<D> implements MST<D> {

	// The WeightedGraph on which the MST is computed
	private WeightedGraph<D> t;

	// The total weight of the MST
	private double weight;

	/**
	 * Computes the Minimum Spanning Tree (MST) of the specified weighted graph.
	 * 
	 * @param g the weighted graph
	 */
	public void compute(WeightedGraph<D> g) {
		/* init ds and MST graph, QURank definetely the best
		 * with a large number of unions (4example in larger graphs) */
		QuickUnionRank<D> unionFind = new QuickUnionRank<>();
		this.t = new WeightedGraphAL<>(); /* MST */
		this.weight = 0;

		/* ds to save unionFind both nodes and vertexes */
		ArrayList<QUnode<D>> ufNodes = new ArrayList<>(g.vertexNum());
		ArrayList<WeightedEdge<D>> edges = new ArrayList<>(g.edgeNum());
		HashMap<D, QUnode<D>> nodeMap = new HashMap<>(); /* nodes */
		HashMap<D, Vertex<D>> vertexMap = new HashMap<>(); /* vertexes in MST */

		/* for each vertex, we add it in the MST graph and store it in the HashMap
		 * for further evaluation through the edges. */
		for (Vertex<D> v : g.vertexes()) {
			Vertex<D> mstVertex = t.addVertex(v.data);
			vertexMap.put(v.data, mstVertex);
			/* We also create a disjoint-set node for each vertex and store it 
			 * in the UnionFind and in the HashMap for source and destination nodes. */
			QUnode<D> ufNode = unionFind.makeSet(v.data);
			ufNodes.add(ufNode);
			nodeMap.put(v.data, ufNode);
		}

		/* collect all weighted edges in the ArrayList */
		for (Edge<D> e : g.edges()) /* then, sort them by weight with sorting algorithm (heapsort) */
			edges.add((WeightedEdge<D>) e);
		Sorting.heapsort(edges);

		/* check iteratively weighted edges to build the MST */
		for (WeightedEdge<D> edge : edges) {
			QUset setSource = unionFind.find(nodeMap.get(edge.source.data)); /* source node */
			QUset setDest = unionFind.find(nodeMap.get(edge.dest.data)); /* dest node */

			if (setSource != setDest) { /* src and dest are in different sets */
				/* then, this edge should be added to the MST graph */
				t.addEdge(new WeightedEdge<>(vertexMap.get(edge.source.data), vertexMap.get(edge.dest.data),
						edge.weight));
				
				/* --- edit: this is not necessary, as the graph is undirected --- 
				t.addEdge(new WeightedEdge<>(vertexMap.get(edge.dest.data), vertexMap.get(edge.source.data),
				 		edge.weight)); */
				/* perform a union on those sets */
				unionFind.union(setSource, setDest);
				/* update the total weight of the MST */
				this.weight += edge.weight;
			}
		}
	}

	/**
	 * Returns the Minimum Spanning Tree (MST) of the weighted graph.
	 * 
	 * @return the Minimum Spanning Tree (MST) of the weighted graph
	 */
	public WeightedGraph<D> spanningTree() {
		return this.t;
	}

	/**
	 * Returns the total weight of the Minimum Spanning Tree (MST) of the weighted
	 * graph.
	 * 
	 * @return the total weight of the Minimum Spanning Tree (MST) of the weighted
	 *         graph
	 */
	public double totalWeight() {
		return weight;
	}
}