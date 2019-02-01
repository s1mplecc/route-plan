package com.caacetc.hackathon.routeplan;

import static com.caacetc.hackathon.routeplan.Point.Type.*;


public enum Point {
    A(2, START),
    V1(3, VIP),
    V2(7, VIP),
    V3(4, VIP),
    S1(12, DESTINATION),
    S2(11, DESTINATION),
    S3(13, DESTINATION);

    private final int index;
    private final Type type;

    Point(int index, Type type) {
        this.index = index;
        this.type = type;
    }

    public String index() {
        return Integer.toString(index);
    }

    public boolean isV() {
        return type.equals(VIP);
    }

    public boolean isS() {
        return type.equals(DESTINATION);
    }

    public Point matchedV() {
        if (!this.isS()) {
            throw new RuntimeException();
        }

        return Point.valueOf("V" + this.toString().charAt(1));
    }

    public enum Type {
        VIP, DESTINATION, START
    }
}
