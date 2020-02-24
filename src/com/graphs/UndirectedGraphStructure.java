package com.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndirectedGraphStructure {

    // representing Graph as
    private Map<GraphVertex, List<GraphVertex>> adjVertices;

    public UndirectedGraphStructure() {
        this.adjVertices = new HashMap<>();
    }

    public void addVertex(final String label) {
        adjVertices.putIfAbsent(new GraphVertex(label), new ArrayList<>());
    }

    public void removeVertex(final String label) {
         //Create a new vertex object with this label
        GraphVertex vertex = new GraphVertex(label);
        //Now removwe this vertex from edges list if any and also remve it from the main vertex list
        adjVertices.values().forEach(e -> e.remove(vertex));
        adjVertices.remove(vertex);
    }

    public void addEdge(final String srcLabel, final String dstLabel) {
        GraphVertex src = new GraphVertex(srcLabel);
        GraphVertex dst = new GraphVertex(dstLabel);
        adjVertices.get(src).add(dst);
        adjVertices.get(dst).add(src);
    }

    public void removeEdge(final  String srcLabel, final String dstLabel) {
        GraphVertex src = new GraphVertex(srcLabel);
        GraphVertex dst = new GraphVertex(dstLabel);
        //Get the adjacency list for these vertices first.
        List<GraphVertex> srcVertexAdjList = adjVertices.get(src);
        List<GraphVertex> dstVertexAdjList = adjVertices.get(dst);

        if (srcVertexAdjList != null && srcVertexAdjList.size() > 0) {
            srcVertexAdjList.remove(dst);
        }

        if (dstVertexAdjList != null && dstVertexAdjList.size() > 0) {
            dstVertexAdjList.remove(src);
        }
    }

    public List<GraphVertex> getAdjacentVertices(final String label) {
        final GraphVertex vertex = new GraphVertex(label);
        return adjVertices.get(vertex);
    }

    public UndirectedGraphStructure createUnDirectedGraph() {
        UndirectedGraphStructure graph = new UndirectedGraphStructure();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        return graph;
    }
}
