// leetcode: 150 using stack
class EvaluateReversePolish {
    public int evalRPN(String[] tokens) {
        Stack<String> myStack = new Stack<String>();
        for (int i=0;i<tokens.length;i++)
        {
            int num1=0;
            int num2=0;
            int ans=0;
            if((tokens[i].equals("+"))||(tokens[i].equals("-"))||(tokens[i].equals("*"))||(tokens[i].equals("/")))
            {
                System.out.println(tokens[i]);
                num1=Integer.valueOf(myStack.pop());
                num2=Integer.valueOf(myStack.pop());
                if(tokens[i].equals("+"))
                {
                    ans = num1+num2;

                }
                else if(tokens[i].equals("-"))
                {
                    ans=num2-num1;
                }
                else if(tokens[i].equals("*"))
                {
                    ans=num2*num1;
                }
                else if(tokens[i].equals("/"))
                {
                    ans= num2/num1;
                }
                System.out.println(ans);
                myStack.push(Integer.toString(ans));
            }

            else
            {

                myStack.push(tokens[i]);
            }
        }
        // System.out.println(myStack.pop());
        int ansnew =Integer.valueOf(myStack.pop());
        return ansnew;
    }
}