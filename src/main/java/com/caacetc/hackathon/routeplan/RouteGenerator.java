package com.caacetc.hackathon.routeplan;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

import static com.caacetc.hackathon.routeplan.Point.*;

/**
 * Generate all possible and legal routes.
 */
public class RouteGenerator {
    private List<Point> box;
    private List<Route> routes = new ArrayList<>();

    public List<Route> routes() {
        return routes;
    }

    public void initBox() {
        this.box = Lists.newArrayList(V1, V2, V3, S1, S2, S3);
    }

    public void generate() {
        initBox();
        Route route = new Route();
        if (box.size() > 1) {
            fork(route, box);
        }
    }

    private void fork(Route route, List<Point> remain) {
        int size = remain.size();

        for (int i = 0; i < size; i++) {
            if (!route.isLegal()) {
                return;
            }

            List<Point> temp = Lists.newArrayList(remain);
            Route route1 = route.copy();
            Point next = temp.remove(i);
            route1.add(next);
            fork(route1, temp);

            if (route1.size() == 6) {
                routes.add(route1);
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Route route : routes) {
            sb.append(route).append("\n");
        }
        return sb.toString();
    }
}
