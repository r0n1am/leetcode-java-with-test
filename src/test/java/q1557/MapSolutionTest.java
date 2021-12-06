package q1557;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MapSolutionTest {

    static MapSolution s = new MapSolution();

    @Test
    void shouldReturnSingleNodeListWithSinglePathGraph() {
        List<List<Integer>> ints = new ArrayList<>();
        ints.add(List.of(0,1));
        ints.add(List.of(1,2));
        ints.add(List.of(2,3));
        ints.add(List.of(3,4));
        assertThat(s.findSmallestSetOfVertices(5, ints))
            .containsExactly(0);
    }

    @Test
    void shouldReturnCorrectResultWithSampleTests() {
        // case 1
        List<List<Integer>> ints = new ArrayList<>();
        ints.add(List.of(0,1));
        ints.add(List.of(0,2));
        ints.add(List.of(2,5));
        ints.add(List.of(3,4));
        ints.add(List.of(4,2));
        assertThat(s.findSmallestSetOfVertices(6, ints))
            .containsExactly(0, 3);

        // case 1
        ints = new ArrayList<>();
        ints.add(List.of(0,1));
        ints.add(List.of(2,1));
        ints.add(List.of(3,1));
        ints.add(List.of(1,4));
        ints.add(List.of(2,4));
        assertThat(s.findSmallestSetOfVertices(5, ints))
            .containsExactly(0, 2, 3);
    }
}
