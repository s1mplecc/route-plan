package com.caacetc.hackathon.routeplan;

public class Dijkstra {
    public static final int I = Integer.MAX_VALUE;
    int[] dis = {};
    int[] book = {};
    int i;
    int j;
    int n;
    int u;
    int v;
    int min;

    private int e[][] = {
//           1  2  3  4  5  6  7  8  9  10 11 12 13 14 15
            {0, I, I, I, I, I, I, I, I, I, I, I, I, I, I},
            {I, 0, I, I, I, I, I, I, I, I, I, I, I, I, I},
            {I, I, 0, I, I, I, I, I, I, I, I, I, I, I, I},
            {I, I, I, 0, I, I, I, I, I, I, I, I, I, I, I},
            {I, I, I, I, 0, I, I, I, I, I, I, I, I, I, I},
            {I, I, I, I, I, 0, I, I, I, I, I, I, I, I, I},
            {I, I, I, I, I, I, 0, I, I, I, I, I, I, I, I},
            {I, I, I, I, I, I, I, 0, I, I, I, I, I, I, I},
            {I, I, I, I, I, I, I, I, 0, I, I, I, I, I, I},
            {I, I, I, I, I, I, I, I, I, 0, I, I, I, I, I},
            {I, I, I, I, I, I, I, I, I, I, 0, I, I, I, I},
            {I, I, I, I, I, I, I, I, I, I, I, 0, I, I, I},
            {I, I, I, I, I, I, I, I, I, I, I, I, 0, I, I},
            {I, I, I, I, I, I, I, I, I, I, I, I, I, 0, I},
            {I, I, I, I, I, I, I, I, I, I, I, I, I, I, 0},
    };

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (j == 0) {
                    System.out.print("{");
                }
                if (j == 14) {
                    System.out.print("I},");
                    continue;
                }
                if (i == j) {
                    System.out.print("0, ");
                } else {
                    System.out.print("I, ");
                }
            }
            System.out.println();
        }
    }

    public void min() {
        //初始化dis数组，这里是1号顶点到其余各个顶点的初始路程
        for (i = 1; i <= n; i++) {
            dis[i] = e[1][i];
        }
        //book数组初始化
        for (i = 1; i <= n; i++) {
            book[i] = 0;
        }
        book[1] = 1;

        for (i = 1; i <= n - 1; i++) {
            //找到离1号顶点最近的顶点
            min = I;
            for (j = 1; j <= n; j++) {
                if (book[j] == 0 && dis[j] < min) {
                    min = dis[j];
                    u = j;
                }
            }
            book[u] = 1;
            for (v = 1; v <= n; v++) {
                if (e[u][v] < I) {
                    if (dis[v] > dis[u] + e[u][v]) {
                        dis[v] = dis[u] + e[u][v];
                    }
                }
            }
        }
    }

}
