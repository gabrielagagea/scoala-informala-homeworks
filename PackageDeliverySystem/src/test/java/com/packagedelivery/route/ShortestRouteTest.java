package com.packagedelivery.route;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for {@link ShortestRoute}.
 * Setup:
 * - start: Cluj
 * - destination: Bucuresti
 * - 2 routes
 */
public class ShortestRouteTest {

   ShortestRoute shortestRoute;

    @Before
    public void setUp() throws Exception {
        shortestRoute = new ShortestRoute();
        Set<String> nodes = new HashSet<>();
        nodes.add("Cluj");
        nodes.add("Bucuresti");
        nodes.add("Turda");
        nodes.add("Campia Turzii");
        nodes.add("Sebes");
        nodes.add("Sibiu");
        nodes.add("Brasov");
        nodes.add("Sighisoara");
        nodes.add("Ploiesti");
        nodes.add("Targu Mures");

        shortestRoute.setNodes(nodes);
        Set<ShortestRoute.Edge> edges = new HashSet<>();
        //Route 1
        edges.add(new ShortestRoute.Edge("Cluj", "Campia Turzii", 40));
        edges.add(new ShortestRoute.Edge("Campia Turzii", "Sebes", 89));
        edges.add(new ShortestRoute.Edge("Sebes", "Sibiu", 60));
        edges.add(new ShortestRoute.Edge("Sibiu", "Brasov", 142));
        edges.add(new ShortestRoute.Edge("Brasov", "Ploiesti", 108));
        edges.add(new ShortestRoute.Edge("Ploiesti", "Bucuresti", 60));

        //Route 2
        edges.add(new ShortestRoute.Edge("Campia Turzii", "Targu Mures", 68));
        edges.add(new ShortestRoute.Edge("Targu Mures", "Sighisoara", 53));
        edges.add(new ShortestRoute.Edge("Sighisoara", "Brasov", 118));
        /* Let us create the example graph discussed above */
      shortestRoute.setEdges(edges);
    }

    @Test
    public void getShortestRoute() {
        List<String> route = shortestRoute.getShortestRoute("Cluj", "Bucuresti");
        List<String> expectedRoute = new LinkedList<>();
        expectedRoute.add("Cluj");
        expectedRoute.add("Campia Turzii");
        expectedRoute.add("Targu Mures");
        expectedRoute.add("Sighisoara");
        expectedRoute.add("Brasov");
        expectedRoute.add("Ploiesti");
        expectedRoute.add("Bucuresti");
        assertEquals(expectedRoute, route);
    }

}
