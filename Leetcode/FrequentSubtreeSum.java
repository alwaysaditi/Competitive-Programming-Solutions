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
 //Plain simple Depth First Search with recursion
class FrequentSubtreeSum {

HashMap <Integer, Integer> frequencies = new HashMap<Integer,Integer>();

    public int[] findFrequentTreeSum(TreeNode root) {
      
        findSum(root);
       
        int maxfreq=Integer.MIN_VALUE;
        int countfreq=0; // for how many elements have the maximum frequency to get the size of the 
        // array to be returned
        
        for (Map.Entry<Integer,Integer> entry : frequencies.entrySet())
        {
           if(entry.getValue()>maxfreq)
           {
               maxfreq= entry.getValue();
               countfreq=1;
           }

           else if(entry.getValue()==maxfreq)
           {
               countfreq++;
           }

           else continue;
        }

        int answer[] = new int[countfreq];
        int ptr=0;
          for (Map.Entry<Integer,Integer> entry : frequencies.entrySet())
        {
           if(entry.getValue()==maxfreq)
           {
              answer[ptr] = entry.getKey();
              ptr++;
              if(ptr==answer.length)
              {
                  break;
              }
           }
        }
     
       // System.out.println(frequencies);
        return answer;
    }

    int findSum(TreeNode root)
    {
int sum = root.val;

if(root.left!=null)
{
    sum = sum+ findSum(root.left);
}

if(root.right!=null)
{
    sum = sum+ findSum(root.right);
}
if(frequencies.containsKey(sum))
{
    frequencies.put(sum, (frequencies.get(sum)+1));
}

else 
{
    frequencies.put(sum,1);
}

return sum;
    }
}
