package q113;

import java.util.*;

/**
 * 113. Path Sum II
 * See <a herf="https://leetcode.com/problems/path-sum-ii/">
 *       https://leetcode.com/problems/path-sum-ii/
 *     </a>
 */
class Solution {

    static final Object VISITED = new Object();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {

            int currentSum = 0;

            // the list for the value of path
            LinkedList<Integer> pathVals = new LinkedList<>();

            // the process node for subtracting the value
            Deque<TreeNode> processingNodes = new LinkedList<>();

            //the map to remember node is visited
            Map<TreeNode, Object> visitedMap = new HashMap<>();

            TreeNode currentNode = root;
            do {
                if (visitedMap.containsKey(currentNode)) {
                    //visited before
                    pathVals.removeLast();
                    currentSum -= currentNode.val;

                // leaf node, check the value directly
                } else if (currentNode.right == null && currentNode.left == null && currentSum + currentNode.val == targetSum) {
                    ArrayList<Integer> path = new ArrayList<>(pathVals);
                    path.add(currentNode.val);
                    result.add(path);
                } else {
                    visitedMap.put(currentNode, VISITED);
                    processingNodes.addFirst(currentNode);
                    pathVals.add(currentNode.val);
                    currentSum += currentNode.val;

                    if (currentNode.right != null) {
                        processingNodes.addFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        processingNodes.addFirst(currentNode.left);
                    }
                }

                currentNode = processingNodes.poll();

            } while (!processingNodes.isEmpty());

        }
        return result;
    }
}
