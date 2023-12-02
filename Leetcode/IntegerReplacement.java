class Solution {
     Map<Integer, Integer> dp = new HashMap<>();
    public int integerReplacement(int n) {
         // dp.put(Integer.MAX_VALUE,32);
         if(n==2147483647)
         {{return 32;}}
      //arr = new int[n+2];  
    return  recursive(n)-1;
    }

    int recursive(int num)
    {
        int val;
      
        if(num==1)
        {
           dp.put(1,1);
            val=1;
        }

        else
        { 
            if(num%2==0)
            {
                if(dp.containsKey(num/2))
                {
val = dp.get(num/2)+1;
                }

                else
                {
val = recursive(num/2)+1;
                }

               
            }

            else
            {
                int plusone;
                int minusone;
                plusone = ((!dp.containsKey(num+1))?recursive(num+1):dp.get(num+1))+1;
                minusone = ((!dp.containsKey(num-1))?recursive(num-1):dp.get(num-1))+1;
                val = Math.min(plusone,minusone);
                
            }
         //   System.out.println("num= "+num+" val= "+val);
           dp.put(num,val);
        }

        return val;
    }
}
