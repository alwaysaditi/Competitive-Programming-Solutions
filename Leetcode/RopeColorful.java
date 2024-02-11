class Solution {
    public int minCost(String colors, int[] neededTime) {
        if(colors.length()==1)
        {
            return 0;
        }
        int ptr1=0;
        int ptr2=1;
        int minsum =0;
        while((ptr1<colors.length())&&(ptr2<colors.length()))
        {
char c1 = colors.charAt(ptr1);
char c2= colors.charAt(ptr2);
//System.out.println("c1= "+c1+" c2= "+c2+" ptr1= "+ptr1+" ptr2= "+ptr2);
if(c1==c2)
{
   int val1 = neededTime[ptr1];
   int val2 = neededTime[ptr2];
if(val1<val2)
{
    minsum = minsum+val1;
    if(ptr1<ptr2)
    {
        ptr1  = ptr2+1;
    }
    else
    {
        ptr1++;
    }
}

else
{
    minsum = minsum+ val2;
    if(ptr2<ptr1)
    {
        ptr2 = ptr1+1;
    }

    else
    {
        ptr2++;
    }
}


}

else
{
    if((ptr2-ptr1==1)||(ptr1-ptr2==1))
    { 
    ptr1++;
    ptr2++;
    }

    else
    {
        if(ptr1<ptr2)
        {
            ptr1= ptr2+1;
        }

        else
        {
            ptr2 = ptr1 +1;
        }
    }
}
    }
        

     return minsum;   
    }
}
