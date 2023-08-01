// dp with hashMap
class Solution {
    public boolean canCross(int[] stones) {
// you can only not reach the next stone if the gap from the previous jumps cannot "make up to" k+1
if(stones[1]!=1)
{
    return false;
}
else if(stones.length==2)
{
    return true;
}
HashMap<Integer,HashSet<Integer>> myMap = new HashMap<Integer,HashSet<Integer>>();

for(int i=1;i<stones.length;i++)
{
    myMap.put(stones[i],new HashSet<Integer>());
}

myMap.get(stones[1]).add(0);

myMap.get(stones[1]).add(1);

myMap.get(stones[1]).add(2);
for(int i=1;i<stones.length;i++)
{
   //System.out.println("index = "+stones[i]+" list = "+myMap.get(stones[i]));
    
    {

    
    for(int val:myMap.get(stones[i]))
    {
        int jump = val;


        if(myMap.containsKey(stones[i]+jump)&&(jump>0))
        {
         if(!myMap.get(stones[i]+jump).contains(jump))
         {
   myMap.get(stones[i]+jump).add(jump);
         }

         if(!myMap.get(stones[i]+jump).contains(jump-1)&&(jump-1>0))
         {
            myMap.get(stones[i]+jump).add(jump-1);
         }

         if(!myMap.get(stones[i]+jump).contains(jump+1))
         {
            myMap.get(stones[i]+jump).add(jump+1);
         }
          //  }

          
        }


    }
}
}

if((myMap.containsKey(stones[stones.length-1]))&&myMap.get(stones[stones.length-1]).size()>0)
{
    return true;
}

return false;

    }
}
