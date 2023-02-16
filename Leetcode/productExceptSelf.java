class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int lp[]=new int[nums.length];
        int rp[]=new int[nums.length];
        lp[0]=1;
        rp[rp.length-1]=1;
        int l=0;
        int r=nums.length-2;
        if(nums.length==2)
        {
          int  temp=nums[0];
            nums[0]=nums[1];
            nums[1]=temp;
            return nums;
        }
        for(l=1;l<nums.length;l++)
        {
lp[l]=lp[l-1]*nums[l-1];
rp[r]=rp[r+1]*nums[r+1];
r--;
        }
        int answer[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
answer[i]=lp[i]*rp[i];
        }
return answer;
    }
}
