package Leetcode;

import java.util.Arrays;

class ExistPath {

    //We follow the concept of parent-child. By path compression , we have only one parent for any
    // given node and hence the maximum rank allowed is one. If we find two elements having the same
    // rank and they both dont have a parent then the rank of one of them is increased. Else if both
    // the elements have a parent then the element that doesn't have a parent is made the child of
    // the parent of the element that has the parent.
    //Else if both have a parent, then the parent of one of the elements is made the child of the
    // element of the parent of the other element.
    //However , if two elements have a different rank, then precedence is always given to the
    // element with a higher rank.
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int setrep[]=new int[n];
        int src;
        int dst;
        int rank[]= new int[n];
        Arrays.fill(rank,0);
        for(int i=0;i<n;i++)
        {
            setrep[i]=i;
        }
        for(int i=0;i<edges.length;i++)
        {
            src=0;
            dst=0;
            // int a= findPrecedence(rank,edges[i][0],edges[i][1]);
            int a = 0;
            int b=0;
            if(rank[edges[i][0]]>rank[edges[i][1]])
            {
                a = 0;
                b=1;
            }
            else if(rank[edges[i][0]]==rank[edges[i][1]])
            {
                if((setrep[edges[i][0]]!=edges[i][0])&&(setrep[edges[i][1]]!=edges[i][1]))
                {
                    a=0;b=1;
                }
                else if((setrep[edges[i][0]]!=edges[i][0])&&(setrep[edges[i][1]]==edges[i][1]))
                {
                    a=0;b=1;
                }
                else if((setrep[edges[i][1]]!=edges[i][1])&&(setrep[edges[i][0]]==edges[i][0]))
                {
                    a=1;b=0;
                }
                else
                {
                    a=0;b=1;
                    rank[edges[i][a]]++;
                }
                //rank is increased only when two elements that do not have a parent are joined

            }
            else
            {
                a=1;
                b=0;
            }
            if (setrep[edges[i][a]]!=edges[i][a])
            {
                src = findParent(setrep[edges[i][a]],setrep);

            }
            else
            {
                src=edges[i][a];
            }
            //source = setrep[edge[i][0]];

            dst = findParent(edges[i][b],setrep);
            setrep[dst]=src;
            // System.out.println("rep of "+dst+" ="+src);
        }
        boolean answer = Unionf(source,destination,setrep);
        return answer;
    }


    boolean Unionf(int index1, int index2,int[]setrep)
    {
        int source=-1;
        int destination=-1;
        if(setrep[index1]!=index1)
        {
            source= findParent(index1,setrep);
        }
        else source=index1;
        if (setrep[index2]!=index2)
        {
            destination = findParent(index2,setrep);
        }
        else destination =index2;
        if(source==destination)
        {
            return true;
        }
        return false;
    }

    int findParent(int index,int[]setrep)
    {
        int ans=-1;
        //  System.out.println("parent to be found of "+index);
        while(setrep[index]!=index)
        {
            //findParent(setrep[index],setrep);
            index= setrep[index];
        }
        //System.out.println("ans= "+ans);
        ans=setrep[index];
//System.out.println("ans "+ans);
        return ans;
    }
}