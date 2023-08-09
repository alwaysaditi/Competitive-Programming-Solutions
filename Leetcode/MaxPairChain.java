// max length of pair chain

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b)-> Integer.compare(a[0],b[0]));
        int maxlength =0;
        int dp[]= new int[pairs.length];
        for(int i=0;i<pairs.length;i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                if(pairs[j][1]<pairs[i][0])
                {
dp[i] = dp[j]+1;
break;
                }
                
            }
            dp[i] = Math.max(dp[i],1);
 maxlength = Math.max(maxlength,dp[i]);
        }
        //return 0;
        return maxlength;
    }
}
