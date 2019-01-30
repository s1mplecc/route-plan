package com.caacetc.hackathon.routeplan.dijkstra;

class Edge {
    String first;
    String second;
    double weight;

    Edge(String first, String second, double weight) {
        this.first = first;
        this.second = second;
        this.weight = weight;
    }
}
