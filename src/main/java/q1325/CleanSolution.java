package q1325;

/**
 * <p>
 *   It is a clean implementation of the solution. Instead of return boolean, just return the node itself if the node
 *   needed to be kept, otherwise return null. The performance is similar to the original implementation.
 * </p>
 */
class CleanSolution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }
}