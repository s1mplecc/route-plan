package com.caacetc.hackathon.routeplan;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DijkstraTest {
    private Dijkstra dijkstra = new Dijkstra(new Graph());

    @Test
    void should_compute_two_points_shortest_distance() {
        assertThat(dijkstra.min(1, 3)).isEqualTo(3);
        assertThat(dijkstra.min(1, 8)).isEqualTo(4);
        assertThat(dijkstra.min(1, 9)).isEqualTo(2);
        assertThat(dijkstra.min(1, 10)).isEqualTo(4);
        assertThat(dijkstra.min(1, 15)).isEqualTo(7);
        assertThat(dijkstra.min(3, 14)).isEqualTo(4);
        assertThat(dijkstra.min(3, 15)).isEqualTo(4);
        assertThat(dijkstra.min(4, 11)).isEqualTo(4);
    }
}