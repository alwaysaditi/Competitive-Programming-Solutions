class RedundantConnection {

    //1. if both don't have parents set the smaller to be the parent of the larger
    //2. if one has parent and one doesn't set the parent of the one that does as the parent of the one that doesnt (indices could be smaller or larger so check both)
    //3. if both have different parents, set the root parent of one to be the root parent of the other
    //4 since the graph is connected , there will always be one global parent
    //5 we encounter a cycle when  we encounter an edge between two nodes where the parent of one node is equal to the parent of the other node.
    int parent[];
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length];
        for(int i=0;i<edges.length;i++)
        {
            parent[i]=i;
        }
        int[] answer = new int[2];
        Arrays.fill(answer,0);
        for(int i=0;i<edges.length;i++)
        {
            if(union((edges[i][0]-1),(edges[i][1]-1),parent)==false)
            {
                return edges[i];
            }
        }
        return answer;
    }

    boolean union(int i, int j,int [] parent) // this function is called only when there's an edge between i and j
    {
        System.out.println("function eneterd with i= "+i+" and j= "+j);
        int a = findParent(i,parent);
        int b = findParent(j,parent);
        if(a!=b)
        {
            System.out.println("enetred here");
            if((parent[i]==i)&&(parent[j]==j))
            {
                if(i>j)
                { parent[i]=j;
                    System.out.println("case1: parent of "+i+" = "+parent[i]);}
                else { parent[j]=i;
                    System.out.println("case2: parent of "+j+" = "+parent[j]);}

            }

            else if ((parent[i]==i)&&(parent[j]!=j))
            {
                System.out.println("case3: entered i= "+i+" j= "+j);
                parent[i] = findParent(j,parent);
                System.out.println("case3: parent of "+i+" = "+parent[i]);
            }

            else if((parent[i]!=i)&&(parent[j]==j))
            {

                System.out.println("case4: entered i= "+i+" j= "+j);
                parent[j] = findParent(i,parent);
                System.out.println("case4: parent of "+j+" = "+parent[j]);
            }
            else //if both their parents are different
            {
                if(i>j)
                {
                    parent[findParent(i,parent)]= findParent(j,parent);
                    System.out.println("case5: i="+i+" j= "+j);
                }
                else
                {
                    parent[findParent(j,parent)]= findParent(i,parent);
                    System.out.println("case6: i="+i+" j= "+j);
                }
            }
            return true;
        }
        else
        {
            System.out.println("hereeeeeeeee");
            return false;
        }
    }

    int findParent(int node, int[] parent)
    {
        System.out.println("node= "+node);
        if(parent[node]==node)
        {
            return node;
        }
        return findParent(parent[node],parent);
    }
}