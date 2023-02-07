package Leetcode;

import java.util.Arrays;
// Java Dynamic Programming
// a backtracking solution tries all possible paths.
// Once it backtracks and reaches an index ,it explores other unexplroed options from that index
// during this exploration , it goes right down to the end , which might lead to recomputation
// of some cells again
// hence in order to avoid that , we start iterating from the bottom of the array and store the minimum path to reach the end from any cell
// dp[i][j] represents the minimum path value from grid[i][j] to the bottom.
// hence dp[0][0] represents the minimum path value from the start of the matrix to the end

class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;// no of rows
        int n= grid[0].length;
        int [][]dp = new int[m+1][n+1];
        for(int i=0;i<(m+1);i++)
        {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        dp[m-1][n-1]= grid[m-1][n-1];

        dp[m][n-1]=0;
        dp[m-1][n]=0;
        dp[m][n]=0;

        for(int i=(m-1);i>=0;i--)
        {
            for(int j=(n-1);j>=0;j--)
            {
                if(dp[i][j]<Integer.MAX_VALUE)
                {
                    continue;
                }
                else
                {
                    dp[i][j] = Math.min(dp[i][j+1],dp[i+1][j])+grid[i][j];
                }
            }
        }
        return dp[0][0];
    }
}
