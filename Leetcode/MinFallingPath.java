// min falling path sum
class MinFallingPath {
    int dp[][];
    boolean visited[][];
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        dp = new int[n][n];
        visited = new boolean[n][n];
         int ans = Integer.MAX_VALUE;
         for(int col=0;col<n;col++)
         {
           ans = Math.min(ans,recursive(n-1,col,matrix));
         }
return ans;
    }
    int recursive (int row, int col, int[][] matrix)
    {
if(row==0)
{
    dp[row][col] = matrix[row][col];
    
}

else
{
    if(!visited[row][col])
    {
       if(col==0)
       {
           int val1,val2;
           val1 = dp[row-1][col]!=0?dp[row-1][col]:recursive(row-1,col,matrix);
           val2 = dp[row-1][col+1]!=0?dp[row-1][col+1]:recursive(row-1,col+1,matrix);

           dp[row][col] = Math.min(val1,val2)+matrix[row][col];
       } 

       else if (col==matrix.length-1)
       {
           int val1,val2;
           val1 = dp[row-1][col]!=0?dp[row-1][col]:recursive(row-1,col,matrix);
           val2 = dp[row-1][col-1]!=0?dp[row-1][col-1]:recursive(row-1,col-1,matrix);

           dp[row][col] = Math.min(val1,val2)+matrix[row][col];
       }

       else
       {
           int val1,val2,val3;
           val1 = dp[row-1][col]!=0?dp[row-1][col]:recursive(row-1,col,matrix);
           val2 = dp[row-1][col-1]!=0?dp[row-1][col-1]:recursive(row-1,col-1,matrix);
           val3 = dp[row-1][col+1]!=0?dp[row-1][col+1]:recursive(row-1,col+1,matrix);
           val1 = Math.min(val1,val2);
           dp[row][col] = Math.min(val1,val3)+matrix[row][col];
       }
    }
}

visited[row][col] = true;


return dp[row][col];
    }
}
