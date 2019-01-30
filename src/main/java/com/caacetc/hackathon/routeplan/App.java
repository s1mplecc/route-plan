package com.caacetc.hackathon.routeplan;

import java.util.List;

public class App {
    public static void main(String[] args) {
        RouteGenerator generator = new RouteGenerator();
        List<Route> routes = generator.generate();
//        for (Route route : routes) {
//            System.out.println(route);
//            System.out.println(route.length());
//        }
//
//        System.out.println();

        routes.stream()
//                .filter(route -> route.length() == 17)
                .forEach(
                        route -> {
                            System.out.println(route + " " + route.length());
                        }
                );
    }
}
