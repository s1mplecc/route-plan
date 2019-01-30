package com.caacetc.hackathon.routeplan.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;

public class Dijkstra {
    /**
     * 存储每个点的最短距离经过的点以及当前到该点的最短距离
     */
    private HashMap<String, storageFrontPointAndNowSumWieght> path = new HashMap<String, storageFrontPointAndNowSumWieght>();

    public double getMinLength(Graph graph, String start, String end) {
        initializeSourceToOtherMinDistance(graph, start, end);
        Node node = new Node();
        node = returnNowSourceToOtherDistance(graph, start);
        //更新从源点出发到其他点的最短距离
        while (node != null && !node.id.equals(end)) {
            storageFrontPointAndNowSumWieght info = path.get(node.id);
            double tempWeight = info.weight;
            for (Node v : graph.node) {
                if (v.id.equals(start) || v.id.equals(node.id) || v.treat) {
                    continue;
                } else {
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
            node = returnNowSourceToOtherDistance(graph, start);//循环找到从源点到其他点最短距离的点
        }
        return getResult(end);
    }

    /**
     * 初始化从源点到其他点的最短距离
     */
    private void initializeSourceToOtherMinDistance(Graph graph, String start, String end) {
        ArrayList<Node> node = graph.node;
        for (Node v : node) {
            if (v.id.equals(start)) {
                continue;
            } else {
                double weight = getBetweenAnyTwoPointWeight(start, v.id, graph);
                ArrayList list = new ArrayList();
                list.add(start);
                storageFrontPointAndNowSumWieght info = new storageFrontPointAndNowSumWieght(v, list, weight);
                path.put(v.id, info);
            }
        }

    }

    /**
     * 返回此时从源点到其他点的最短距离
     */
    private Node returnNowSourceToOtherDistance(Graph graph, String start) {
        double weight = Double.MAX_VALUE;
        Node temp = null;
        ArrayList<Node> node = graph.node;
        storageFrontPointAndNowSumWieght info = new storageFrontPointAndNowSumWieght();
        for (int i = 0; i < node.size(); i++) {
            if (!node.get(i).id.equals(start) && !node.get(i).treat) {
                info = this.path.get(node.get(i).id);
                if (info.weight < weight) {
                    weight = info.weight;
                    temp = node.get(i);
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
            } else {
            }
        }
        return Double.MAX_VALUE;
    }

    private double getResult(String end) {
        storageFrontPointAndNowSumWieght info = path.get(end);
        for (String s : info.list) {
            System.out.print(s + "——>");
        }
        System.out.print(end);
        System.out.println("最短路径长度:" + info.weight);

        return info.weight;
    }

    /**
     * 存储当前点之前的前驱点以及此时的累计权值
     */
    class storageFrontPointAndNowSumWieght {
        Node curNode;
        double weight;
        ArrayList<String> list = new ArrayList();

        public storageFrontPointAndNowSumWieght(Node curNode, ArrayList list, double weight) {
            this.curNode = curNode;
            this.list = list;
            this.weight = weight;
        }

        public storageFrontPointAndNowSumWieght() {
            // TODO Auto-generated constructor stub
        }
    }
}
