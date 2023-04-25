// java DP with 2D matrix
class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int [][]answer= new int[mat.length][mat[0].length];
        for(int k=0;k<answer.length;k++)
        {
            Arrays.fill(answer[k],Integer.MAX_VALUE);
        }
        for(int i=0;i<answer.length;i++)
        {
            for(int k=0;k<answer[i].length;k++ )
            {
                if(mat[i][k]==0)
                {
                    answer[i][k]=0;
                    continue;
                }
                else
                {
                    if((i>0)&&(k>0))
                    {
                        if(!((answer[i-1][k]==Integer.MAX_VALUE)&&(answer[i][k-1]==Integer.MAX_VALUE)))
                        {

                        answer[i][k]=Math.min(answer[i-1][k],answer[i][k-1])+1;
                        }

            
                    
                    }
                  else  if((i>0)&&(k==0))
                    {
                      //  System.out.println("here1");
          if(answer[i-1][k]<Integer.MAX_VALUE)
          {     
            //  System.out.println("i= "+i+" k= "+k+" val= "+answer[i-1][k]);
answer[i][k]=answer[i-1][k]+1;
          }
   }
               else  if((i==0)&&(k>0))
                    {
              if(answer[i][k-1]<Integer.MAX_VALUE)
              {
//System.out.println("i= "+i+" k= "+k+" val= "+answer[i][k-1]);
              
                        answer[i][k]=answer[i][k-1]+1;
              }
                    }
                    else continue;
                }

            }
        }
        for(int i=0;i<answer.length;i++)
        {
            for(int j=0;j<answer[i].length;j++)
            {
                System.out.print(answer[i][j]+" ");
            }
            System.out.println("");
        }
        
        for(int i=answer.length-1;i>=0;i--)
        {
            for(int j=answer[i].length-1;j>=0;j--)
            {
                if(mat[i][j]!=0)
                {
if((i<answer.length-1)&&(j<answer[i].length-1))
{
    answer[i][j]= Math.min(answer[i][j],(Math.min(answer[i+1][j],answer[i][j+1])+1));
}
else if((i==answer.length-1)&&(j<answer[i].length-1))
{
    answer[i][j]=Math.min(answer[i][j],(answer[i][j+1]+1));
}
else if((i<answer.length-1)&&(j==answer[i].length-1))
{
    answer[i][j]=Math.min(answer[i][j],(answer[i+1][j]+1));
}
else continue;
                }
                else continue;
            }
        }
        return answer;
    }
}
