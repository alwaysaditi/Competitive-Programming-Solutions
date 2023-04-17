package Leetcode;

// leetcode 316 with monotonic stack
import java.util.HashMap;
import java.util.Stack;

public  class longestSubsequence {
        public String smallestSubsequence(String s) {

            HashMap<Character, Integer> count = new HashMap<Character,Integer>();
            HashMap<Character, Boolean> encountered = new HashMap<Character,Boolean>();
            Stack<Character> myStack = new Stack<Character>();

            for(int i=0;i<s.length();i++)
            {
                if(count.containsKey(Character.valueOf(s.charAt(i))))
                {
                    count.put(Character.valueOf(s.charAt(i)),(count.get(s.charAt(i))+1));
                }

                else
                {
                    count.put(Character.valueOf(s.charAt(i)),1);
                }
            }
            myStack.push(s.charAt(0));
            count.put(Character.valueOf(s.charAt(0)),(count.get(Character.valueOf(s.charAt(0)))-1));
            encountered.put(Character.valueOf(s.charAt(0)),true);
            for(int i=1;i<s.length();i++)
            {
                if((encountered.containsKey(Character.valueOf(s.charAt(i))))&&(encountered.get(Character.valueOf(s.charAt(i)))))
                {
                    count.put(Character.valueOf(s.charAt(i)),(count.get(Character.valueOf(s.charAt(i)))-1));
                    continue;
                }
// stack needs to be in desceding order from top to bttom
                else if(((int)s.charAt(i)>(int)myStack.peek()))// if incoming is greater than top of stack, then push
                {
                    myStack.push(Character.valueOf(s.charAt(i)));
                    encountered.put(Character.valueOf(s.charAt(i)),true);
                    //count.put(Character.valueOf(s.charAt(i)),(count.get(Character.valueOf(s.charAt(i)))-1));
                }

                else if((((int)s.charAt(i)<(int)myStack.peek()))) // if incoming is lesser than top of stack
                {
                    while((!myStack.isEmpty())&&(((int)s.charAt(i)<(int)myStack.peek())&&(count.get(myStack.peek())>0)))
                    {
                        System.out.println(count.get(myStack.peek())+" element= "+myStack.peek());
                        Character ele = myStack.pop();
                        System.out.println("popped= "+ele);
                        encountered.put(ele,false);
                    }

                    myStack.push(Character.valueOf(s.charAt(i)));
                    encountered.put(Character.valueOf(s.charAt(i)),true);
                    //count.put(Character.valueOf(s.charAt(i)),(count.get(Character.valueOf(s.charAt(i)))-1));
// while top of stack is greater , pop it until you encounter an element thats lesser
// OR pop it until you encounter an element greater than the incoming element
                }
                count.put(Character.valueOf(s.charAt(i)),(count.get(Character.valueOf(s.charAt(i)))-1));
            }

            String ans = "";
            while(!myStack.isEmpty())
            {
                ans = ans+myStack.pop();
            }
            StringBuilder reverseString = new StringBuilder(ans);


            reverseString.reverse();  // Reversing the StringBuilder


            // Converting StringBuilder to String

            String result = reverseString.toString();
            return result;
        }
    }

