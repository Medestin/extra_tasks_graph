package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex {
    private List<Edge> neigbourhood;
    private String label;

    public Vertex(String label) {
        this.label = label;
        this.neigbourhood = new ArrayList<>();
    }

    public void addNeighbour(Edge edge){
        if(containsNeighbour(edge)){
            return;
        }
        this.neigbourhood.add(edge);
    }

    public boolean containsNeighbour(Edge edge){
        return this.neigbourhood.contains(edge);
    }

    Edge removeNeighbour(int index){
        return this.neigbourhood.remove(index);
    }

    public void removeNeighbour(Edge edge){
        this.neigbourhood.remove(edge);
    }

    public int getNeighourhoodSize(){
        return this.neigbourhood.size();
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
