package com.caacetc.hackathon.routeplan;

import java.util.List;

public enum Point {
    V1(3),
    V2(7),
    V3(4),
    S1(12),
    S2(11),
    S3(13);

    private final int index;

    Point(int index) {
        this.index = index;
    }

    public int index() {
        return index;
    }

    public boolean isV() {
        return this.toString().startsWith("V");
    }

    public boolean isS() {
        return this.toString().startsWith("S");
    }

    public boolean haveVBefore(List<Point> route) {
        return route.stream().anyMatch(point -> point.toString().equals("V" + this.toString().charAt(1)));
    }
}
