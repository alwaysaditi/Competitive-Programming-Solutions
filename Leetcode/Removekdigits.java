// leetcode Remove K digits 402 String ,Stack , Greedy, Monotonic Stack

class Removekdigits{
    public String removeKdigits(String num, int k) {
        Stack<Integer> myStack = new Stack<Integer>();
        int ktemp=k;
        int knew = k;
       // myStack.push(num.charAt(0)-'0');
        if(k==num.length())
        {
            return "0";
        }
        for(int i=0;i<num.length(); i++)
        {
            int next = num.charAt(i)-'0';
            while((!myStack.isEmpty())&&(next<myStack.peek())&&(k>0))// so remove all chars until bottom of stack is smallest 
            {
            
                    myStack.pop();
                   // myStack.push(next);
                
                k--; // the prime is removing all chars until bottom of a stack is smallest. doest matter if many no.s were removed for a single number
                
                   // myStack.push(next);
            
            }
        
            
                myStack.push(next);
            
        }
       
       String ans = "";
       boolean nopop = false;
        if(k!=0)// for ascending order
        {
            while((k-->0))
            {

              int val=  myStack.pop();
              
          
          //  k--;
            }
        }


//String ans="";

while(!myStack.isEmpty())
{
    ans = myStack.pop()+ans;
}
            
            
while((ans.length()>0)&&(ans.charAt(0)=='0'))
{
    ans = ans.substring(1);
}
     if(ans.equals(""))
        {
            ans= ans+"0";
        }
        
        return ans;
    }
}
