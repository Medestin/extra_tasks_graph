package graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BfsTestSuite {
    Graph graph = new Graph();

    @Before
    public void addSomeVerticesAndEdges() {
        for (int i = 0; i < 5; i++) {
            graph.addVertex(new Vertex("" + i), true);
        }
        Vertex vertexOne;
        Vertex vertexTwo;
        for (int i = 0; i < 4; i++) {
            vertexOne = graph.getVertex(String.valueOf(i));
            vertexTwo = graph.getVertex(String.valueOf(i + 1));
            graph.addEdge(vertexOne, vertexTwo);
        }
    }

    @Test
    public void testBfs(){
        BreadthFirstSearch.bFS(graph, new Vertex(String.valueOf(1)));
        System.out.println(BreadthFirstSearch.getAlreadySearched());
        System.out.println(graph.getEdges());
        Assert.assertEquals(graph.getEdges().size(), BreadthFirstSearch.getAlreadySearched().size());
    }
}
