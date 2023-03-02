class MaxProdSubarray {
    public int maxProduct(int[] nums) {
        int maximum[] = new int[nums.length];
        int minimum[] = new int[nums.length];
// i think , for every index , we have two choices, either to include it , or to not include it
// keeping the minimum or maximum at any index is necessary as it 
// leads to the magnitude determination, which may even turn out to be positive for psoitve and negative for negative
// sometimes, even though including or not including an element may lead to a local minimum
// it can even cause a global maximum
// maybe this problem can be avoided by keeping two arrays? one that keeps the maxmimum and another keeping the minimum
       maximum[0] = nums[0];
       minimum[0] = nums[0];
       int max_product = Integer.MIN_VALUE;
        //int maxproduct = Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++)
        {
           int prod1 = nums[i]*maximum[i-1];
           int prod2 = nums[i]*minimum[i-1];
           int prod3 = nums[i];
           int minvalue = Math.min(prod1,prod2);
           minvalue = Math.min(minvalue,prod3);
            int maxvalue = Math.max(prod1,prod2);
           maxvalue = Math.max(maxvalue,prod3);
           minimum[i]=minvalue;
           maximum[i]=maxvalue;
        }
        for(int i=0;i<maximum.length;i++)
        {
            if(maximum[i]>max_product)
            {
                max_product = maximum[i];
            }
        }
        return max_product;
    }
}
