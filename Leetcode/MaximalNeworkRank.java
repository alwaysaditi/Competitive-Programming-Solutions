package Leetcode;
// leetcode 1615 : graphs
public class MaximalNeworkRank {

        public int maximalNetworkRank(int n, int[][] roads) {
            int [][] network = new int[n][n+1];
            int first = 0;
            int second =0;
            int fnode=0;
            int snode=0;
            for(int i=0;i<roads.length;i++)
            {
                int u = roads[i][0];
                int v = roads [i][1];
                network[u][v]=1;
                network[v][u]=1;
                network[u][n]++;
                network[v][n]++;



            }
            int total=0;
            for(int i=0;i<n-1;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    int subtracted = network[i][j];
                    if(network[i][n]+network[j][n]-subtracted>total)
                    {
                        total = network[i][n]+network[j][n]-subtracted;
                    }
                }
            }
            // if(network[fnode][snode]==1)
            {
                //System.out.println("yes fnode= "+fnode+"score= "+network[fnode] [n]+"snode= "+snode+" score = "+network[snode][n])
            }
            return total;
        }
    }

