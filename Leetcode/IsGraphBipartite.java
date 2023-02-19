package Leetcode;

class IsGraphBiPartite {
 // basically a graph coloring problem. Basically you're supposed to color the graph , with adjacent nodes having alternate colors.
    // if such a coloring is not possible return false
    // can be solved easily using DFS
    // BiPartite : can be divided into two partitions having different colors
    // sometimes , there might be multiple individual connected components on their own
 // and you're supposed to do DFS on those components individally
    // for that keep track of the number of nodes visited and do DFS until all components have been visited
// Runtime beats 48.41% memory beats 95.28%
    boolean blacklisted[];
    boolean visited[];
    boolean [][] matrix;
    boolean result = true;
    int highestvisited =0;
    public boolean isBipartite(int[][] graph) {
        if((graph.length==1)&&((graph[0].length==0)))
        {
            return true;
        }

        blacklisted = new boolean[graph.length];
        visited = new boolean[graph.length];
        matrix = new boolean[graph.length][graph.length];
        for(int i=0;i<graph.length;i++)
        {
            blacklisted[i]=false;
            visited[i] = false;
            matrix[i][i]=true;
            for(int j=0;j<graph[i].length;j++)
            {
                matrix[i][graph[i][j]] = true;
            }
        }


        for(int i=0;i<graph.length;i++)
        {
            if(graph[i].length==graph.length-1)
            {
                return false;
            }
            if(graph[i].length>0)
            {
                DFS(i);
                break;
            }
        }
        while(highestvisited!=(graph.length-1))
        {
            DFS(highestvisited+1);
        }





        return result;
    }

    void DFS (int index)
    { // mark all neighbours with alternate index as compared to the parent
        // if the node is already visited and you have to change its blacklist return false
        if(index>highestvisited)
        {
            highestvisited = index;
        }
        visited[index]=true;
        boolean value = blacklisted[index];
        for(int j=0;j<matrix[index].length;j++)
        {
            if ((matrix[index][j]==true)&&(j!=index))// if its a neighbour
            {
                if(visited[j]==false)
                {
                    if(value==true)
                    {
                        blacklisted[j]=false;
                    }
                    else {blacklisted[j]=true;}
                    DFS(j);
                }
                else // already visited
                {

                    if(j!=index)
                    {
                        if(((value==false)&&(blacklisted[j]==false))||((value==true)&&(blacklisted[j]==true))) // if you have to change it and it's already visited'
                        {
                            result = false;
                            return;
                        }
                    }

                }
            }

        }
    }


}

