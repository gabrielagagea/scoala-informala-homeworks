package com.packagedelivery.route;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Implementing Dijkstra's alghoritm to Calculate route and distance between a source and destination.
 */
public class ShortestRoute {

    static class Edge {
        private String source;
        private String destination;
        private int distance;

        public Edge(String source, String destination, int distance) {
            this.source = source;
            this.destination = destination;
            this.distance = distance;
        }

        public String getSource() {
            return source;
        }

        public String getDestination() {
            return destination;
        }

        public int getDistance() {
            return distance;
        }
    }

    static class Route {

        List<Edge> edges = new LinkedList<>();

        public Route(List<Edge> edges) {
            this.edges = edges;
        }

        public List<Edge> getEdges() {
            return edges;
        }

        private int getDistance() {
            int distance = 0;
            for (Edge edge : edges) {
                distance = distance + edge.getDistance();
            }
            return distance;
        }
    }

    private Set<String> nodes;
    private Set<Edge> edges;
    private Set<Route> routes = new HashSet<>();

    private Route getBestRoute() {
        Route bestRoute = routes.iterator().next();
        for (Route route : routes) {
            if (bestRoute.getDistance() > route.getDistance()) {
                bestRoute = route;
            }
        }
        return bestRoute;
    }

    public void setNodes(Set<String> nodes) {
        this.nodes = nodes;
    }

    public void setEdges(Set<Edge> edges) {
        this.edges = edges;
    }

    public List<String> getShortestRoute(String start, String destination) {
        navigate(start, destination);
        Route route = getBestRoute();
        List<Edge> routeEdges = route.getEdges();
        List<String> shortestRoute = new LinkedList<>();

        for(Edge edge:routeEdges) {
            shortestRoute.add(edge.getSource());
        }
        shortestRoute.add(destination);
        return shortestRoute;
    }

    private Set<String> getNeighbours(String node) {
        Set<String> neighbours = new HashSet<>();
        for (Edge edge : edges) {
            if (node.equals(edge.getSource())) {
                neighbours.add(edge.getDestination());
            }
        }
        return neighbours;
    }

    private Edge getEdgesBySourceAndDestination(String source, String destination) {
        for(Edge edge:edges) {
            if(source.equals(edge.getSource()) && destination.equals(edge.getDestination())) {
                return edge;
            }
        }
        return null;
    }
    private void navigate(String node, String destination) {
        if(node.equals(destination)) {
            return;
        }
        Set<String> neighbours = getNeighbours(node);
        Route route = getRouteByDestination(node);
        List<Edge> routeEdges = new LinkedList<>();
        if(route != null) {
            routeEdges = route.getEdges();
        }
        for (String neighbour : neighbours) {
            Edge newEdge = getEdgesBySourceAndDestination(node, neighbour);
            List<Edge> newEdges = new LinkedList<>(routeEdges);
            newEdges.add(newEdge);
            Route newRoute = new Route(newEdges);
            routes.add(newRoute);
        }
        if (route != null) {
            routes.remove(route);
        }
        Route bestRoute = getBestRoute();
        String bestNode = getRouteDestination(bestRoute);
        navigate(bestNode, destination);
    }

    /**
     * Gets the destination node of a {@link Route}.
     * @param route - the {@link Route} to get the destination node for
     * @return the destination node of the {@link Route} given as parameter
     */
    private String getRouteDestination(Route route) {
        List<Edge> routeEdges = route.getEdges();
        Edge latestEdge = routeEdges.get(routeEdges.size()-1);
        return latestEdge.getDestination();
    }

    /**
     * Gets the {@link Route} by its destination.
     * @param nodeDestination - the destination of the {@link Route} to by obtained
     * @return the {@link Route} related to the destination node given as parameter
     */
    private Route getRouteByDestination(String nodeDestination) {
        for(Route route:routes) {
            List<Edge> routeEdges = route.getEdges();
            if(nodeDestination.equals(routeEdges.get(routeEdges.size()-1).getDestination())){
                return route;
            }
        }
        return null;
    }
}
