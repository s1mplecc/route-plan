package com.caacetc.hackathon.routeplan;

import org.junit.jupiter.api.Test;

import static com.caacetc.hackathon.routeplan.Point.*;
import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    void should_point_methods_run_correctly() {
        assertThat(A.isS() || A.isV()).isFalse();
        assertThat(S1.isS()).isTrue();
        assertThat(S2.isV()).isFalse();
        assertThat(V3.isV()).isTrue();
        assertThat(S1.matchedV()).isEqualTo(V1);
        assertThat(S3.matchedV()).isEqualTo(V3);
    }
}