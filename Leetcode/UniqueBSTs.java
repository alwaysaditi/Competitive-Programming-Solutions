// dynamic programming. : whole lot of it!

class Solution {
    public int numTrees(int n) {
        int [][] dp = new int[n+1][n+1];
          if(n==1)
        {
            return 1;
        }
        
        dp[1][1] = dp[2][1] = dp[2][2] =1;
        
        int prevsum =2;
        
      
        
        if(n==2)
        {
            return 2;
        }
        for(int i=3; i<=n;i++)
        {
            dp[i][1] = dp[i][2] = prevsum;
            
            prevsum = 0;
            prevsum = 2*dp[i][1];
            for(int j=3;j<=n;j++)
            {
                dp[i][j] = dp[i][j-1] - dp[i-1][j-2];
                
                prevsum = prevsum + dp[i][j];
            }
        }
        
        return prevsum;
    }
}
