// leetcode 670 Maximum Swap Math, Greedy
class MaximumSwap {
    public int maximumSwap(int num) {
        String temp = Integer.toString(num);
       HashMap<Integer,Integer> occur = new HashMap<Integer,Integer>() ;
       for(int i=0;i<temp.length();i++)
       {
           if(occur.containsKey(temp.charAt(i)-'0'))
           {
               occur.put(temp.charAt(i)-'0',i);
           }
           else 
           {
               occur.put(temp.charAt(i)-'0',i);
           }
       }
       int index1=-1;
       int index2 = -1;
       boolean flag = false;
       for(int i=0;i<temp.length();i++)
       {
          int pres = temp.charAt(i)-'0';
           for(int j=9;j>pres;j--)
           {
               if((occur.containsKey(j))&&(occur.get(j)>i))
               {
                 //  System.out.println("j= "+j+" pres= "+pres);
                   index1=i;
                   index2=occur.get(j);
                   flag = true;
                   break;
               }
           }
           if(flag==true)
           {
               break;
           }
       }
       String ans ="";
     //  System.out.println("index1= "+index1+" index2= "+index2);
       if((index1==-1)&&(index2==-1))
       {
           return num;
       }
       //String ans = "";
       else 
       {
for(int i=0;i<temp.length();i++)
{
    if((i==index2))
    {
        ans = ans + temp.charAt(index1);
    }
    else if(i==index1)
    {
        ans = ans + temp.charAt(index2);
    }
    else 
    {
        ans = ans + temp.charAt(i);
    }
}
return Integer.valueOf(ans);
       }
    }
}
