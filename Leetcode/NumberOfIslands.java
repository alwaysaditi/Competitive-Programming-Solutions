class NumberOfIslands {

    //probably one of the most important things that I realized while writing this code was that ,
    // whenever there's a recursive call , always use if conditionals only
    // Do not use else if or the recursive call won't get executed when the stack is being popped off.
    public int numIslands(char[][] grid) {
        int count=0;
        for(int row=0;row<grid.length;row++)
        {
            for(int col=0;col<grid[row].length;col++)
            {
                System.out.print(grid[row][col]);
            }
            System.out.println("");
        }
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length; j++)
            {
                if(grid[i][j]=='1')
                {

                    grid=  DFS(grid,i,j);
                    System.out.println("count increased!");
                    count++;
                }
                else continue;
            }
        }
        return count;

    }
    char[][] DFS(char[][]grid, int i, int j)
    {
        grid[i][j]='0';
        System.out.println("i= "+i+" j= "+j);


        if ((i>0)&&(grid[i-1][j]=='1'))
        {
            System.out.println("c3");
//grid[i-1][j]='0';
            DFS(grid,(i-1),j);
        }
        if((i<grid.length-1)&&(grid[i+1][j]=='1'))
        {
            System.out.println("c4");
            // grid[i+1][j]='0';
            DFS(grid,(i+1),j);
        }
        if((j>0)&&(grid[i][j-1]=='1'))
        {
            System.out.println("c1");
//grid[i][j-1]='0';
            DFS(grid,i,j-1);
        }
        if ((j<grid[i].length-1)&&(grid[i][j+1]=='1'))
        {
            System.out.println("c2");
            //grid[i][j+1]='0';
            DFS(grid,i,j+1);
        }
        System.out.println("printing array from function");

        return grid;


    }

}