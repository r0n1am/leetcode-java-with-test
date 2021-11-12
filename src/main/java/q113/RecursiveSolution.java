package q113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>My solution with recursive DFS.</p>
 * <p>The question stated "The number of nodes in the tree is in the range [0, 5000]."
 * However, this algorithm may fail because of StackOverflowError (depends on call stack size)
 * when the tree have maximum nodes which the height is no. of maximum nodes.
 * i.e. 5000 nodes all on the left-hand side or all on the right-hand side.</p>
 */
class RecursiveSolution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            pathSum(root, result, new LinkedList<>(), 0, targetSum);
        }
        return result;
    }

    private void pathSum(
        TreeNode currentNode,
        List<List<Integer>> result,
        LinkedList<Integer> pathVals,
        int currentSum,
        int targetSum
    ) {
        pathVals.add(currentNode.val);
        currentSum += currentNode.val;

        if (currentNode.left == null && currentNode.right == null) {
            if (targetSum == currentSum) {
                result.add(new ArrayList<>(pathVals));
            }
            return;
        }

        if (currentNode.left != null) {
            pathSum(currentNode.left, result, pathVals, currentSum, targetSum);
            pathVals.removeLast();
        }
        if (currentNode.right != null) {
            pathSum(currentNode.right, result, pathVals, currentSum, targetSum);
            pathVals.removeLast();
        }
    }
}
