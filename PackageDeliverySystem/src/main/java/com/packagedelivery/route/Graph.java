package com.packagedelivery.route;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;
/**
 * Implementing Dijkstra's alghoritm to Calculate route and distance between Cluj and Bucuresti
 *
 *Public class Graph where we have the vertices and the Edges. These all make a Graph.
 */
public class Graph {
    private final Map<String, Graph.Vertex> graph; // mapping of vertex names to Vertex objects, built from a set of Edges

    /**
     * One edge of the graph (only used by Graph constructor). It has a start and a destination
     */
    public static class Edge {
        final String start, destination;
        final int dist;

        public Edge(String start, String destination, int dist) {
            this.start = start;
            this.destination = destination;
            this.dist = dist;
        }
    }
    /**
     * One vertex of the graph, complete with mappings to neighbouring vertices
     */
    public static class Vertex implements Comparable<Graph.Vertex> {
        final String name;
        int dist = Integer.MAX_VALUE; // MAX_VALUE assumed to be infinity
        Graph.Vertex previous = null;
        final Map<Graph.Vertex, Integer> neighbours = new HashMap<>();

        Vertex(String name) {
            this.name = name;
        }

        private String getPath() {
            if (this == this.previous) {
                return this.name;
            } else if (this.previous == null) {
                return this.name + "(unreached)";
            } else {
                String path = this.previous.getPath();
                return path + " -> " + this.name + "(" + this.dist + ")";
            }
        }

        public int compareTo(Graph.Vertex other) {
            if (dist == other.dist)
                return name.compareTo(other.name);

            return Integer.compare(dist, other.dist);
        }

        @Override
        public String toString() {
            return "(" + name + ", " + dist + ")";
        }
    }

    /**
     * Builds a graph from a set of edges
     */
    public Graph(Graph.Edge[] edges) {
        graph = new HashMap<>(edges.length);

        //one pass to find all vertices
        for (Graph.Edge e : edges) {
            if (!graph.containsKey(e.start)) graph.put(e.start, new Graph.Vertex(e.start));
            if (!graph.containsKey(e.destination)) graph.put(e.destination, new Graph.Vertex(e.destination));
        }

        //another pass to set neighbouring vertices
        for (Graph.Edge e : edges) {
            graph.get(e.start).neighbours.put(graph.get(e.destination), e.dist);
            //graph.get(e.destination).neighbours.put(graph.get(e.start), e.dist); // also do this for an undirected graph
        }
    }

    /**
     * Runs dijkstra using a specified source vertex
     */
    public void dijkstra(String startName) {
        if (!graph.containsKey(startName)) {
            System.err.printf("Graph doesn't contain start vertex \"%s\"\n", startName);
            return;
        }
        final Graph.Vertex source = graph.get(startName);
        NavigableSet<Graph.Vertex> q = new TreeSet<>();

        // set-up vertices
        for (Graph.Vertex v : graph.values()) {
            v.previous = v == source ? source : null;
            v.dist = v == source ? 0 : Integer.MAX_VALUE;
            q.add(v);
        }

        dijkstra(q);
    }

    /**
     * Implementation of dijkstra's algorithm using a binary heap.
     */
    private void dijkstra(final NavigableSet<Graph.Vertex> q) {
        Graph.Vertex u, v;
        while (!q.isEmpty()) {

            u = q.pollFirst(); // vertex with shortest distance (first iteration will return source)
            if (u.dist == Integer.MAX_VALUE)
                break; // we can ignore u (and any other remaining vertices) since they are unreachable

            //look at distances to each neighbour
            for (Map.Entry<Graph.Vertex, Integer> a : u.neighbours.entrySet()) {
                v = a.getKey(); //the neighbour in this iteration

                final int alternateDist = u.dist + a.getValue();
                if (alternateDist < v.dist) { // shorter path to neighbour found
                    q.remove(v);
                    v.dist = alternateDist;
                    v.previous = u;
                    q.add(v);
                }
            }
        }
    }

    public String getRoute(String start, String endName) {
        dijkstra(start);
        if (!graph.containsKey(endName)) {
            return String.format("Graph doesn't contain end vertex [%s]", endName);
        }

        return graph.get(endName).getPath();
    }

}
