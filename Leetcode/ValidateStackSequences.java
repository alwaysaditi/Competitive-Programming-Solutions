package Leetcode;

import java.util.Stack;

public class ValidateStackSequences {

        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> myStack = new Stack<Integer>();
            int push =0;
            int pop =0;
            while((push < pushed.length)||(pop < popped.length))
            {

                if(((push<pushed.length)&&(pushed[push]==popped[pop]))||((!myStack.isEmpty())&&(popped[pop]==myStack.peek())))
                {
                    if((!myStack.isEmpty())&&(popped[pop]==myStack.peek()))
                    {
                        // myStack.pop();
                        pop++;
                        System.out.println("popped case 1 "+myStack.pop());
                    }
                    else if(pushed[push]==popped[pop])
                    {
                        System.out.println("popped case 2 "+popped[pop]);
                        if(push<pushed.length)
                        {
                            push++;
                        }

                        pop++;


                    }
                    // push++;

                }

                else if((push<pushed.length)&&(pushed[push]!=popped[pop]))
                {
                    System.out.println("pushed ="+ pushed[push]);
                    myStack.push(pushed[push]);
                    push++;

                }
                else return false;
            }
            return true;
        }
    }

