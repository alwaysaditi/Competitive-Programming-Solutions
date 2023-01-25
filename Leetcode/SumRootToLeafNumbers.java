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
class SumRootToLeafNumbers {
    int sum;
    public int sumNumbers(TreeNode root) {
        calculateSum(root,"");
        return sum;
    }

    void calculateSum(TreeNode root, String num)
    {
        num = num + Integer.toString(root.val);

        if(root.left!=null)
        {
            calculateSum(root.left,num);
        }

        if(root.right!=null)
        {
            calculateSum(root.right,num);
        }

        if((root.left==null)&&(root.right==null))
        {
            System.out.println("num= "+num);

            sum = sum + Integer.parseInt(num);
            // num="";
            // return sum;
        }
//return sum;
//return sum.substring(0, sum.length() - 1);
    }
}