package graph;

import java.util.Objects;

public class Edge implements Comparable<Edge> {
    private Vertex vertexOne, vertexTwo;
    private int weight;

    public Edge(Vertex v1, Vertex v2) {
        this.vertexOne = v1;
        this.vertexTwo = v2;
        this.weight = 1;
    }

    public Edge(Vertex v1, Vertex v2, int weight) {
        this.vertexOne = (v1.getLabel().compareTo(v2.getLabel()) <= 0) ? v1 : v2;
        this.vertexTwo = (this.vertexOne == v1) ? v2 : v1;
        this.weight = weight;
    }

    public Vertex getNeighbour(Vertex vertex) {
        if (!(vertexOne.equals(vertex) || vertexTwo.equals(vertex))) {
            return null;
        }
        return (vertexOne.equals(vertex)) ? vertexTwo : vertexOne;
    }

    public Vertex getVertexOne() {
        return vertexOne;
    }

    public Vertex getVertexTwo() {
        return vertexTwo;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Note: this class has a natural ordering that is inconsistent with equals.
     * Just because edgeOne.compareTo(edgeTwo) == 0 does not mean edgeOne.equals(edgeTwo)
     */
    @Override
    public int compareTo(Edge comparedEdge) {
        return this.weight - comparedEdge.weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return weight == edge.weight &&
                Objects.equals(vertexOne, edge.vertexOne) &&
                Objects.equals(vertexTwo, edge.vertexTwo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertexOne, vertexTwo, weight);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v1: " + vertexOne +
                ", v2: " + vertexTwo +
                ", w: " + weight +
                '}';
    }
}