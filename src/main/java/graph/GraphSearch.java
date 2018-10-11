package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public final class GraphSearch {
    private static final List<Edge> alreadySearched = new ArrayList<>();
    private static final ArrayDeque<Vertex> searchQueue = new ArrayDeque<>();
    private static final List<Vertex> result = new ArrayList<>();

    public static void bFS(Graph graph, Vertex startingPoint) {
        clearCollections();

        if (!graph.containsVertex(startingPoint)) {
            System.out.println("Wrong Vertex");
            return;
        }

        searchQueue.offer(graph.getVertex(startingPoint.getLabel()));
        while (searchQueue.size() != 0) {
            bfsSingleSearch();
        }
    }

    private static void bfsSingleSearch() {
        Vertex currentVertex = searchQueue.poll();

        for (int i = 0; i < currentVertex.getNeighbourhoodSize(); i++) {
            Edge currentEdge = currentVertex.getNeighbour(i);
            if (!isAlreadySearched(currentEdge)) {
                if (!isNeighbourSearched(currentEdge, currentVertex)) {
                    searchQueue.offer(currentEdge.getNeighbour(currentVertex));
                    alreadySearched.add(currentEdge);
                }
            }
        }
        result.add(currentVertex);
    }

    public static void dFS(Graph graph, Vertex startingPoint) {
        clearCollections();

        if (!graph.containsVertex(startingPoint)) {
            System.out.println("Wrong Vertex");
            return;
        }

        searchQueue.offer(graph.getVertex(startingPoint.getLabel()));
        while (searchQueue.size() != 0) {
            dfsSingleSearch();
        }
    }

    private static void dfsSingleSearch(){
        result.add(searchQueue.poll());
        int resultIndex = result.size()-1;
        int neighbourIndex = 0;

        Vertex currentVertex = result.get(resultIndex);
        Edge currentEdge = currentVertex.getNeighbour(neighbourIndex);
        int currentNeighbourhoodSize = currentVertex.getNeighbourhoodSize();

        while(isNeighbourSearched(currentEdge, currentVertex)){
             if(neighbourIndex < currentNeighbourhoodSize-1){
                 neighbourIndex++;
                 currentEdge = currentVertex.getNeighbour(neighbourIndex);
             } else if (resultIndex > 0) {
                 resultIndex--;
                 neighbourIndex = 0;
                 currentVertex = result.get(resultIndex);
                 currentEdge = currentVertex.getNeighbour(neighbourIndex);
                 currentNeighbourhoodSize = currentVertex.getNeighbourhoodSize();
             } else break;
        }

        if(!isNeighbourSearched(currentEdge, currentVertex)){
            searchQueue.offer(currentEdge.getNeighbour(currentVertex));
        }
    }

    private static boolean isAlreadySearched(Edge edge) {
        return alreadySearched.contains(edge);
    }

    private static boolean isNeighbourSearched(Edge edge, Vertex vertex) {
        return (isNeighbourInQueue(edge, vertex) || isNeighbourInResult(edge, vertex));
    }

    private static boolean isNeighbourInQueue(Edge edge, Vertex vertex) {
        return searchQueue.contains(edge.getNeighbour(vertex));
    }

    private static boolean isNeighbourInResult(Edge edge, Vertex vertex) {
        return result.contains(edge.getNeighbour(vertex));
    }

    private static void clearCollections() {
        alreadySearched.clear();
        searchQueue.clear();
        result.clear();
    }

    public static List<Edge> getAlreadySearched() {
        return new ArrayList<>(alreadySearched);
    }

    public static List<Vertex> getResult() {
        return result;
    }

    public static ArrayDeque<Vertex> getSearchQueue() {
        return searchQueue;
    }
}
