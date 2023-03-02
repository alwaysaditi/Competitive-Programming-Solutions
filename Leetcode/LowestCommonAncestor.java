package Leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode answer = findAncestor( root, p, q);
        return answer;
    }

  TreeNode findAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if(((p.val<root.val)&&(q.val>root.val))||((p.val>root.val)&&(q.val<root.val))||(p.val==root.val)||(q.val==root.val))
        {
            return root;
        }
         else if((q.val<root.val)&&(p.val<root.val))
         {
           root=  findAncestor(root.left,p,q);
         }

         else if((q.val>root.val)&&(p.val>root.val))
         {
           root=  findAncestor(root.right,p,q);

         }
return root;
        
    }
}
