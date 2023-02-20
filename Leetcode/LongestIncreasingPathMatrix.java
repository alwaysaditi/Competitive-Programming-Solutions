// In this we use a DP matrix to store the longest path from  any index.
// We visit other neighbours by DFS if the longest path is not already found
// neighbours will never get caught in a cycle since we only visit neighbours if they're strictly
//greater

class LongestIncreasingPathMatrix{
    int dp[][];
    public int longestIncreasingPath(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
        {
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }
        int longest_path = Integer.MIN_VALUE;
for(int i=0;i<matrix.length;i++)
{
    for(int j=0;j<matrix[i].length;j++)
    {
        if(dp[i][j]>Integer.MIN_VALUE)
        {
            if(dp[i][j]>longest_path)
            {
                longest_path = dp[i][j];
            }
            continue;
        }
        else
        {
           int val= recursive(matrix,i,j);
           if(val>longest_path)
           {
               longest_path=val;
           }
        }
    }
}
for(int i=0;i<dp.length;i++)
{
    for(int j=0;j<dp[i].length;j++)
    {
        System.out.print(dp[i][j]);
    }
    System.out.println(" ");
}

    return longest_path;
    }

   int recursive(int[][] matrix, int row, int col)
    {
// if the neighbour value is greater and its unvisited then visit the neighbour
// if its lesser and unvisited then dont visit it
int temp=1; // if nothing is assigned to it by DFS, then eventually one will be assigned . meaning that there exists no square whose value in matrix is greater 
if((row<matrix.length-1)&&(matrix[row+1][col]>matrix[row][col]))// validity of path and validity of increasing path
{
if(dp[row+1][col]>Integer.MIN_VALUE) // its longest path has been found
{
if(dp[row+1][col]+1>temp)
{
    temp = dp[row+1][col]+1;
}
}
else // longest path of neighbour not yet found
{

 int val1 = recursive(matrix,(row+1),col)+1;
 if(val1>temp)
 {
     temp=val1;
 }
} 
}

if((col<matrix[0].length-1)&&(matrix[row][col+1]>matrix[row][col]))
{
    if(dp[row][col+1]>Integer.MIN_VALUE)
    {
        if(dp[row][col+1]+1>temp)
        {
            temp = dp[row][col+1]+1;
        }
    }
    else 
    
    {
 int val2 = recursive(matrix,(row),(col+1))+1;
 if(val2>temp)
 {
     temp=val2;
 }
    }
}

if((row>0)&&(matrix[row-1][col]>matrix[row][col]))
{
if(dp[row-1][col]>Integer.MIN_VALUE) // its longest path has been found
{
if(dp[row-1][col]+1>temp)
{
    System.out.println("temp= "+temp+" dp row above = "+(dp[row-1][col]+1));
    temp = dp[row-1][col]+1;
}
}
else 

{
    
 int val3 = recursive(matrix,(row-1),col)+1;
 if(val3>temp)
 {
     temp=val3;
 }
}
}

if((col>0)&&(matrix[row][col-1]>matrix[row][col]))
{
  if(dp[row][col-1]>Integer.MIN_VALUE) // its longest path has been found
{
if(dp[row][col-1]+1>temp)
{
     System.out.println("temp= "+temp+" dp col left= "+(dp[row][col-1]+1));
    temp = dp[row][col-1]+1;
}
}
else

{
int val4= recursive(matrix,(row),col-1)+1;
if(val4>temp)
{
    temp=val4;
}
}   
}

dp[row][col]=temp;
  return temp;  }
}
