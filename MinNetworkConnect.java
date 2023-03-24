// union find in java

class Solution {
    int [] parent;
    public int makeConnected(int n, int[][] connections) {
        parent= new int[n];
        for(int i=0;i<parent.length;i++)
        {
            parent[i]=i;
        }
        
        int nComponents = n;
        int extraWires = 0;
        for(int i=0;i<connections.length; i++)
        {
            System.out.println(" i= "+i);
            if(findParent(parent,connections[i][0])==findParent(parent,connections[i][1]))
            {
                extraWires++;
                continue;
                //extraWires--;
            }

            else if(findParent(parent,connections[i][0])!= findParent(parent,connections[i][1]))
            {
                int pa = findParent(parent,connections[i][0]);
                int pb = findParent(parent,connections[i][1]);
                if(pa<pb)
                {
                    parent[findParent(parent,connections[i][1])]=pa;
                }

                else 
                {
                    parent[findParent(parent,connections[i][0])]=pb;
                }
                nComponents--;
            }

   System.out.println("components "+nComponents); 
   System.out.println("parent of a = "+connections[i][0]+" is "+parent[connections[i][0]]+" parent of b = "+connections[i][1]+" is "+parent[connections[i][1]]);    }
        System.out.println("components= "+nComponents);
        if(extraWires>=nComponents-1)
        {
return nComponents-1;
        }
        return -1;
    }

    int findParent(int[] parent, int i)
    {
        if(parent[i]==i)
        {
            return i;
        }
        return findParent(parent,parent[i]);
    }
}
