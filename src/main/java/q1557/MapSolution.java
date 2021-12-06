package q1557;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>It is a solution using map instead of int array. It is generally slower.</p>
 */
class MapSolution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Map<Integer, Integer> cntsMap = new HashMap<>(n);
        for (List<Integer> edge : edges) {
            cntsMap.putIfAbsent(edge.get(1), 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            Integer num = cntsMap.get(i);
            if (num == null) {
                result.add(i);
            }
        }
        return result;
    }
}
