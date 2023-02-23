package Leetcode;
// Leetcode 416: Partition Equal Subset Sum
// its a variation of the 0/1 knapsack algorithm, where you should recognize that an element can be chosen
// or not. It is a DP problem , since we build the solution incrementally ( the solution is the target sum, starting from 1)
// the DP table helps to build the incremental solution
public class PartitionEqualSubset {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum = sum+nums[i];
        }
        if(sum%2!=0)
        {
            return false;
        }
        int target = sum/2;
        boolean answer=false;
        int dp[][] = new int[nums.length][target+1];
        if(nums[0]<=target)
        {
            dp[0][nums[0]]=1;
            if(nums[0]==target)
            {
                return true;
            }
        }
        for(int i=1;i<dp.length;i++)
        {
            for(int j=0;j<dp[i].length;j++)
            {
                if(j==nums[i])
                {
                    dp[i][j]=1;

                }

                if(dp[i-1][j]==1)
                {
                    dp[i][j]=1;
                    if(nums[i]+j<=target)
                    {
                        dp[i][nums[i]+j]=1;
                        if(nums[i]+j==target)
                        {
                            answer=true;
                            return answer;
                        }

                    }
                }
            }
        }
        return answer;
    }
}
