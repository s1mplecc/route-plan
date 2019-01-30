package com.caacetc.hackathon.routeplan;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RouteGeneratorTest {
    @Test
    void should_generate_all_possible_and_legal_routes() {
        RouteGenerator generator = new RouteGenerator();
        List<Route> routes = generator.generate();
        assertThat(routes.size()).isEqualTo(54);
        assertThat(routes.get(0).toString()).isEqualTo("A -> V1 -> V2 -> S1 -> V3 -> S2 -> S3");
        assertThat(routes.get(53).toString()).isEqualTo("A -> V3 -> S3 -> V2 -> S2 -> V1 -> S1");
    }
}