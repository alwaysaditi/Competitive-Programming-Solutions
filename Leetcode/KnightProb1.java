// knight probability : dp 

class Solution {
    double dp[][][];
    int dimension;
    public double knightProbability(int n, int k, int row, int column) {
        dp = new double[k+1][n][n];
        dp[0][row][column]=1.0;
        dimension =n;
for(int r=1;r<=k;r++)
{
    //System.out.println("r= "+r);
 for(int i=0;i<n;i++)
        {
            for(int j =0;j<n;j++)
            {
                double count = 0.0;

                if((i-2>=0)&&(j-1>=0))
    {
count = count + dp[r-1][i-2][j-1]/8.0;
    }

    if((i-2>=0)&&(j+1<=dimension-1))
    {
        count = count + dp[r-1][i-2][j+1]/8.0 ;
    }

    if((i+2<=dimension-1)&&(j-1>=0))
    {
        count = count + dp[r-1][i+2][j-1]/8.0;
    }
    if((i+2<=dimension-1)&&(j+1<=dimension-1))
    {
   count = count + dp[r-1][i+2][j+1]/8.0;
    }
    if((i-1>=0)&&(j+2<=dimension-1))
    {
        count = count + dp[r-1][i-1][j+2]/8.0;
    }
    if((i-1>=0)&&(j-2>=0))
    {
       count = count + dp[r-1][i-1][j-2]/8.0;
    }
    if((i+1<=dimension-1)&&(j-2>=0))
    {
        count = count + dp[r-1][i+1][j-2]/8.0;
    }
    if((i+1<=dimension-1)&&(j+2<=dimension-1))
    {
       count = count + dp[r-1][i+1][j+2]/8.0;
    }
dp[r][i][j] = count;

            }
        }
}
   // int finalcount =0;
    double answer =0.0;

    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            answer = answer+dp[k][i][j];
        }
    } 

  

    return answer; 
    }
}
