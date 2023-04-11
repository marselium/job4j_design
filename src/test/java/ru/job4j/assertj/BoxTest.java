package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 8);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
    }

    @Test
    void isUnknownFigure() {
        Box box = new Box(5, 4);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void whenTetrahedronEdgeIs5ThenAreaEquals43pt3() {
        Box box = new Box(4, 5);
        double area = box.getArea();
        assertThat(area).isCloseTo(43.3D, Percentage.withPercentage(0.01d));
    }

    @Test
    void whenSphereEdgeIs3ThenAreaEquals43() {
        Box box = new Box(0, 3);
        double area = box.getArea();
        assertThat(area).isCloseTo(113.1D, Percentage.withPercentage(0.01d));
    }

    @Test
    void figureIsNotExists() {
        Box box = new Box(123, 3);
        boolean bool = box.isExist();
        assertThat(bool).isFalse();
    }
}