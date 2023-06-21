// leetcode 1557 graph

class VerticesToReachNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
     List<Integer> answer = new ArrayList<Integer>();
     boolean found[] = new boolean[n];
for(int i=0;i<edges.size();i++)
{
    int to = edges.get(i).get(1);
    found[to]=true;
}
for(int i=0;i<found.length;i++)
{
    if(found[i]==false)
    {
        answer.add(i);
    }
}
return answer;
    }
}
