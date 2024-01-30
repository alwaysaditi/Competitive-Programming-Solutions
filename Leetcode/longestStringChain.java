class Solution {
    public int longestStrChain(String[] words) {
        HashMap<String,Integer> maps = new HashMap<String, Integer>();
       sortWords(words);
       int maxlength =0;
       for(int i=0;i<words.length;i++)
       {
          int breakpoint =0;
          String current = words[i];
          int currmax =0;
          while(breakpoint < words[i].length())
          {
String s1 = current.substring(0,breakpoint);
String s2 = current.substring(breakpoint+1,current.length());


String s = s1+s2;
//System.out.println(current+" = "+s);
if(maps.containsKey(s))
{
    int value = maps.get(s)+1;
   if(value>currmax)
   {
       currmax = value;
      
   }

   if(maxlength<currmax)
{
   maxlength = currmax;
}
}
breakpoint++;
          }
if(currmax==0)
{
    currmax=1;
}
          maps.put(current,currmax);
          //System.out.println("inserted "+current+" with value ="+currmax);
       }
if(maxlength>1)
{
    return maxlength;
}
return 1;
    }

    void sortWords(String [] words)
    {
    for(int i=0;i<words.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                int s1 = words[i].length();
                int s2 = words[j].length();

                if(s1<s2)
                {
String temp = words[i];
words[i]=words[j];
words[j]=temp;
                }
            }
        }
    }
}
