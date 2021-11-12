package q113;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>This is the code from LeetCode that ran 0ms.</p>
 *
 * <p><b>It is not my solution!</b> If you are the author, please contact me for the credit.</p>
 */
class CaseStudy1 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //ArrayIndexOutOfBoundsException will occur
        int[] arr = new int[1000];
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
