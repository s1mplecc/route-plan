package com.caacetc.hackathon.routeplan;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

import static com.caacetc.hackathon.routeplan.Point.*;

/**
 * Generate all possible and legal routes.
 */
public class RouteGenerator {
    private List<Route> routes = new ArrayList<>();

    public List<Route> generate() {
        fork(new Route(), List.of(V1, V2, V3, S1, S2, S3));
        return routes;
    }

    /**
     * @param route  an unmodifiable route
     * @param remain an unmodifiable remain points list
     */
    private void fork(final Route route, final List<Point> remain) {
        if (!route.isLegal()) {
            return;
        }

        for (int i = 0; i < remain.size(); i++) {
            List<Point> temp = Lists.newArrayList(remain);
            Point next = temp.remove(i);
            Route route1 = route.copy();
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
