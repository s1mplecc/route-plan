package com.caacetc.hackathon.routeplan;

public class Dijkstra {
    public static final int I = Integer.MAX_VALUE;
    private static int[] dis = new int[15];
    int[] book = new int[15];
    int i;
    int j;
    int n = 14;
    int u;
    int v;
    int min;

    public static void main(String[] args) {
        new Dijkstra().min();
        for (int di : dis) {
            System.out.print(di + " ");
        }
    }

    public void min() {
        int[][] e = Graph.matrix();
        //初始化dis数组，这里是1号顶点到其余各个顶点的初始路程
        for (i = 0; i <= n; i++) {
            dis[i] = e[0][i];
        }
        //book数组初始化
        for (i = 0; i <= n; i++) {
            book[i] = 0;
        }
        book[0] = 1;

        for (i = 0; i <= n - 1; i++) {
            //找到离1号顶点最近的顶点
            min = I;
            for (j = 0; j <= n; j++) {
                if (book[j] == 0 && dis[j] < min) {
                    min = dis[j];
                    u = j;
                }
            }
            book[u] = 1;
            for (v = 0; v <= n; v++) {
                if (e[u][v] < I) {
                    if (dis[v] > dis[u] + e[u][v]) {
                        dis[v] = dis[u] + e[u][v];
                    }
                }
            }
        }
    }

}
