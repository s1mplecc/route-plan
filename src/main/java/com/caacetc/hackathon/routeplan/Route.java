package com.caacetc.hackathon.routeplan;

import com.caacetc.hackathon.routeplan.dijkstra.DistanceUtil;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private final List<Point> route;

    public Route() {
        route = new ArrayList<>();
    }

    public Route(List<Point> route) {
        this.route = route;
    }

    public void add(Point point) {
        route.add(point);
    }

    public int size() {
        return route.size();
    }

    public Route copy() {
        return new Route(Lists.newArrayList(route));
    }

    // todo
    public int minDistance() {
        int length = 0;
        for (int i = 0; i < route.size() - 1; i++) {
            length += DistanceUtil.min(route.get(i).index(), route.get(i + 1).index());
        }
        length += DistanceUtil.min("2", route.get(0).index());
        return length;
    }

    public boolean isLegal() {
        if (route.size() == 0) {
            return true;
        }

        return firstIsV() && lastIsS() && !continue3V() && sAfterMatchedV();
    }

    private boolean firstIsV() {
        return route.get(0).isV();
    }

    private boolean sAfterMatchedV() {
        Point last = route.get(route.size() - 1);
        if (!last.isS()) {
            return true;
        } else {
            return route.contains(last.matchedV());
        }
    }

    private boolean lastIsS() {
        if (route.size() < 6) {
            return true;
        }
        return route.get(route.size() - 1).isS();
    }

    private boolean continue3V() {
        if (route.size() < 3) {
            return false;
        }

        return route.subList(0, 3).stream().allMatch(Point::isV);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("A -> ");
        for (Point point : route) {
            sb.append(point).append(" -> ");
        }
        sb.delete(sb.length() - 4, sb.length());
        return sb.toString();
    }
}
