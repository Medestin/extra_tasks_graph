package graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraphTestSuite {
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
    public void testDuplicateEdges() {
        Vertex vertexOne;
        Vertex vertexTwo;
        for (int i = 0; i < 4; i++) {
            vertexOne = graph.getVertex(String.valueOf(i));
            vertexTwo = graph.getVertex(String.valueOf(i + 1));
            graph.addEdge(vertexOne, vertexTwo);
            graph.addEdge(vertexTwo, vertexOne);
        }
        Assert.assertEquals(4, graph.getEdges().size());
    }
}
