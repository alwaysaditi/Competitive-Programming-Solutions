class RotateFunction{
    public int maxRotateFunction(int[] nums) {
        int insum=0;
        int tsum=0;
        int last=nums.length-1;
        int maxsum =0;
        int n= nums.length;
        for(int i=0;i<nums.length;i++)
        {
            insum = insum+i*nums[i];
            tsum = tsum+nums[i];
        }
        maxsum = insum;
        
       // System.out.println(insum);
        for(int i=1;i<=n-1;i++)// n-1 times
        {
insum = insum+ tsum - (n)*nums[last];
//System.out.println(" last "+(n)*nums[last]);
//System.out.println(insum);
last--;
if(insum>maxsum)
{
    maxsum = insum;
}
        }
        return maxsum;
    }
}
