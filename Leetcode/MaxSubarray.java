class MaxSubarray {
    public int maxSubArray(int[] nums) {
        // if the max sum upto and including any index is greater than the value at that index, then include it. else the value at that index would just be deprecated by including that sum.

        int dp[]= new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length; i++)
        {
if(nums[i]<(dp[i-1]+nums[i]))
{
    dp[i]= dp[i-1]+nums[i];
}
else if(nums[i]==(dp[i-1]+nums[i]))
{
    if(nums[i]<0)
    {

    
    dp[i]=dp[i-1];
    }
    else dp[i]=nums[i];
}
else
{
    System.out.println(dp[i]);
 dp[i]=nums[i];
}
        }
        int maxvalue = Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++)
        {
            System.out.print(dp[i]);
            if(dp[i]>maxvalue)
            {
                maxvalue = dp[i];
            }
        }
return maxvalue;
    }
}
