class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] dp = new int[m][n];
        if((m==1)&&(n==1))
        {
            if(matrix[0][0]=='1')
            {
                return 1;
            }

            else 
            {
                return 0;
            }
        }
         int ans = Integer.MIN_VALUE;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]=='0')
                {
                    dp[i][j] =0;
                }

                else
                {
                    //int val =1;
                    int top=0, left = 0,diagonal =0;
                    if(i>0)
                    {
                        top = dp[i-1][j];
                    }

                    if(j>0)
                    {
                        left = dp[i][j-1];
                    }

                    if((i>0)&&(j>0))
                    {
                        diagonal = dp[i-1][j-1];
                    }

                    int val = Math.min(top,left);
                    val = Math.min(val,diagonal);

                    dp[i][j] = val+1;

                    ans = Math.max(ans,dp[i][j]);
                }
            }
        }

        return ans*ans;
    }
}
