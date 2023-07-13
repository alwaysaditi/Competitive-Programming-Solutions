//backtracking

class Solution {
    boolean occupied[];
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> answer = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
  occupied = new boolean[nums.length];
  for(int i=0;i<nums.length;i++)
  {
recursive(i,temp,nums);
//System.out.println(answer);
  }
return answer;
    }

    void recursive(int index, List<Integer> temp, int[]nums)
    {
        temp.add(nums[index]);
        
        occupied[index]=true;

        if(temp.size()<nums.length)
        {
 for(int i=0;i<nums.length;i++)
 {
     if(!occupied[i])
     {
        
         recursive(i,temp,nums);
     }

     else continue;
 }
        }
        else
        {
          //  System.out.println(temp);
        
            answer.add(new ArrayList<>(temp));
         //System.out.println(answer);
        }

        temp.remove(temp.size()-1);
        occupied[index]=false;
    }
}
