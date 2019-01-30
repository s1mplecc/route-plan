package com.caacetc.hackathon.routeplan.dijkstra;

public class Run {
    public static double minLength(String start, String end) {
        String[] verticx = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};//顶点的集合
        //边的集合
        Edge edge1 = new Edge("1", "2", 1);
        Edge edge2 = new Edge("1", "5", 1);
        Edge edge3 = new Edge("2", "3", 2);
        Edge edge4 = new Edge("2", "6", 2);
        Edge edge5 = new Edge("3", "4", 1);
        Edge edge6 = new Edge("3", "8", 2);
        Edge edge7 = new Edge("4", "15", 3);
        Edge edge8 = new Edge("5", "6", 1);
        Edge edge9 = new Edge("5", "9", 1);
        Edge edge10 = new Edge("6", "7", 1);
        Edge edge11 = new Edge("7", "8", 1);
        Edge edge12 = new Edge("7", "10", 1);
        Edge edge13 = new Edge("8", "11", 1);
        Edge edge14 = new Edge("9", "10", 3);
        Edge edge15 = new Edge("9", "12", 2);
        Edge edge16 = new Edge("10", "11", 1);
        Edge edge17 = new Edge("10", "13", 2);
        Edge edge18 = new Edge("11", "14", 1);
        Edge edge19 = new Edge("12", "13", 2);
        Edge edge20 = new Edge("13", "14", 1);
        Edge edge21 = new Edge("14", "15", 1);

        Edge[] edge = {edge1, edge2, edge3, edge4, edge5, edge6, edge7, edge8, edge9, edge10, edge11, edge12, edge13, edge14, edge15, edge16, edge17, edge18, edge19, edge20
                , edge21};
        Dijkstra dij = new Dijkstra();
        System.out.println("由起点" + start + "到终点" + end + "的最短路径为：");
        Graph graph = new Graph(verticx, edge);
        return dij.getMinLength(graph, start, end);
    }
}
