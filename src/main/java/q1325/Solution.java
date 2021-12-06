package q1325;

/**
 * <p>1325. Delete Leaves With a Given Value</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/delete-leaves-with-a-given-value/">
 *         https://leetcode.com/problems/delete-leaves-with-a-given-value/
 *       </a>
 * </p>
 * <p>It is my original implementation. the post order method return true if the param node needed to be deleted.</p>
 */
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return postOrderRemove(root, target) ? null : root;
    }

    private boolean postOrderRemove(TreeNode node, int target) {
        if (node == null) {
            return false;
        }

        if (postOrderRemove(node.left, target)) {
            node.left = null;
        }
        if (postOrderRemove(node.right, target)) {
            node.right = null;
        }

        return node.left == null && node.right == null && node.val == target;
    }
}