// leetcode 73 : Set Matrix Zeroes: Array , Hashtable , Matrix 

// a better solution was possible and i had thought about it too, just too lazy to code it haha

class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean rows[]=new boolean[matrix.length];
        boolean columns[] = new boolean[matrix[0].length];

        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                    //rows[i]=true;
                    //columns[j]=true;
                }
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if((matrix[i][0]==0)||(matrix[0][j]==0))
                {
matrix[i][j]=0;
                }
            }
        }
    }
}
