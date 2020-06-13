package com.nirvana.learning.interview.graph;

import java.util.*;

/**
 * Date 10/01/2018
 *
 * @author Krishna Verma
 * <p>
 * Given a directed graph, find all strongly connected components in this graph.
 * We are going to use Kosaraju's algorithm to find strongly connected component.
 * <p>
 * Algorithm
 * Create a order of vertices by finish time in decreasing order.
 * Reverse the graph
 * Do a DFS on reverse graph by finish time of vertex and created strongly connected
 * components.
 * <p>
 * Runtime complexity - O(V + E)
 * Space complexity - O(V)
 * <p>
 * References
 * https://en.wikipedia.org/wiki/Strongly_connected_component
 * http://www.geeksforgeeks.org/strongly-connected-components/
 */
public class StronglyConnectedComponent {

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 3);
        graph.addEdge(5, 6);

        StronglyConnectedComponent scc = new StronglyConnectedComponent();
        List<Set<Vertex<Integer>>> result = scc.scc(graph);

        //print the result
        result.forEach(set -> {
            set.forEach(v -> System.out.print(v.getId() + " "));
            System.out.println();
        });
    }

    public List<Set<Vertex<Integer>>> scc(Graph<Integer> graph) {

        //it holds vertices by finish time in reverse order.
        Deque<Vertex<Integer>> stack = new ArrayDeque<>();
        //holds visited vertices for DFS.
        Set<Vertex<Integer>> visited = new HashSet<>();

        //populate stack with vertices with vertex finishing last at the top.
        for (Vertex<Integer> vertex : graph.getAllVertex()) {
            if (visited.contains(vertex)) {
                continue;
            }
            DFSUtil(vertex, visited, stack);
        }

        //reverse the graph.
        Graph<Integer> reverseGraph = reverseGraph(graph);

        //Do a DFS based off vertex finish time in decreasing order on reverse graph..
        visited.clear();
        List<Set<Vertex<Integer>>> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            Vertex<Integer> vertex = reverseGraph.getVertex(stack.poll().getId());
            if (visited.contains(vertex)) {
                continue;
            }
            Set<Vertex<Integer>> set = new HashSet<>();
            DFSUtilForReverseGraph(vertex, visited, set);
            result.add(set);
        }
        return result;
    }

    private Graph<Integer> reverseGraph(Graph<Integer> graph) {
        Graph<Integer> reverseGraph = new Graph<>(true);
        for (Edge<Integer> edge : graph.getAllEdges()) {
            reverseGraph.addEdge(edge.getVertex2().getId(), edge.getVertex1()
                    .getId(), edge.getWeight());
        }
        return reverseGraph;
    }

    private void DFSUtil(Vertex<Integer> vertex,
                         Set<Vertex<Integer>> visited, Deque<Vertex<Integer>> stack) {
        visited.add(vertex);
        for (Vertex<Integer> v : vertex.getAdjacentVertexes()) {
            if (visited.contains(v)) {
                continue;
            }
            DFSUtil(v, visited, stack);
        }
        stack.offerFirst(vertex);
    }

    private void DFSUtilForReverseGraph(Vertex<Integer> vertex,
                                        Set<Vertex<Integer>> visited, Set<Vertex<Integer>> set) {
        visited.add(vertex);
        set.add(vertex);
        for (Vertex<Integer> v : vertex.getAdjacentVertexes()) {
            if (visited.contains(v)) {
                continue;
            }
            DFSUtilForReverseGraph(v, visited, set);
        }
    }
}
