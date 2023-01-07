// at any point check the  right or bottom, after checking return
// keep track of all paths from source to destination
// and find and return the minimum.
class MinPathSum {
    //at each square take a decision to go right or down
    public int minPathSum(int[][] grid) {
        findPathSum(grid,0,0,0,0, Integer.MAX_VALUE);
        return 0;
    }

    void findPathSum(int[][] grid, int i, int j, int sum, int k, int minvalue)

    {

        sum = sum+grid[i][j];
        System.out.println("grid value= "+grid[i][j]);

        if((i==(grid.length-1))&&(j==(grid[0].length-1)))//1
        {
            System.out.println("sum= "+sum);
            if(sum<minvalue)
            {
                minvalue=sum;
            }
        }
        else if((i<grid.length-1)&&(j<grid[0].length-1))//
        {

            findPathSum(grid,(i+1),j,sum,k,minvalue);//1

            findPathSum(grid,i,(j+1),sum,k,minvalue);
        }
        else if((i==grid.length-1)&&(j<grid[0].length-1)) //4 5 6
        {
            findPathSum(grid,i,(j+1),sum,k,minvalue);
        }

        else if((i<grid.length-1)&&(j==grid[0].length-1))
        {
            findPathSum(grid,(i+1),j,sum,k,minvalue);
        }

        sum = sum - grid[i][j];

    }
//return minvalue;
}