package graph;

import org.junit.*;

public class SearchTestSuite {
    Graph graph = new Graph();

    @Before
    public void addSomeVerticesAndEdges() {
        int numberOfVertices = 10;
        for (int i = 0; i < numberOfVertices; i++) {
            graph.addVertex(new Vertex("" + i), true);
        }
        Vertex vertexOne;
        Vertex vertexTwo;
        for (int i = 0; i < numberOfVertices-1; i++) {
            vertexOne = graph.getVertex(String.valueOf(i));
            vertexTwo = graph.getVertex(String.valueOf(i + 1));
            graph.addEdge(vertexOne, vertexTwo);
        }

        int v1 = 0, v2 = 2;
        for(int i = 0; i < numberOfVertices - 2; i++){
            vertexOne = graph.getVertex(String.valueOf(v1));
            vertexTwo = graph.getVertex(String.valueOf(v2));
            graph.addEdge(vertexOne, vertexTwo);
        }
    }

    @After
    public void afterTest(){
        System.out.println();
    }

    @Test
    public void testBfs(){
        GraphSearch.bFS(graph, new Vertex(String.valueOf(0)));
        System.out.println(GraphSearch.getAlreadySearched());
        Assert.assertEquals(graph.getEdges().size(), GraphSearch.getAlreadySearched().size());
    }

    @Test
    public void testDfs(){
        GraphSearch.dFS(graph, new Vertex(String.valueOf(0)));
        System.out.println(GraphSearch.getAlreadySearched());
        Assert.assertEquals(graph.getEdges().size(), GraphSearch.getAlreadySearched().size());
    }

}
