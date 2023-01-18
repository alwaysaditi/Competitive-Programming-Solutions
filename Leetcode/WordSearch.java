// Leetcode 79: Uses backtracking and a visited array to ensure that array is visited

class WordSearch {
    boolean ansfinal=false;
    public boolean exist(char[][] board, String word) {
        boolean answer=false;
        int size = board.length*board[0].length;
        boolean [][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
        {
            Arrays.fill(visited[i],false);
        }
        if(size<word.length())
        {
            return false;
        }
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    visited[i][j]=true;
                    DFS(0,word,board, i,j,visited);
                    if(ansfinal==true)
                    {
                        return ansfinal;
                    }
                }
            }
        }
        return false;
    }

    void DFS(int ptr, String word, char[][]board, int i, int j, boolean[][]visited)
    {
        //System.out.println(board[i][j]+" i= "+i+" j= "+j);
        if((ptr==word.length()-1)&&(board[i][j]==word.charAt(ptr)))
        {
            ansfinal = true;
            System.out.println("reached!");
            return;
        }

        //System.out.println("satisfies! ptr= "+ptr);
        // after a recursive call returns , ptr will stay in the same position as before
        // you're not allowed to visit the same box twice even if it is not the previously visited box'
        if(j<board[i].length-1)
        {
            if(board[i][j+1]==word.charAt(ptr+1)&&(visited[i][j+1]==false))
            {
                visited[i][j+1]=true;
                DFS((ptr+1),word,board,(i),(j+1),visited);
            }

        }
        if(i<board.length-1)
        {
            if(board[i+1][j]==word.charAt(ptr+1)&&(visited[i+1][j]==false))
            {
                visited[i+1][j]=true;
                DFS((ptr+1),word,board,(i+1),j,visited);
            }

        }

        if((i>0)&&(board[i-1][j]==word.charAt(ptr+1))&&(visited[i-1][j]==false))
        {
            visited[i-1][j]=true;
            DFS((ptr+1),word,board,(i-1),j,visited);
        }

        if((j>0)&&(board[i][j-1]==word.charAt(ptr+1))&&(visited[i][j-1]==false))
        {
            visited[i][j-1]=true;
            DFS((ptr+1),word,board,i,(j-1),visited);
        }

        visited[i][j]=false;

//return ansfinal;
    }
}