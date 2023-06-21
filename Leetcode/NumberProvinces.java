// leetcode 547 : DFS , BFS, UnionFind, Graph

class Solution {
    boolean visited[];
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
      //  boolean visited [] = new boolean[isConnected.length];
 visited = new boolean[isConnected.length];
        for(int i=0;i<isConnected.length;i++)
        {
            if(visited[i]==true)
            {
continue;
            }

            else
            {
                provinces++;
                traverse(isConnected,i);
            }
        }
        return provinces;
        // if you have viisted a provnice u have visited all its neighbours too
    }

void traverse (int [][] isConnected, int k)
{
    visited[k]=true;
for(int i=0;i<isConnected[k].length;i++ )
{
    if((isConnected[k][i]==1)&&(visited[i]==true))
    {
continue;
    }

    else if((isConnected[k][i]==1)&&(visited[i]==false))
    {
        traverse(isConnected,i);

    }
}
}

}
