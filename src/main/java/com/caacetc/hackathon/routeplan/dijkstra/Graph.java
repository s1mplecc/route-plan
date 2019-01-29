package com.caacetc.hackathon.routeplan.dijkstra;

import java.util.ArrayList;

public class Graph {
    ArrayList<Node> node = new ArrayList<>();
    Edge[] edge;

    Graph(int[] array, Edge[] edge) {
        for (int s : array) {
            Node v = new Node(s);
            node.add(v);
        }
        this.edge = edge;
    }
}
