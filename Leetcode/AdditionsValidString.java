// leetcode 2645 String , DP , Stack Greedy 

class AdditionsValidString {
    public int addMinimum(String word) {
        Stack<Character> myStack = new Stack<Character>();
        int count = 0;
        for(int i=0;i<word.length();i++)
        {
if(word.charAt(i)=='a')// a can only occur on empty stack or after c
{
    if(myStack.isEmpty()||(myStack.peek()=='c'))
    {
        //myStack.push(word.charAt(i));
    }
    else if((!myStack.isEmpty())&&(myStack.peek()=='b'))
    {
      //  if(myStack)
     //myStack.push('c');
      count++;
      //myStack.push('a');
    }
    else if((!myStack.isEmpty())&&(myStack.peek()=='a'))
    {
        count+=2;
    }
    myStack.push('a');
}

else if(word.charAt(i)=='b') // b should only occur after a and there should be a c after b. c after b is taken care of in a , but not for the ending character 
{
     if(!myStack.isEmpty())
{


    if((myStack.peek()=='b'))
    {
//myStack.push('c');
//myStack.push('a');
count +=2;
    }
    else if(myStack.peek()=='c')
    {
//myStack.push('a');
count++;
    }
}
else if(myStack.isEmpty())
{
    count++;
}
    myStack.push('b');

}
else if(word.charAt(i)=='c')
{
    if(!myStack.isEmpty())
    {

    
    if(myStack.peek()=='a')
    {
count++;
    }
    else if(myStack.peek()=='c')
    {
        count+=2;
    }
    }
    else
    {
        count+=2;
    }
    myStack.push('c');
}
        }

        if(myStack.peek()=='a')
        {
            count+=2;
        }
        else if(myStack.peek()=='b')
        {
            count++;
        }
        return count;
    }
}
