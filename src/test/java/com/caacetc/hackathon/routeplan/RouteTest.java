package com.caacetc.hackathon.routeplan;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.caacetc.hackathon.routeplan.Point.*;
import static org.assertj.core.api.Assertions.assertThat;

class RouteTest {
    private Route route;

    @Test
    void should_judge_whether_route_is_legal() {
        route = new Route(Lists.newArrayList(V1));
        assertThat(route.isLegal()).isTrue();

        route = new Route(Lists.newArrayList(V1, V2, S2, V3, S1, S3));
        assertThat(route.isLegal()).isTrue();

        // first is V
        route = new Route(Lists.newArrayList(S1));
        assertThat(route.isLegal()).isFalse();

        // last is S
        route = new Route(Lists.newArrayList(V1, S2, V3, S3, S1, V2));
        assertThat(route.isLegal()).isFalse();

        // continue 3 V
        route = new Route(Lists.newArrayList(V1, V2, V3, S3, S1, S2));
        assertThat(route.isLegal()).isFalse();

        // S after matched V
        route = new Route(Lists.newArrayList(V1, S2));
        assertThat(route.isLegal()).isFalse();
    }

    @Test
    void should_compute_shortest_distance() {
        route = new Route(List.of(V1, V2, V3, S1, S2, S3));
        assertThat(route.minDistance()).isEqualTo(22);

        route = new Route(List.of(V1, S1));
        assertThat(route.minDistance()).isEqualTo(9);

        route = new Route(List.of(V2, S2));
        assertThat(route.minDistance()).isEqualTo(5);

        route = new Route(List.of(V3, S3));
        assertThat(route.minDistance()).isEqualTo(8);

        route = new Route(Lists.newArrayList(V1, V2, S2, V3, S1, S3));
        assertThat(route.minDistance()).isEqualTo(20);

    }
}