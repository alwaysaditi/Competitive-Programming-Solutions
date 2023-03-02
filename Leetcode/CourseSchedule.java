package Leetcode;

import java.util.Arrays;

class CourseSchedule {
    //The approach is to solve this problem with DFS and topological sort.
    // In topological sort, all the elements which are parents of a child (i.e child is dependent on the parent ) are marked visited.
    //
    //We recursively check if there are any parent-child conflicts using DFS.
    //
    //To save up time , we only check those rows of the adjacency matrix which are present in the prerequisites array and skip checking a row if the element corresponding to that row has already been marked as visited.
    //
    //If a child is waiting for it's parent , we mark it as waiting.
    public boolean [] waiting;
    public boolean [] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        waiting = new boolean[numCourses];
        visited = new boolean[numCourses];
        boolean[][]arr = new boolean[numCourses][numCourses];
        Arrays.fill(waiting,false);
        Arrays.fill(visited,false);
        boolean flag=true;
        for(int i=0;i<numCourses;i++)
        {
            Arrays.fill(arr[i],false);
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            int col= prerequisites[i][0];
            int row = prerequisites[i][1];
            arr[row][col]=true;

        }

        boolean finalflag=true;
        for(int i=0;i<prerequisites.length;i++)
        {
            if(visited[prerequisites[i][1]]==true)
            {
                continue;
            }

            finalflag =DFS(prerequisites[i][1],arr,true,visited,waiting);
            if(finalflag==false)
            {
                return finalflag;
            }
            System.out.println("i= "+i+" visited= "+visited[i]);
        }
        System.out.println("flag here= "+flag);
        return finalflag;
    }
    boolean DFS(int row, boolean[][]matrix, boolean flag, boolean[] visited, boolean[]waiting)
    {// System.out.println("row= "+row);
        waiting[row]=true;
        int i = row;
        for(int j=0;j<matrix[i].length;j++)
        {
            if(matrix[i][j]==true)
            {
                if(waiting[j]==true)
                {
                    System.out.println("yes!");
                    return false;
                    //capture the return value and pass it onto the object previously on stack.
                }

                if(visited[j]==true)
                {
                    visited[i]=true;
                    System.out.println("we visited node "+i);
                }
                if(visited[j]==false)
                {
                    visited[i]=DFS(j,matrix,flag,visited,waiting);
                    if(visited[i]==false)
                    {
                        return visited[i];
                    }
                    //System.out.println("i= "+i+" visited= "+visited[i]);

                }
            }
            matrix[i][j]=false;
        }
        visited[i]=true;
        waiting[i]=false;
        return visited[i];
    }
}