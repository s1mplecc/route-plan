package com.caacetc.hackathon.routeplan.dijkstra;

import java.util.ArrayList;

public class Graph {
    ArrayList<Node> node = new ArrayList();
    Edge[] edge;

    Graph(String[] arrary, Edge[] edge) {
        for (String s : arrary) {
            Node v = new Node(s);
            node.add(v);
        }
        this.edge = edge;
    }
}
