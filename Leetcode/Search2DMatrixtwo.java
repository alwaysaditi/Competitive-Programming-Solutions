class Search2DMatrixtwo {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n-1;
while(true)
{
//System.out.println("i= "+i+" j= "+j+" val= "+matrix[i][j]);

if((i>=m)||(j>=n)||(i<0)||(j<0))
{
    return false;
}

 else if(matrix[i][j]==target)
 {
     return true;
 }

 else if(target>matrix[i][j]) //eliminate row
 {
i++;
 }

 else if(target<matrix[i][j])
 {
     j--;
 }

 //else if((i>=m)||(j>=n))
 {
    // return false;
 }

}
    }

    //int search (int rows, int columns, int target, int[])
    {

    }
}
