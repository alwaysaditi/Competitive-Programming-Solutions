class MaximumIceCreamBars.java{
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count =0;
        int k=0;
    
        while((coins!=0)&&(k<costs.length))
        {
            if(costs[k]>coins)
            {
                break;
            }
            else
            {
                coins = coins-costs[k];
                k++;
                count++;
            }
        }
        return count;
    }
}
