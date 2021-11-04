package q113;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the code from LeetCode that ran 0ms <br/>
 * However, this program should fail when the tree have maximum nodes which the height is no. of maximum nodes.<br/>
 * (the question stated "The number of nodes in the tree is in the range [0, 5000].", so a tree height >= 256 is possible.)<br/>
 * i.e. 5000 nodes all on the left-hand side or all on the right-hand side.<br/>
 * Most of the answers on LeetCode is using DFS recursion, suffering the same problem.<br/>
 * <br/>
 * <b>It is not my solution!</b> If you are the author, please contact me for the credit.
 */
class CaseStudy1 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //original with length 1000, ArrayIndexOutOfBoundsException will occur
//        int[] arr = new int[1000];
        //but even with 5000, the algorithm will fail with StackOverflowError
        int[] arr = new int[5000];
        List<List<Integer>> list = new ArrayList<>();
        pathSum(root,targetSum,arr,list,0);
        return list;
    }

    public void pathSum(TreeNode root,int targetSum,int[] arr,List<List<Integer>> pathSum,int level){
        if(root == null)return;
        targetSum = targetSum - root.val;
        arr[level] = root.val;
        if(root.left == null && root.right == null && targetSum == 0){
            List<Integer> ll = new ArrayList<>();
            for(int i=0;i<=level;i++){
                ll.add(arr[i]);
            }
            pathSum.add(ll);
        }else{
            pathSum(root.left,targetSum,arr,pathSum,level+1);
            pathSum(root.right,targetSum,arr,pathSum,level+1);
        }
    }
}
