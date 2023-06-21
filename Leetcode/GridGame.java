//leetcode 2017: Array, PrefixSum , Matrix 

class GridGame{
    public long gridGame(int[][] grid) {
        long upper = 0;
        long lower =0;

        for(int i=0;i<grid[0].length-1;i++)
        {
            lower = lower + grid[1][i];
        }

        int li = grid[0].length-2;
        int ui = grid[0].length-1;
        //System.out.println("li= "+li+" ui= "+ui);
long globalmin = lower;

        while(li>=0)
        {
            long roundmax =0;
        upper = upper + grid[0][ui];
          lower = lower - grid[1][li];
            li--;
            ui--;
roundmax = Math.max(lower,upper);
//System.out.println("upper= "+upper+" lower = "+lower);
System.out.println("roundmax= "+roundmax);
globalmin = Math.min(globalmin,roundmax);

        }
        return globalmin;
    }
}
