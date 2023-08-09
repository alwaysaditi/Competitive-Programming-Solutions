// beautiful arranegemnt 

class Solution {
    List<Integer> temp = new ArrayList<Integer>();
   // int count;
    boolean occupied[];
    int count =0;
    public int countArrangement(int n) {
 occupied = new boolean[n];
 int nums[]= new int[n];
 for(int i=0;i<n;i++)
 {
     nums[i]=i+1;
 }
 for(int i=0;i<n;i++)
 {
recursive(i,temp,nums,1);
 }
  return count;  }
// size is the next index to be occupied
    void recursive(int index,List<Integer>temp, int[]nums, int size)
    {
if(((nums[index]%(size)==0))||((size)%nums[index]==0))
{
  
  //System.out.println("index= "+(index+1)+" nums index = "+nums[index]);
    temp.add(nums[index]);
    occupied[index]=true;
    size++;
}
else
{
    return;
}
if(temp.size()<nums.length)
{
  
 for(int i=0;i<nums.length;i++)
    {
        if(!occupied[i])
        {
recursive(i,temp,nums,size);
        }
        // index to be sent is the next index to be occupied rather than the index of the number to be checked. 
        else continue;
    }
    
   // else continue;
}
else
{
    //System.out.println(temp);
    count++;
}
temp.remove(temp.size()-1);
occupied[index]=false;
size--;
    }
}
