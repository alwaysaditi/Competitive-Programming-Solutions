//leetcode 1376 Tree, DFS, BFS
class TimeInformEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // store hashmap of manager and list of subordinates.
        // create reachtime array and initialize all to infimity (reachtime represents time needed to reach the employee )
        // for all employees having informtime as 0, return max of reachtime
     HashMap<Integer,List<Integer>> hm = new HashMap<Integer,List<Integer>>();
     for(int i=0;i<manager.length;i++)
     {
if(hm.containsKey(manager[i]))

{
hm.get(manager[i]).add(i);
}
else
{
 List<Integer> subordinates = new ArrayList<Integer>();
 subordinates.add(i);
 hm.put(manager[i],subordinates);
}
     }
     int reachtime[] = new int[n];
     Queue <Integer> queue = new LinkedList<>();
     int ans =0;
queue.add(headID);
//for(Map.Entry<Integer,List<Integer>> entry : hm.entrySet())
{
    //Integer key = entry.getKey();
  //List<Integer>  values = entry.getValue();
  //  System.out.print(" head= "+key);
  //  System.out.print(" values= ");
  //  for(int i=0;i<values.size();i++)
    {

    
  //  System.out.print(values.get(i));
    }
  //  System.out.println(" ");
}
while(!queue.isEmpty())
{
    Integer man = queue.peek();
    int size =0;
    System.out.println(hm.get(man));
    List<Integer> value = hm.get(man);
   // size = value.size();
   if(hm.get(man)!=null)
   {

   
    for(Integer ele: hm.get(man))
    {
        queue.add(ele);
        reachtime[ele] = reachtime[man]+informTime[man];
         ans = Math.max(ans,reachtime[ele]);
    }
   }
    queue.remove();
}
  return ans;  }
}
