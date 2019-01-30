package com.caacetc.hackathon.routeplan.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Dijkstra {
    /**
     * 存储每个点的最短距离经过的点以及当前到该点的最短距离
     */
    private HashMap<String, StorageFrontPointAndNowSumWeight> path = new HashMap<>();

    double getMinDistance(Graph graph, String start, String end) {
        initSourceToOtherMinDistance(graph, start);
        Node node = sourceToOtherDistance(graph, start);
        //更新从源点出发到其他点的最短距离
        while (node != null && !node.id.equals(end)) {
            StorageFrontPointAndNowSumWeight info = path.get(node.id);
            double tempWeight = info.weight;
            for (Node v : graph.node) {
                if (!(v.id.equals(start) || v.id.equals(node.id) || v.treat)) {
                    info = path.get(v.id);
                    if (tempWeight + getBetweenAnyTwoPointWeight(node.id, v.id, graph) < info.weight) {
                        info.weight = tempWeight + getBetweenAnyTwoPointWeight(node.id, v.id, graph);
                        info.list.clear();
                        info.list.addAll(path.get(node.id).list);
                        info.list.add(node.id);
                        path.put(v.id, info);
                    }
                }
            }
            node = sourceToOtherDistance(graph, start);//循环找到从源点到其他点最短距离的点
        }
        return path.get(end).weight;
    }

    /**
     * 初始化从源点到其他点的最短距离
     */
    private void initSourceToOtherMinDistance(Graph graph, String start) {
        List<Node> node = graph.node;
        for (Node v : node) {
            if (!v.id.equals(start)) {
                double weight = getBetweenAnyTwoPointWeight(start, v.id, graph);
                List<String> list = new ArrayList<>();
                list.add(start);
                StorageFrontPointAndNowSumWeight info = new StorageFrontPointAndNowSumWeight(v, list, weight);
                path.put(v.id, info);
            }
        }

    }

    /**
     * 返回此时从源点到其他点的最短距离
     */
    private Node sourceToOtherDistance(Graph graph, String start) {
        double weight = Double.MAX_VALUE;
        Node temp = null;
        List<Node> node = graph.node;
        StorageFrontPointAndNowSumWeight info;
        for (Node node1 : node) {
            if (!node1.id.equals(start) && !node1.treat) {
                info = this.path.get(node1.id);
                if (info.weight < weight) {
                    weight = info.weight;
                    temp = node1;
                }
            }
        }
        assert temp != null;
        temp.treat = true;
        return temp;
    }


    /**
     * 得到任意两个点之间的距离
     */
    private double getBetweenAnyTwoPointWeight(String start, String end, Graph graph) {
        Edge[] edge = graph.edge;
        for (Edge e : edge) {
            if (e.first.equals(start) && e.second.equals(end) || (e.first.equals(end) && e.second.equals(start))) {
                return e.weight;
            }
        }
        return Double.MAX_VALUE;
    }

    /**
     * 存储当前点之前的前驱点以及此时的累计权值
     */
    private class StorageFrontPointAndNowSumWeight {
        Node curNode;
        double weight;
        List<String> list;

        StorageFrontPointAndNowSumWeight(Node curNode, List<String> list, double weight) {
            this.curNode = curNode;
            this.list = list;
            this.weight = weight;
        }
    }
}
