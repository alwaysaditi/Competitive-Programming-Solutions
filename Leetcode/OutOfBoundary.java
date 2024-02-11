// out of boundary paths
class OutOfBoundary {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(startRow<0 || startColumn<0 || startRow>=m  || startColumn>=n || maxMove==0) return 0;
       final int M = 1000000000 + 7;
       int count = 0;
       long[][][] dp = new long[m][n][maxMove];
       if((m==1)&&(n==1)&&(maxMove%2!=0)) return 4;
       dp[0][0][0] = dp[0][n-1][0]=dp[m-1][n-1][0]=dp[m-1][0][0]=2;
       if((m==1)||(n==1))
       {
dp[0][0][0] = dp[0][n-1][0]=dp[m-1][n-1][0]=dp[m-1][0][0]=3;
       }
       for(int i=1;i<n-1;i++) // filling columns
       {
           dp[0][i][0]=1;
           dp[m-1][i][0]=1;

           if(m==1)
           {
                dp[0][i][0]=2;
           dp[m-1][i][0]=2;
           }
       } 

       for(int j=1;j<m-1;j++)
       {
           dp[j][0][0] =1;
           dp[j][n-1][0]=1;
           if(n==1)
           {
              dp[j][0][0] =2;
           dp[j][n-1][0]=2;   
           }
       }

       long ans =0;
       ans = dp[startRow][startColumn][0];
for(int move=1;move<=maxMove-1;move++)
{

for(int i=0; i<m; i++)
{
    for(int j=0;j<n;j++)
    {
        long up = (i-1>=0)? dp[i-1][j][move-1]:0;
        long down = (i+1<m)? dp[i+1][j][move-1]:0;
        long left = (j-1>=0)? dp[i][j-1][move-1]:0;
        long right = (j+1<n)? dp[i][j+1][move-1]:0;

        dp[i][j][move] = (up+down+left+right)%M;
    }
}


ans = (dp[startRow][startColumn][move]+ans)%M;

}

  return (int)ans;    

    }
}
