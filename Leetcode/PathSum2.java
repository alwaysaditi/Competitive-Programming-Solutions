package Leetcode;

import java.util.ArrayList;
import java.util.List;

//Definition for a binary tree node.
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        //TreeNode ptr = new TreeNode();
        // ptr= root;
        List<Integer> temp = new ArrayList<Integer>();
        if(root==null) return answer;

        DFS(root,root.val,answer,targetSum,0,temp);
        return answer;

    }
    void DFS(TreeNode root,int origroot, List<List<Integer>> answer, int target, int sum, List<Integer>temp)
    {

        temp.add(root.val);


//YOU DONT REMOVE AN ELEMENT ONLY WHEN YOU REACH THE END. YOU REMOVE THE ELEMENT WHEN YOU BACKTRACK.
        if(root.left!=null)
        {

            DFS(root.left,origroot,answer,target,sum,temp);}

        if(root.right!=null)
        {
            DFS(root.right,origroot,answer,target,sum,temp);}

        int sumnew=0;
        for(int i=0; i<temp.size();i++)
        {
            sumnew = sumnew+temp.get(i);
            System.out.print(" "+temp.get(i));
        }
        System.out.println(" ");
        System.out.println("sumnew= "+sumnew);
        if((sumnew==target)&&(root.left==null)&&(root.right==null))
        {
            ArrayList<Integer>copyList = new ArrayList<Integer>(temp);
            System.out.println("yesss");
            answer.add(copyList);
        }

        if(!temp.isEmpty())
        {
            int index = temp.size()-1;
            sum = sum- temp.get(index);
            temp.remove(index);
        }
// when an element is popped off , the modified arraylist should be returned to its parent.
    }


}