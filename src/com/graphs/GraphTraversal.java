package com.graphs;
import java.util.*;

public class GraphTraversal {

    public static Set<GraphVertex> depthFirstTraversal(final UndirectedGraphStructure graph, final String rootLabel) {
        final Stack<GraphVertex> nodeStack = new Stack<>();
        final Set<GraphVertex> visited = new LinkedHashSet<>();
        Map<GraphVertex, List<GraphVertex>> masterAdjData =  graph.getGraphFullAdjData();
        if (masterAdjData.containsKey(new GraphVertex(rootLabel))) {
            nodeStack.push (new GraphVertex(rootLabel));
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

    public static Set<GraphVertex> breadthFirstTraversal(final UndirectedGraphStructure graph, final String rootLabel) {
        final Queue<GraphVertex> nodeQueue = new LinkedList<>();
        final Set<GraphVertex> visited = new LinkedHashSet<>();
        Map<GraphVertex, List<GraphVertex>> masterAdjData =  graph.getGraphFullAdjData();
        if (masterAdjData.containsKey(new GraphVertex(rootLabel))) {
            nodeQueue.add(new GraphVertex(rootLabel));
            visited.add(new GraphVertex(rootLabel));
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

        Set<GraphVertex> dfsTraversal = depthFirstTraversal(graph_data, "Delhi");
        System.out.println("Depth First Traversal is as: " + dfsTraversal);

        Set<GraphVertex> bfsTraversal = breadthFirstTraversal(graph_data, "Delhi");
        System.out.println("Breadth First Traversal is as: " + bfsTraversal);
    }
}
