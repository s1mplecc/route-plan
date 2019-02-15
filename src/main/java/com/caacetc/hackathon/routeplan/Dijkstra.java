package com.caacetc.hackathon.routeplan;

import static com.caacetc.hackathon.routeplan.Graph.INFINITY;

public class Dijkstra {
    private final int[][] e;

    public Dijkstra(Graph graph) {
        this.e = graph.matrix();
    }

    public int min(int start, int end) {
        int n = e[0].length;

        // init dis[]
        int[] dis = new int[n];
        System.arraycopy(e[start - 1], 0, dis, 0, n);

        // init book[]
        int[] book = new int[n];
        book[0] = 1;

        for (int i = 0; i < n - 1; i++) {
            int min = INFINITY;
            int u = 0;
            for (int j = 0; j < n; j++) {
                if (book[j] == 0 && dis[j] < min) {
                    min = dis[j];
                    u = j;
                }
            }
            book[u] = 1;
            for (int v = 0; v < n; v++) {
                if (e[u][v] < INFINITY) {
                    if (dis[v] > dis[u] + e[u][v]) {
                        dis[v] = dis[u] + e[u][v];
                    }
                }
            }
        }

        return dis[end - 1];
    }
}
