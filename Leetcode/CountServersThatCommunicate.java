package Leetcode;

import java.util.Arrays;
// done using dfs , but coulldve been done using a MUCH simpler solution :(
public class CountServersThatCommunicate {
    int finalgrid [][];
    int count ;
    int iterationCount;
    boolean check[][];
    public int countServers(int[][] grid) {
        finalgrid = grid;
        boolean is [] = new boolean[grid.length];
        boolean js [] = new boolean[grid[0].length];
        Arrays.fill(is,false);
        Arrays.fill(js,false);
        for(int i=0;i<finalgrid.length;i++)
        {
            int rowCount=0;
            for(int j=0;j<finalgrid[i].length;j++)
            {
                if(finalgrid[i][j]==1)
                {
                    rowCount++;
                }
            }
            if(rowCount>1)
            {
                is[i]=true;
            }
        }
        for(int i=0;i<finalgrid[0].length;i++)
        {
            int rowCount=0;
            for(int j=0;j<finalgrid.length;j++)
            {
                if(finalgrid[j][i]==1)
                {
                    rowCount++;
                }
            }
            if(rowCount>1)
            {
                js[i]=true;
            }
        }      for(int i=0; i<finalgrid.length; i++)
        {
            for(int j=0;j<finalgrid[i].length;j++)
            {

                //int tempcount = count;
                if(finalgrid[i][j]==1)
                {



                    //System.out.println("tempcount= "+tempcount+" count= "+count);

                    iterationCount =0;
                    Search(i,j);
                    System.out.println("iterationcount= "+iterationCount);
                    if(iterationCount>1)
                    {
                        System.out.println("yep");
                        count = count+iterationCount;
                    }

                    else if((js[j]==true)||(is[i]==true))
                    {
                        System.out.println("is i= "+is[i]+" js j= "+js[j]);
                        count = count+1;
                    }
                    finalgrid[i][j]=0;
                    System.out.println("count= "+count);
                }

            }
        }
        return count;
    }

    void Search (int sRow, int sCol)
    {

        if(finalgrid[sRow][sCol]==1)
        {
            finalgrid[sRow][sCol]=0;
            iterationCount++;
            if((sRow<finalgrid.length-1))
            {
                System.out.println("yes srow ="+sRow);
                Search((sRow+1),sCol);
            }
            if((sCol<finalgrid[0].length-1))
            {
                System.out.println("yes scol ="+sCol);
                Search(sRow,(sCol+1));
            }



        }
//System.out.println("here count= "+count);


    }
}
