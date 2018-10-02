package graph;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Graph {
    private Map<String, Vertex> vertices;
    private Map<Integer, Edge> edges;

    public Graph(){
        vertices = new HashMap<>();
        edges = new HashMap<>();
    }

    public Graph(List<Vertex> vertices){
        this.vertices = new HashMap<>(vertices.stream()
        .collect(Collectors.toMap(Vertex::getLabel, Function.identity())));

        this.edges = new HashMap<>();
    }

    public boolean addEdge(Vertex v1, Vertex v2){
        return addEdge(v1, v2, 1);
    }

    public boolean addEdge(Vertex vertexOne, Vertex vertexTwo, int weight){
        Edge edge = new Edge(vertexOne, vertexTwo, weight);

        boolean alreadyExists = edges.containsKey(edge.hashCode());
        boolean alreadyAdjacent = (vertexOne.containsNeighbour(edge) || vertexTwo.containsNeighbour(edge));
        if(alreadyExists || alreadyAdjacent || vertexOne.equals(vertexTwo)){
            return false;
        }

        edges.put(edge.hashCode(), edge);
        vertexOne.addNeighbour(edge);
        vertexTwo.addNeighbour(edge);
        return true;
    }

    public boolean containsEdge(Edge edge){
        if(edge.getVertexOne() == null || edge.getVertexTwo() == null){
            return false;
        }
        return edges.containsKey(edge.hashCode());
    }

    public Edge removeEdge(Edge edge){
        edge.getVertexOne().removeNeighbour(edge);
        edge.getVertexTwo().removeNeighbour(edge);
        return edges.remove(edge.hashCode());
    }

    public boolean containsVertex(Vertex vertex){
        return vertices.get(vertex.getLabel()) != null;
    }

    public Vertex getVertex(String label){
        return vertices.get(label);
    }

    public boolean addVertex(Vertex vertex, boolean overwriteExisting){
        Vertex current = vertices.get(vertex.getLabel());
        if(current != null){
            if(!overwriteExisting){
                return false;
            }

            while (current.getNeighbourhoodSize() > 0){
                this.removeEdge(current.getNeighbour(0));
            }
        }
        vertices.put(vertex.getLabel(), vertex);
        return true;
    }

    public Vertex removeVertex(String label){
        Vertex removedVertex = vertices.remove(label);

        while(removedVertex.getNeighbourhoodSize() > 0){
            this.removeEdge(removedVertex.getNeighbour(0));
        }
        return removedVertex;
    }

    public Set<String> vertexKeys(){
        return this.vertices.keySet();
    }

    public Set<Edge> getEdges(){
        return new HashSet<>(this.edges.values());
    }
}
