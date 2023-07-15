// basic approach with pure backtracking without bitmask 

class MaxScoreNOperations {
    boolean visited[];
    int n;
    int[][]gcds;
    int maxval;
    int totalscore =0;
    public int maxScore(int[] nums) {
       n = nums.length/2;
       visited = new boolean[nums.length];
       gcds = new int[nums.length][nums.length];
       recursive(true,1,0,nums,0);
       return maxval;
    }


void recursive(boolean first , int turn, int fval, int[]nums, int ival)
{
    if(first)
    {
        for (int i=0;i<nums.length;i++)
        {
            if(!visited[i])
            {
                visited[i]=true;
                recursive(false,turn,nums[i],nums,i);
                visited[i]=false;
            }
        }
    }

    else
    {
        for(int i=0;i<nums.length;i++)
        {
if(!visited[i])
{
    if(gcds[ival][i]==0)
    {
        findGCD(nums[i],nums[ival],i,ival);
      
    }

  totalscore = totalscore + gcds[ival][i]*turn;
  
  
    // ival is the index passed of the first number 
   
    visited[i]=true;

    if(turn == n)
    {
        if (totalscore>maxval)
        {
            maxval = totalscore;
        }
    }

    else {
        int step = turn+1;
        recursive(true,step,0,nums,0);
    }

    totalscore = totalscore - turn*gcds[ival][i]; // subtracting that pair's gcd

    visited[i]=false;

}
        }
    }
}

    int findGCD(int n1, int n2, int i1, int i2)
    {
        while(n1!=n2)   
{  
if(n1>n2)  
n1=n1-n2;  
else  
n2=n2-n1;  
}  

gcds[i1][i2] = n2;
gcds[i2][i1]=n2;

return n2;
    }
}
