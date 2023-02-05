package Leetcode;
// Sliding Window Technique
class MinSizeSubarray {
    public int minSubArrayLen(int target, int[] nums) {

        int i=0;
        int j=1;
        int min_size = Integer.MAX_VALUE;
        int sum = nums[i];
        if(nums[0]>=target)
        {
            return 1;
        }
        while(j<nums.length)
        {
            if(nums[j]>=target)
            {
                return 1;
            }
            sum = sum+nums[j];
            System.out.println("sum= "+sum);
            //   if(sum==target)
            //   {
            //       if((j-i+1)<min_size)
            //       {
            //           return j-i+1;
            //       }
            //   }
            if(sum>=target)
            {
                while(i<j)
                {
                    if(sum-nums[i]>=target)
                    {
                        sum = sum-nums[i];
                        i++;
                    }

                    else
                    {
                        if((j-i+1)<min_size)
                        {
                            min_size=j-i+1;
                        }
                        break;
                    }



                }
            }
            j++;
        }

        if(min_size==Integer.MAX_VALUE)
        {
            return 0;
        }
        return min_size;
    }
}