package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex {
    private List<Edge> neighbourhood;
    private String label;

    public Vertex(String label) {
        this.label = label;
        this.neighbourhood = new ArrayList<>();
    }

    public void addNeighbour(Edge edge){
        if(containsNeighbour(edge)){
            return;
        }
        this.neighbourhood.add(edge);
    }

    public boolean containsNeighbour(Edge edge){
        return this.neighbourhood.contains(edge);
    }

    public Edge getNeighbour(int index){
        return this.neighbourhood.get(index);
    }

    Edge removeNeighbour(int index){
        return this.neighbourhood.remove(index);
    }

    public void removeNeighbour(Edge edge){
        this.neighbourhood.remove(edge);
    }

    public int getNeighbourhoodSize(){
        return this.neighbourhood.size();
    }

    public String getLabel(){
        return this.label;
    }

    @Override
    public String toString(){
        return "Vertex " + this.label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
