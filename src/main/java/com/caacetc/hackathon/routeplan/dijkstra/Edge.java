package com.caacetc.hackathon.routeplan.dijkstra;

public class Edge {
    public int first;
    public int second;
    public int weight;

    public Edge(int first, int second, int weight) {
        this.first = first;
        this.second = second;
        this.weight = weight;
    }
}
