package q113;

import java.util.*;

/**
 * 113. Path Sum II
 * See <a herf="https://leetcode.com/problems/path-sum-ii/">
 *       https://leetcode.com/problems/path-sum-ii/
 *     </a>
 */
class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {

            int currentSum = 0;

            // the list for the value of path
            LinkedList<Integer> pathVals = new LinkedList<>();

            // the process node for subtracting the value
            Deque<VisitTreeNode> processingNodes = new LinkedList<>();
            processingNodes.push(new VisitTreeNode(root));

            while (!processingNodes.isEmpty()) {
                VisitTreeNode currentNode = processingNodes.pop();
                if (currentNode.isVisited) {
                    pathVals.removeLast();
                    currentSum -= currentNode.node.val;

                // leaf node, check the value directly
                } else if (
                    currentNode.node.right == null &&
                    currentNode.node.left == null &&
                    currentSum + currentNode.node.val == targetSum
                ) {
                    ArrayList<Integer> path = new ArrayList<>(pathVals);
                    path.add(currentNode.node.val);
                    result.add(path);
                } else {
                    currentNode.isVisited = true;
                    processingNodes.push(currentNode);
                    pathVals.add(currentNode.node.val);
                    currentSum += currentNode.node.val;

                    if (currentNode.node.right != null) {
                        processingNodes.push(new VisitTreeNode(currentNode.node.right));
                    }
                    if (currentNode.node.left != null) {
                        processingNodes.push(new VisitTreeNode(currentNode.node.left));
                    }
                }
            }

        }
        return result;
    }
}

class VisitTreeNode {

    final TreeNode node;
    boolean isVisited = false;

    public VisitTreeNode(TreeNode node) {
        this.node = node;
    }
}