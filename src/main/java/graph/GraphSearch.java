package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public final class GraphSearch {
    private static final List<Edge> alreadySearched = new ArrayList<>();
    private static final ArrayDeque<Vertex> searchQueue = new ArrayDeque<>();

    public static void bFS(Graph graph, Vertex startingPoint) {
        alreadySearched.clear();
        searchQueue.clear();
        if (!graph.containsVertex(startingPoint)) {
            System.out.println("Wrong Vertex");
            return;
        }

        searchQueue.offer(graph.getVertex(startingPoint.getLabel()));
        Vertex currentVertex;
        while(!searchQueue.isEmpty()){
            currentVertex = searchQueue.pollFirst();
            searchEdges(currentVertex);
        }
    }

    public static void dFS(Graph graph, Vertex startingPoint) {
        alreadySearched.clear();
        searchQueue.clear();
        if (!graph.containsVertex(startingPoint)) {
            System.out.println("Wrong Vertex");
            return;
        }

        searchQueue.offer(graph.getVertex(startingPoint.getLabel()));
        Vertex currentVertex;
        while(!searchQueue.isEmpty()){
            currentVertex = searchQueue.pollLast();
            searchEdges(currentVertex);
        }
    }

    private static void searchEdges(Vertex currentVertex) {
        for (int i = 0; i < currentVertex.getNeighbourhoodSize(); i++) {
            Edge currentEdge = currentVertex.getNeighbour(i);
            if (!alreadySearched.contains(currentEdge)) {
                alreadySearched.add(currentEdge);
                searchQueue.offerLast(currentEdge.getNeighbour(currentVertex));
            }
        }
    }

    public static List<Edge> getAlreadySearched(){
        return new ArrayList<>(alreadySearched);
    }

}
