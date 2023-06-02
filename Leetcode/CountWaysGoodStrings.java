class CountWaysGoodStrings {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int minstart = Math.min(zero,one);
        int count[]= new int[high+1];
        int total =0;
        int mod = 1_000_000_007;
        for(int i=minstart; i<=high; i++)
        {
            if(i-zero>0)
            {
                count[i]=count[i-zero]+count[i];
            }
            else if(i==zero)
            {
                count[i]++;
            }
            if(i-one>0)
            {
                count[i]=count[i-one]+count[i];
            }
            else if(i==one)
            {
                count[i]++;
            }
            count[i]%=mod;
            if(i>=low)
            {
                total = total + count[i];
                total = total%=mod;
            }
            //System.out.println("i= "+i+" count= "+count[i]);
        }
        return total;
    }
}
