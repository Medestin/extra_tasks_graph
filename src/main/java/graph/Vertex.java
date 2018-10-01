package graph;

import java.util.ArrayList;
import java.util.List;

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
}
