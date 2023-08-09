class Solution {
    boolean visited[];
   
   int[] answer;
   int index =0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    visited = new boolean[numCourses];
    boolean matrix [][] = new boolean[numCourses][numCourses];
    answer = new int[numCourses];
for(int i=0;i<prerequisites.length;i++)
    {
int row = prerequisites [i][0];
int col = prerequisites [i][1];

   matrix[row][col]=true; 
   
   }

for(int i=0;i<visited.length;i++)
{
    if(!visited[i])
    {
        boolean [] temp = new boolean[numCourses];
       boolean ans= recursive(i,matrix,temp);
       if(ans == false)
       {
           answer = new int[0];
           break;
       }

    }
}

return answer;

    }

    boolean recursive(int node, boolean[][]matrix,boolean[]temp)
    {
        boolean val=true;
        temp[node]=true;
       // visited[node]=true;
        //System.out.println(node);
  for(int i=0;i<matrix[0].length;i++)
        {
 if((matrix[node][i])&&(!visited[i]))
            {
               // System.out.println("i= "+i);
      if(temp[i])
                {
           // you have visited a node only when u travel all of its neighbours hence visited is at the end    
         //  System.out.println("here")   ;
val = false;
return val;
                }      
  val=  recursive(i,matrix,temp);
  if(val==false)
  {
      return val;
  }
            }

            

            
            
        }
answer[index]=node;

index++;
        visited[node]=true;
        return val;
    }
}
