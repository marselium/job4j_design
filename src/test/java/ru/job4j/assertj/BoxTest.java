package ru.job4j.assertj;

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
        double area = Math.ceil(box.getArea());
        assertThat(area).isEqualTo(44D);
    }

    @Test
    void whenSphereEdgeIs3ThenAreaEquals43() {
        Box box = new Box(0, 3);
        double area = Math.ceil(box.getArea());
        assertThat(area).isEqualTo(114D);
    }

    @Test
    void whenSphereEdgeIs3ThenAreaEquals114() {
        Box box = new Box(0, 3);
        double area = Math.ceil(box.getArea());
        assertThat(area).isEqualTo(114D);
    }
}