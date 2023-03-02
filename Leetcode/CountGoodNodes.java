package Leetcode;

import java.util.Stack;

public class CountGoodNodes {
    int countgood =0;
    public int goodNodes(TreeNode root) {
        Stack<Integer>myStack = new Stack<Integer>();
        myStack.push(root.val);
        DFS(myStack,root);
        return countgood;
    }

    void DFS(Stack<Integer> myStack, TreeNode root)
    {
        if((!myStack.empty())&&root.val>=myStack.peek())
        {
            countgood++;
            myStack.push(root.val);
        }
        if(root.left!=null)
        {
            DFS(myStack,root.left);
        }
        if(root.right!=null)
        {
            DFS(myStack,root.right);
        }
        if(!myStack.empty()&&(root.val==myStack.peek()))
        {
            myStack.pop();
        }
    }
}
