class subarraySumequalsK {
    public int subarraySum(int[] nums, int k) {
        int numarrays =0;
        int [] sums = new int[nums.length];

        for(int i=0;i<sums.length;i++)
        {
            for(int j=0;j<=i;j++)
            {
                sums[j]= sums[j]+nums[i];
                if(sums[j]==k)
                {
                    numarrays++;
                }
            }
        }

        return numarrays;

    }
}
