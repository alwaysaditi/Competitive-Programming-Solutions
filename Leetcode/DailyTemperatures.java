class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Temperature> myStack = new Stack<Temperature>();
int [] answer = new int[temperatures.length];
        for(int i=temperatures.length-1;i>=0;i--)
        {
            if(!myStack.isEmpty())
            {
                Temperature ele = myStack.peek();
                if(temperatures[i]>=ele.temp)
                {
                    while((!myStack.isEmpty())&&(myStack.peek().temp<=temperatures[i]))
                    {
                        myStack.pop();
                    }

                    if(!myStack.isEmpty())
                    {
                        answer[i] = myStack.peek().index-i;
                        myStack.push(new Temperature(temperatures[i],i));

                    }

                    else {
myStack.push(new Temperature(temperatures[i],i));
                    }
                    //answer[i] = 0;
                }

                else {
                  answer[i] = myStack.peek().index-i;
                  myStack.push(new Temperature(temperatures[i],i));
                }
            }

            else 
            {
                myStack.push(new Temperature(temperatures[i],i));
            }
        }
        return answer;
    }
}

class Temperature
{
    int temp;
    int index;

    Temperature(int temp, int index)
    {
        this.temp = temp;
        this.index = index;
    }
}
