package com.caacetc.hackathon.routeplan;

public class Graph {
    private static final int I = Integer.MAX_VALUE;
    public static final int INFINITY = I;

    // todo: maybe read from graph with python
    public int[][] matrix() {
        return new int[][]{
//               1  2  3  4  5  6  7  8  9  10 11 12 13 14 15
                {0, 1, I, I, 1, I, I, I, I, I, I, I, I, I, I}, // 1
                {1, 0, 2, I, I, 2, I, I, I, I, I, I, I, I, I}, // 2
                {I, 2, 0, 1, I, I, I, 2, I, I, I, I, I, I, I}, // 3
                {I, I, 1, 0, I, I, I, I, I, I, I, I, I, I, 3}, // 4
                {1, I, I, I, 0, 1, I, I, 1, I, I, I, I, I, I}, // 5
                {I, 2, I, I, 1, 0, 1, I, I, I, I, I, I, I, I}, // 6
                {I, I, I, I, I, 1, 0, 1, I, 1, I, I, I, I, I}, // 7
                {I, I, 2, I, I, I, 1, 0, I, I, 1, I, I, I, I}, // 8
                {I, I, I, I, 1, I, I, I, 0, 3, I, 2, I, I, I}, // 9
                {I, I, I, I, I, I, 1, I, 3, 0, 1, I, 2, I, I}, // 10
                {I, I, I, I, I, I, I, 1, I, 1, 0, I, I, 1, I}, // 11
                {I, I, I, I, I, I, I, I, 2, I, I, 0, 2, I, I}, // 12
                {I, I, I, I, I, I, I, I, I, 2, I, 2, 0, 1, I}, // 13
                {I, I, I, I, I, I, I, I, I, I, 1, I, 1, 0, 1}, // 14
                {I, I, I, 3, I, I, I, I, I, I, I, I, I, 1, 0}, // 15
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= matrix()[0].length; i++) {
            sb.append(String.format("|%3s", i));
        }
        sb.append("\n");
        for (int[] ints : matrix()) {
            for (int i : ints) {
                sb.append("| ");
                if (i == Integer.MAX_VALUE) {
                    sb.append("∞").append("\t");
                } else {
                    sb.append(i).append("\t");
                }
            }
            sb.append("|").append("\n");
        }
        return sb.toString();
    }
}
