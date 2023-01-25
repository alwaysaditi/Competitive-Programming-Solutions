/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int answer = calculateLeftSum(root,-1,0);
        return answer;
    }
    // 0 - leftchild, 1-rightchild
    int calculateLeftSum(TreeNode root, int childvalue,int sum)
    {

        if(root.left!=null)
        {
            sum= calculateLeftSum(root.left,0,sum);
        }

        if(root.right!=null)
        {
            sum= calculateLeftSum(root.right,1,sum);
        }

        if((root.left==null)&&(root.right==null)&&(childvalue==0))
        {
            sum = sum+root.val;
            System.out.println("root.val= "+root.val);
            System.out.println("sum= "+sum);
        }
        return sum;
    }
}