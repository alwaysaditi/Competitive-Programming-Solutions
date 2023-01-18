// java simulation 

class Solution {
    int right_col;
    int left_col;
    int upper_row;
    int lower_row;
    public List<Integer> spiralOrder(int[][] matrix) {
        boolean flag =false;
        List<Integer> answer =new ArrayList<Integer>();
        right_col = matrix[0].length;
        left_col=0;
        upper_row= 0;
        lower_row = matrix.length;
      int total_ele = matrix.length*matrix[0].length;
      int elements =0;
      while(elements!=total_ele)
      {
          for(int i=left_col;i<right_col;i++)
          {
              
answer.add(matrix[upper_row][i]);
System.out.println(matrix[upper_row][i]);
elements++;
if(elements==total_ele)
{
    flag =true;
    break;
}
          }
          upper_row++;//upper row=1
          //1 2
         if(flag==true)
         {
             break;
         }

          for(int j=upper_row;j<lower_row;j++)
          {
              answer.add(matrix[j][right_col-1]);
              System.out.println(matrix[j][right_col-1]);
              elements++;
              if(elements==total_ele)
              {
                  flag=true;
                  break;
              }
          }
          right_col--;
          //right col=2
          if(flag==true)
          {
              break;
          }
          for(int k=right_col-1;k>=left_col;k--)
{
    System.out.println(matrix[lower_row-1][k]);
    answer.add(matrix[lower_row-1][k]);
    elements++;
    if(elements==total_ele)
    {
        flag =true;
        break;
    }
}
lower_row--;//lower row=2
if(flag==true)
{
    break;
}

for(int l=lower_row-1;l>=upper_row;l--)
{
    System.out.println(matrix[l][left_col]);
    answer.add(matrix[l][left_col]);
    elements++;
    if(elements==total_ele)
    {
        flag=true;
        break;
    }
}
left_col++;
    if(flag==true)  
    {
        break;
    }}  
      return answer;
    }
}
