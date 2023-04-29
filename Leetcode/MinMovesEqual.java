class MinMovesEqual{
    public int minMoves(int[] nums) {
        int lastindex=nums.length-1;
        int diff =0;
        Arrays.sort(nums);
        int steps =0;
        while(lastindex>0)
        {
            diff = nums[lastindex]-nums[0];
            if(diff==0)
            {
                break;
            }
            else
            {
                nums[0]=nums[0]+diff;
                steps = steps + diff;
                nums[lastindex-1]=nums[lastindex-1]+steps;
                lastindex--;
            }
        }
        return steps;
    }
}
