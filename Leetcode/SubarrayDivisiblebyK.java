package Leetcode;
// prefix sum  and hashtable with a little bit of DP and number theory

// idea is that, the sum from i to j will be divisible by k if prefix sum at j and prefix sum at
//i leave the same remainder when divided by k
class SubarrayDivisiblebyK {
    public int subarraysDivByK(int[] nums, int k) {
        int remainders[]= new int[k];
        if(nums.length==1)
        {
            if(nums[0]%k==0)
            {
                return 1;
            }
            else return 0;
        }
        int sum=0;
        int count=0;
        remainders[0]=1;
        int rem;
        for(int i=0;i<nums.length;i++)
        {
            sum =(sum+nums[i]);
            rem = sum%k;
            if(rem<0)
            {
                rem = k+rem;
            }
            count = count+remainders[rem];
            remainders[rem]++;
        }
        return count;
    }
}
