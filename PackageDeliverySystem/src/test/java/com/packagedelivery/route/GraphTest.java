package com.packagedelivery.route;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * In class GraphTest we test if route 2 is shorter then route 1.
 * The result must be the one that we are waiting
 */
public class GraphTest {
    private static final Graph.Edge[] GRAPH = {

            //Route 1
            new Graph.Edge("Cluj", "Campia Turzii", 40),
            new Graph.Edge("Campia Turzii", "Sebes", 89),
            new Graph.Edge("Sebes", "Sibiu", 60),
            new Graph.Edge("Sibiu", "Brasov", 142),
            new Graph.Edge("Brasov", "Ploiesti", 108),
            new Graph.Edge("Ploiesti", "Bucuresti", 60),

            //Route 2
            new Graph.Edge("Campia Turzii", "Targu Mures", 68),
            new Graph.Edge("Targu Mures", "Sighisoara", 53),
            new Graph.Edge("Sighisoara", "Brasov", 118),
    };

    Graph graph;
    
    @Before
    public void setUp() throws Exception {
        graph = new Graph(GRAPH);
    }

    @Test
    public void getRoute() {
        String route = graph.getRoute("Cluj", "Bucuresti");
        assertEquals("Cluj -> Campia Turzii(40) -> Targu Mures(108) -> Sighisoara(161) -> Brasov(279) -> Ploiesti(387) -> Bucuresti(447)", route);
    }

}