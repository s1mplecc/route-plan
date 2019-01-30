package com.caacetc.hackathon.routeplan.dijkstra;

public class Edge {
    public String first;
    public String second;
    public double weight;

    public Edge(String first, String second, double weight) {
        this.first = first;
        this.second = second;
        this.weight = weight;
    }
}
