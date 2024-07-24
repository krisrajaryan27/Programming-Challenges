package com.nirvana.learning.javaeight;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class MinimumCostToConnectAllPoints {
    //Input:
    //= [(0,0), (2,2), (3,10), (5,2), (7,0)]
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(2, 2));
        points.add(new Point(3, 10));
        points.add(new Point(5, 2));
        points.add(new Point(7, 0));
        System.out.println(minCostToConnectAllPoints(points));
    }

    /**
     * This function calculates the minimum cost to connect all points in a given list using Kruskal's algorithm.
     * Kruskal's algorithm is a minimum spanning tree algorithm that finds an edge of the least possible weight that connects any two trees in the forest.
     *
     * @param points A list of Point objects representing the coordinates of the points.
     * @return The minimum cost to connect all points.
     */
    public static int minCostToConnectAllPoints(List<Point> points) {
        int n = points.size();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] parent = new int[n];
        int[] rank = new int[n];

        // Calculate the weight of each edge and add it to the priority queue
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int weight = Math.abs(points.get(i).getX() - points.get(j).getX()) + Math.abs(points.get(i).getY() - points.get(j).getY());
                pq.offer(new int[]{weight, i, j});
            }
        }

        // Initialize parent and rank arrays for union-find algorithm
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int totalCost = 0;
        int edgesAdded = 0;

        // Process edges in ascending order of weight
        while (!pq.isEmpty() && edgesAdded < n - 1) {
            int[] edge = pq.poll();
            int weight = edge[0];
            int u = edge[1];
            int v = edge[2];

            // If the points are not in the same set, add the edge to the MST and update the total cost
            if (find(parent, u) != find(parent, v)) {
                union(parent, rank, u, v);
                totalCost += weight;
                edgesAdded++;
            }
        }

        return totalCost;
    }

    private static void union(int[] parent, int[] rank, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);
        if (xRoot == yRoot) {
            return;
        }
        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }

    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    @Getter
    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}

