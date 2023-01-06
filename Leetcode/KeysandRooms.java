// graph problem using DFS
class KeysandRooms {
    boolean visited[];
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[][] matrix = new boolean[rooms.size()][rooms.size()];
        visited= new boolean[rooms.size()];
        for(int i=0;i<matrix.length;i++)
        {
            Arrays.fill(matrix[i],false);
            Arrays.fill(visited,false);
        }
        int count=0;
        for(List<Integer> l1: rooms)
        {

            for(Integer j: l1 )
            {
                matrix[count][j]=true;
            }
            count++;
        }

        DFS(matrix,visited,0);
//you have to visit every room even if its visited is true to get keys to other rooms
//nope coz whenever you visist a room even by DFS you getaccess to keys

        for(int i=0;i<visited.length;i++)
        {
            if(visited[i]==false)
            {
                return false;
            }
        }
        return true;
    }

    void DFS(boolean[][]matrix, boolean []visited, int row)
    {
        System.out.println("row= "+row);

        visited[row]=true;

        for(int j=0;j<matrix[row].length;j++)
        {
            //System.out.println(j);
            if(matrix[row][j]==true)
            {

                if(visited[j]==false){
                    DFS(matrix,visited,j);
                }

            }
            return;
        }
    }