// java Union Find achieved through DFS

class MinCityPathScore {
    int minedge = Integer.MAX_VALUE;
    boolean visited[];
    public int minScore(int n, int[][] roads) {
        HashMap<Integer, ArrayList<List<Integer>>>myMap = new HashMap<Integer, ArrayList<List<Integer>>>();
        visited = new boolean[n+1];
        for(int i=1;i<=n;i++)
        {
            myMap.put(i,new ArrayList<List<Integer>>());
        }
        for(int i=0;i<roads.length;i++)
        {
            myMap.get(roads[i][0]).add(Arrays.asList(roads[i][1],roads[i][2]));
            myMap.get(roads[i][1]).add(Arrays.asList(roads[i][0],roads[i][2]));
        }
        DFS(1,myMap);
        return minedge;
    }

    void DFS(int i, HashMap<Integer, ArrayList<List<Integer>>> myMap)
    {
        visited[i]=true;
        System.out.println("i= "+i);
        for(int j=0;j<myMap.get(i).size();j++)
        {
          //  System.out.println("i= "+i+" edge = "+myMap.get(i).get(j).get(1));
            if(myMap.get(i).get(j).get(1)<minedge)
            {
                
                minedge = myMap.get(i).get(j).get(1);
            }
            if(visited[myMap.get(i).get(j).get(0)]==false)
            {
                DFS(myMap.get(i).get(j).get(0),myMap);
            }
        }
    }
}
