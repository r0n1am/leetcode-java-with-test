package q113;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static java.util.function.Function.identity;
import static org.assertj.core.api.Assertions.assertThat;

class CaseStudy1Test {

    static CaseStudy1 c = new CaseStudy1();

    @Test
    void shouldReturnEmptyResult() {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);

        List<List<Integer>> results = c.pathSum(root, 5);
        assertThat(results).isEmpty();
    }

    @Test
    void shouldReturnOneResult() {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(9);
        TreeNode root = new TreeNode(1, left, right);

        List<List<Integer>> results = c.pathSum(root, 3);
        assertThat(results)
            .hasSize(1)
            .flatExtracting(identity())
            .containsExactly(1, 2);
    }

    @Test
    void shouldReturnTwoResult() {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        TreeNode root = new TreeNode(1, left, right);

        List<List<Integer>> results = c.pathSum(root, 3);
        assertThat(results)
            .hasSize(2)
            .flatExtracting(identity())
            .containsExactly(1, 2, 1, 2);
    }

    @Test
    void shouldReturnOneResultThreeLevelTree() {
        TreeNode root = getSampleTree();

        List<List<Integer>> results = c.pathSum(root, 22);
        assertThat(results)
            .hasSize(2)
            .flatExtracting(identity())
            .containsExactly(
                5, 4, 11, 2,
                5, 8, 4, 5
            );
    }

    @Test
    //I don't know why, but in my IntelliJ, run this test alone will not throw StackOverflowError
    //but run the whole test will throw StackOverflowError as expected
    //WHY???
    void shouldStackOverthrowMaximumLevelTree() {
        TreeNode root = null;

        //test all left child
        LinkedList<Integer> expected = new LinkedList<>();
        for (int i = 1; i <= 5000; ++i) {
            root = new TreeNode(i, root, null);
            expected.addFirst(i);
        }

        List<List<Integer>> results = c.pathSum(root, 5000*5001/2);
        assertThat(results)
            .hasSize(1)
            .flatExtracting(identity())
            .containsExactlyElementsOf(expected);

        //test all right child
        TreeNode temp = root;
        while (temp != null) {
            temp.right = temp.left;
            temp.left = null;
            temp = temp.right;
        }

        results = c.pathSum(root, 5000*5001/2);
        assertThat(results)
            .hasSize(1)
            .flatExtracting(identity())
            .containsExactlyElementsOf(expected);
    }

    private TreeNode getSampleTree() {

        TreeNode left = new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null);
        TreeNode right = new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1)));

        return new TreeNode(5, left, right);
    }
}