//java leetcode 738 Math , greedy

class Solution {
    public int monotoneIncreasingDigits(int n) {
        Deque <Integer> deck = new ArrayDeque<Integer>();
String s = String.valueOf(n);
int i;
boolean oneflag = false;
int tip =0;
boolean casenew = false ;
for(i=0;i<s.length()-1;i++)
{
    int num1 = s.charAt(i)-'0';
    int num2 = s.charAt(i+1)-'0';
    if(num2<num1)
    {
        if(num1==1)
        {
            oneflag = true; 
            break;
        }
        else 
        {
            casenew = true;
            //int val = deck.getLast();
           // System.out.println("i= "+i+" num1= "+num1+" size = "+deck.size());
            while((!deck.isEmpty())&&(deck.getLast()==num1))
            {
                deck.removeLast();
              // System.out.println("removed element= "+ deck.removeLast()); 
            }
            tip = num1-1;
            
            break;
        }
    }

    else 
    {
        deck.add(num1);
        //System.out.println("added num= "+num1);
    }
}
String strans = "";

if(oneflag==true)
{
    for(int k=0;k<s.length()-1;k++)
    {
strans = strans + "9";
    }
}

else 
{
    int count =0;
    for(Iterator itr = deck.iterator();
    itr.hasNext();)
    {
        strans = strans + String.valueOf(itr.next());
        count++;
    }
    
   // strans = strans + String.valueOf(tip);
    count++;
    if(casenew==true)

    {
strans = strans + String.valueOf(tip);
    while(count<s.length())
    {
        strans = strans + String.valueOf(9);
        count++;
    }
    }
    else
    {
        strans = strans + String.valueOf(s.charAt(i));
    }
}
//System.out.println("final answer= "+strans);
        return Integer.parseInt(strans);
    }
}
