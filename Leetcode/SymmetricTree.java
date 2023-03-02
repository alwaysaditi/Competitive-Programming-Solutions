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
class SymmetricTree {
    boolean answer = false;
    boolean isFound = false;
    public boolean isSymmetric(TreeNode root) {
        if(((root.left!=null)&&(root.right==null))||((root.left==null)&&(root.right!=null)))
        {
            return false;
        }
        else if(root.left==null&&(root.right==null))
        {
            return true;
        }
        findAnswer(root.left,root.right);
        if(isFound==true)
        {
            return false;

        }

        return true;
    }

    void findAnswer(TreeNode t1, TreeNode t2)
    {
        if(isFound==true)
        {
            return;
        }
        if(t1.val==t2.val)
        {
            System.out.println("1. t1 val= "+t1.val+" t2 val= "+t2.val);

            if(((t1.left==null)&&(t1.right==null))&&((t2.left==null)&&(t2.right==null)))
            {
                System.out.println("returning");
                return;
            }
            if(((t1.left==null)&&(t2.right!=null))||((t1.left!=null)&&(t2.right==null)))

            {
                System.out.println("here 1");
                System.out.println("opposite nodes missing");
                isFound = true;
                return;
            }
            if((t1.left!=null)&&(t2.right!=null))
            {
                System.out.println("here 2");

                findAnswer(t1.left,t2.right);

            }

            if(((t1.right==null)&&(t2.left!=null))||((t1.right!=null)&&(t2.left==null)))// this one is done after
                // checking the left nodes of t1 which aren't null obviously , so we check the
                // equality of the number of right nodes


            {
                System.out.println("here 3");
                System.out.println("opposite nodes missing");
                isFound = true;
                return;
            }

            if((t1.right!=null)&&(t2.left!=null))
            {
                System.out.println("here 4");

                findAnswer(t1.right,t2.left);
            }


            if(isFound==true)
            {
                return;
            }



        }
        else
        {
            isFound = true;
        }
    }


}