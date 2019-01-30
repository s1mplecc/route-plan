package com.caacetc.hackathon.routeplan;

import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {
        RouteGenerator generator = new RouteGenerator();
        List<Route> routes = generator.generate();

        routes.forEach(route -> System.out.println(route + " 最短路径长度: " + route.length()));

        Route shortestRoute = routes.stream().min(Comparator.comparing(Route::length)).get();

        System.out.println(String.format("\n其中最短路径为 %s, 路径长度为 %s.", shortestRoute, shortestRoute.length()));
    }
}
