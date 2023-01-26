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
// Leetcode 515 : Breadthfirst search
class Solution {
    Queue<TreeNode> queue
            = new LinkedList<>();
    boolean added = false;
    int level=0;
    List <Integer> answer = new ArrayList<Integer>();
    public List<Integer> largestValues(TreeNode root) {
        if(root==null)
        {
            return answer;
        }
        queue.add(root);
        queue.add(null);
        addQueue();
        return answer;
    }
    // 1 null 3 2 null 5 3 9 null
    void addQueue()
    {
        System.out.println("level= "+level);
        int maxval = Integer.MIN_VALUE;
        while(queue.peek()!=null)
        {
            TreeNode ele = queue.remove();
            System.out.println("element= "+ele.val);
            if(ele.val > maxval)
            {
                maxval = ele.val;
            }
            if(ele.left!=null)
            {
                queue.add(ele.left);
            }
            if(ele.right!=null)
            {
                queue.add(ele.right);
            }
        }
        answer.add(maxval);
        queue.add(null);//adding delimiter after the level
        queue.remove(); // removing the null element;
        if(added==true)
        {
            return;
        }
        if(queue.peek()==null)
        {
            added = true;
            return;
        }
        else
        {
            level++;
            addQueue();
        }
    }
}