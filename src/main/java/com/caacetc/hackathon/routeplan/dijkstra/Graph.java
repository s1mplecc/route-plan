package com.caacetc.hackathon.routeplan.dijkstra;

import java.util.ArrayList;
import java.util.List;

class Graph {
    List<Node> node = new ArrayList<>();
    Edge[] edge;

    Graph(String[] strings, Edge[] edge) {
        for (String s : strings) {
            Node v = new Node(s);
            node.add(v);
        }
        this.edge = edge;
    }
}
