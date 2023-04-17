package Leetcode;
// leetcode 1277 : matrix with DP
public class SquareSubmatrices {

        public int countSquares(int[][] matrix) {
            int [][] above = new int[matrix.length][matrix[0].length];
            int [][] left = new int [matrix.length][matrix[0].length];
            int [][] dp = new int[matrix.length][matrix[0].length];
            int count = 0;
            for(int i=0;i<matrix.length;i++)
            {
                for(int j=0;j<matrix[i].length;j++)
                {
                    if(matrix[i][j]==1)
                    {



                        if(i>0&&(j>0))
                        {
                            dp[i][j]= Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                        }
                        else dp[i][j]=1;


                        //int maxSquares = Math.min(above[i][j],left[i][j]);
                        //m

                        count = count + dp[i][j];


// else count++;

                    }
                }
            }
            return count;
        }
    }

