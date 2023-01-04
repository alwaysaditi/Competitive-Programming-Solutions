//Delete Greatest value in each row

class DeleteGreatest {
    public int deleteGreatestValue(int[][] grid) {
        int sum=0;
        int maxeach=0;
        int maxall = -1;
        int index =0;
        boolean flag=false;
        while(flag==false)
        {
            maxall=-1;
            for(int i=0; i<grid.length;i++)
            {
                index =0; maxeach=0;
                for(int j=0;j<grid[i].length;j++)
                {
                    if(grid[i][j]>maxeach)
                    {
                        maxeach = grid[i][j];
                        index=j;
                    }

                }
                grid[i][index]=0;
                if(maxeach>maxall)
                {
                    maxall=maxeach;
                }
            }
            sum = sum+maxall;
            if(maxall==0)
            {
                flag=true;

            }
            maxall=-1;
        }

        return sum;
    }
}