//leetcode 2684 array , Dynamic Programming , Matrix 

class MaxMovesGrid {
    public int maxMoves(int[][] grid) {
        int [][] dp = new int[grid.length][grid[0].length];
        int finalmax =0;
        for(int j=grid[0].length-2;j>=0;j--)
        {
            for(int i=0;i<grid.length;i++)
            {
                int maxscore = 0;

                if((i>0)&&(grid[i-1][j+1]>grid[i][j]))
                {
                    //System.out.println("num= "+grid[i][j]+" conditin1");
maxscore = Math.max(maxscore,(dp[i-1][j+1]+1));
                }

          if(grid[i][j+1]>grid[i][j])
                {
                 //   System.out.println("num= "+grid[i][j]+" condition2 ");
                    maxscore = Math.max(maxscore,(dp[i][j+1]+1));
                }

               if((i<grid.length-1)&&(grid[i+1][j+1]>grid[i][j]))
                {
                    //System.out.println("num= "+grid[i][j]+" condition3 ");
maxscore = Math.max(maxscore, (dp[i+1][j+1]+1));
                }
               
                dp[i][j]=maxscore;
            
            }
        }
     // int  maxscore = 0;
    //  for(int i=0;i<dp.length;i++)
      {
          //for(int j=0;j<dp[i].length;j++)
          {
           //   System.out.print(dp[i][j]);
          }
         // System.out.println("");
      }
  for(int i=0;i<dp.length;i++)
  {
      //for(int )
 finalmax  = Math.max(finalmax,(dp[i][0]));
  }
  return finalmax;
  
    }
}
