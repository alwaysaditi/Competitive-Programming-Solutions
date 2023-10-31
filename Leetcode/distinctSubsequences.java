class distinctSubsequences {
    public int numDistinct(String s, String t) {
        int rows = t.length();
        int columns = s.length();
      int [][] dp = new int[rows][columns];  
      char finalChar = t.charAt(rows-1);
      if(s.charAt(columns-1)==finalChar)
      {
dp[rows-1][columns-1] =1;
      }
      for(int j=s.length()-2;j>=0;j--)
      {
          if(finalChar == s.charAt(j))
          {
              dp[rows-1][j] = dp[rows-1][j+1]+1; 
          }
else
{
    dp[rows-1][j] = dp[rows-1][j+1];  
}
          
      }
   
int startCol = columns-2;
      for(int i = rows-2; i>=0 ; i--)
      {
          for( int j = startCol; j>=0; j--)
          {
if(s.charAt(j)==t.charAt(i))
{
    dp[i][j] = dp[i][j+1]+dp[i+1][j+1];
}

else 
{
    dp[i][j] = dp[i][j+1];
}
          }

          startCol--;
      }
return dp[0][0];

    }
}
