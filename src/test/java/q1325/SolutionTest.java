package q1325;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    static Solution s = new Solution();

    @Test
    void shouldReturnCorrectResultWithSampleTests() {
        // case 1
        TreeNode root =
            new TreeNode(1,
                new TreeNode(2,
                    new TreeNode(2),
               null
                ),
                new TreeNode(3,
                    new TreeNode(2),
                    new TreeNode(4)
                )
            );

        bfsVerify(s.removeLeafNodes(root, 2), new int[]{1,3,4});

        // case 2
        root =
            new TreeNode(1,
                new TreeNode(3,
                    new TreeNode(3),
                    new TreeNode(2)
                ),
                new TreeNode(3)
            );


        bfsVerify(s.removeLeafNodes(root, 3), new int[]{1,3,2});

        // case 3
        root =
            new TreeNode(1,
                new TreeNode(2,
                    new TreeNode(2,
                        new TreeNode(2),
                   null
                    ),
               null
                ),
           null
            );

        bfsVerify(s.removeLeafNodes(root, 2), new int[]{1});

        // case 4
        root =
            new TreeNode(1,
                new TreeNode(1),
                new TreeNode(1)
            );

        bfsVerify(s.removeLeafNodes(root, 1), new int[]{});


        // case 5
        root =
            new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3)
            );

        bfsVerify(s.removeLeafNodes(root, 1), new int[]{1,2,3});
    }

    private void bfsVerify(TreeNode node, int[] results) {
        assertThat(bfs(node))
            .containsExactly(results);
    }

    private int[] bfs(TreeNode node) {
        if (node == null) {
            return new int[0];
        }
        List<Integer> bfs = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(node);
        while (!nodes.isEmpty()) {
            TreeNode temp = nodes.pop();
            bfs.add(temp.val);
            if (temp.left != null) {
                nodes.add(temp.left);
            }
            if (temp.right != null) {
                nodes.add(temp.right);
            }
        }
        return bfs.stream().mapToInt(i->i).toArray();
    }
}
