package com.graphs;
import java.util.*;

public class GraphTraversal {

    public static Set<GraphVertex> depthFirstTraversal(final UndirectedGraphStructure graph, final GraphVertex rootVertex) {
        final Stack<GraphVertex> nodeStack = new Stack<>();
        final Set<GraphVertex> visited = new LinkedHashSet<>();
        Map<GraphVertex, List<GraphVertex>> masterAdjData =  graph.getGraphFullAdjData();
        if (masterAdjData.containsKey(rootVertex)) {
            nodeStack.push (rootVertex);
            while (!nodeStack.isEmpty()) {
                GraphVertex vertex = nodeStack.pop();
                if (!visited.contains(vertex)) {
                    visited.add(vertex);
                    for (GraphVertex v : graph.getAdjacentVertices(vertex.getLabel())) {
                        nodeStack.push(v);
                    }
                }
            }
        }
        return visited;
    }

    public static Set<GraphVertex> breadthFirstTraversal(final UndirectedGraphStructure graph, final GraphVertex rootVertex) {
        final Queue<GraphVertex> nodeQueue = new LinkedList<>();
        final Set<GraphVertex> visited = new LinkedHashSet<>();
        Map<GraphVertex, List<GraphVertex>> masterAdjData =  graph.getGraphFullAdjData();
        if (masterAdjData.containsKey(rootVertex)) {
            nodeQueue.add(rootVertex);
            visited.add(rootVertex);
            while (!nodeQueue.isEmpty()) {
                GraphVertex vertex = nodeQueue.poll();
                for (GraphVertex vert : graph.getAdjacentVertices(vertex.getLabel())) {
                    if (!visited.contains(vert)) {
                        visited.add(vert);
                        nodeQueue.add(vert);
                    }
                }
            }
        }
        return  visited;
    }
    
    public static void main(String args[]) {
        UndirectedGraphStructure graph = new UndirectedGraphStructure();
        UndirectedGraphStructure graph_data = graph.createUnDirectedGraph();

        final GraphVertex rootVertex = graph.getVertex("Delhi");
        Set<GraphVertex> dfsTraversal = depthFirstTraversal(graph_data, rootVertex);
        System.out.println("Depth First Traversal is as: " + dfsTraversal);

        Set<GraphVertex> bfsTraversal = breadthFirstTraversal(graph_data, rootVertex);
        System.out.println("Breadth First Traversal is as: " + bfsTraversal);
    }
}
