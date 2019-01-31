package com.caacetc.hackathon.routeplan;

import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {
        long before = System.currentTimeMillis();

        List<Route> routes = new RouteGenerator().generate();
        routes.forEach(route -> System.out.println(route + " 最短路径长度: " + route.minDistance()));
        Route shortestRoute = routes.stream().min(Comparator.comparing(Route::minDistance)).get();
        System.out.println(String.format("\n其中最短路径为 %s, 路径长度为 %s.", shortestRoute, shortestRoute.minDistance()));

        long after = System.currentTimeMillis();
        System.out.println("运行耗时:" + (after - before) + "ms.");
    }
}
