package com.caacetc.hackathon.routeplan;

import static com.caacetc.hackathon.routeplan.Graph.INFINITY;

public class Dijkstra {
    private int[][] e;

    public Dijkstra(Graph graph) {
        this.e = graph.matrix();
    }

    public int min(int start, int end) {
        //初始化dis数组，这里是1号顶点到其余各个顶点的初始路程
        int n = e[0].length;
        int[] dis = new int[n];
        int[] book = new int[n];
        System.arraycopy(e[start - 1], 0, dis, 0, n);
        //book数组初始化
        for (int i = 0; i < n; i++) {
            book[i] = 0;
        }
        book[0] = 1;

        for (int i = 0; i < n - 1; i++) {
            //找到离1号顶点最近的顶点
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

//        System.out.println(String.format("from %d to %d distance %d", start, end, dis[end - 1]));

        return dis[end - 1];
    }

}
