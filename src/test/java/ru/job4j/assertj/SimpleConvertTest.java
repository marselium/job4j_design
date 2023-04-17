package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> array = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(array).containsExactly("first", "second", "three", "four", "five")
                .containsSequence("three", "four")
                .doesNotContain("zero", "eight", "six")
                .startsWith("first", "second")
                .endsWith("five");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> array = simpleConvert.toSet("first", "second", "three", "four", "five");
        assertThat(array).anyMatch(e -> e == "four")
                .noneMatch(e -> e == "ten")
                .containsOnly("first", "second", "three", "four", "five")
                .isNotEmpty();
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> array = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(array).doesNotContainValue(12)
                .containsKey("first")
                .hasSizeGreaterThan(3)
                .hasSize(5)
                .doesNotContainKeys("key", "Hello");
    }
}