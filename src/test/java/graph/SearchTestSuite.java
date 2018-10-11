package graph;

import org.junit.*;

public class SearchTestSuite {
    Graph graph = new Graph();

    @Before
    public void addSomeVerticesAndEdges() {
        Vertex v0 = new Vertex("0");
        Vertex v11 = new Vertex("11");
        Vertex v12 = new Vertex("12");
        Vertex v13 = new Vertex("13");
        Vertex v21 = new Vertex("21");
        Vertex v22 = new Vertex("22");
        Vertex v23 = new Vertex("23");
        Vertex v24 = new Vertex("24");
        Vertex v25 = new Vertex("25");
        Vertex v26 = new Vertex("26");

        graph.addVertex(v0, true);
        graph.addVertex(v11, true);
        graph.addVertex(v12, true);
        graph.addVertex(v13, true);
        graph.addVertex(v21, true);
        graph.addVertex(v22, true);
        graph.addVertex(v23, true);
        graph.addVertex(v24, true);
        graph.addVertex(v25, true);
        graph.addVertex(v26, true);

        graph.addEdge(v0, v11);
        graph.addEdge(v0, v12);
        graph.addEdge(v0, v13);

        graph.addEdge(v11, v21);
        graph.addEdge(v11, v22);
        graph.addEdge(v12, v23);
        graph.addEdge(v12, v24);
        graph.addEdge(v13, v25);
        graph.addEdge(v13, v26);

        graph.addEdge(v21, v23);
        graph.addEdge(v21, v26);
        graph.addEdge(v22, v24);
        graph.addEdge(v22, v25);
        graph.addEdge(v23, v25);
        graph.addEdge(v24, v26);
    }

    @After
    public void afterTest() {
        System.out.println();
    }

    @Test
    public void testBfs() {
        GraphSearch.bFS(graph, new Vertex("0"));
        System.out.println(GraphSearch.getResult());
        Assert.assertEquals(graph.vertexKeys().size(), GraphSearch.getResult().size());
    }

    @Test
    public void testDfs() {
        GraphSearch.dFS(graph, new Vertex("0"));
        System.out.println(GraphSearch.getResult());
        Assert.assertEquals(graph.vertexKeys().size(), GraphSearch.getResult().size());
    }
}
