package com.caacetc.hackathon.routeplan;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.caacetc.hackathon.routeplan.Point.*;
import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    void should_point_methods_correct() {
        assertThat(S1.isS()).isTrue();
        assertThat(S2.isV()).isFalse();
        assertThat(V3.isV()).isTrue();

        List<Point> points = Lists.newArrayList(V1, V2, S1);
        assertThat(S1.existVBefore(points)).isTrue();
        assertThat(S2.existVBefore(points)).isTrue();
        assertThat(S3.existVBefore(points)).isFalse();
    }
}