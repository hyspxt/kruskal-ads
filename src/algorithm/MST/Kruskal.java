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
		/* init ds and MST graph */
        QuickUnionRank<D> unionFind = new QuickUnionRank<>();
        this.t = new WeightedGraphAL<>(); /* MST */
        this.weight = 0;

        /* ds to store the union-find nodes and vertex */
        ArrayList<QUnode<D>> ufNodes = new ArrayList<>(g.vertexNum());
        HashMap<D, QUnode<D>> nodeMap = new HashMap<>(); /* node mapping */
        HashMap<D, Vertex<D>> vertexMap = new HashMap<>(); /* vertex mapping */

        // Step 3: Add vertices to the MST graph and union-find structure
        for (Vertex<D> v : g.vertexes()) {
            Vertex<D> mstVertex = t.addVertex(v.data); // Add vertex to the MST graph
            vertexMap.put(v.data, mstVertex); // Store vertex in the map for future reference

            QUnode<D> ufNode = unionFind.makeSet(v.data); // Create a disjoint-set node
            ufNodes.add(ufNode); // Add the node to the list
            nodeMap.put(v.data, ufNode); // Store node in map for easy access
        }

        // Step 4: Collect and sort all edges by their weight
        ArrayList<WeightedEdge<D>> edges = new ArrayList<>(g.edgeNum());
        for (Edge<D> e : g.edges()) {
            edges.add((WeightedEdge<D>) e);
        }
        Sorting.quicksort(edges); // Sort edges by weight

        // Step 5: Iterate through the sorted edges and construct the MST
        for (WeightedEdge<D> edge : edges) {
            // Find the disjoint sets (or components) of the source and destination vertices
            QUset setSource = unionFind.find(nodeMap.get(edge.source.data)); // Get the source node
            QUset setDest = unionFind.find(nodeMap.get(edge.dest.data)); // Get the destination node

            // If the vertices are in different sets, include this edge in the MST
            if (setSource != setDest) {
                // Add the edge to the MST graph (both directions)
                t.addEdge(new WeightedEdge<>(vertexMap.get(edge.source.data), vertexMap.get(edge.dest.data), edge.weight));
                t.addEdge(new WeightedEdge<>(vertexMap.get(edge.dest.data), vertexMap.get(edge.source.data), edge.weight));

                // Union the sets
                unionFind.union(setSource, setDest);

                // Update the total weight of the MST
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