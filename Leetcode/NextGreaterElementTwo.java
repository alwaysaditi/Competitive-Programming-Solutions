// Java 503: Monotonic Stack
class NextGreaterElementTwo {
    public int[] nextGreaterElements(int[] nums) {
        int maxval=Integer.MIN_VALUE;
        int index=0;
        int answer[] = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
if(nums[i]>maxval)
{
    maxval=nums[i];
    index=i;
}
        }

        Stack <Integer> myStack = new Stack <Integer>();
        myStack.push(maxval);
answer[index]=-1;
        for(int i=(index-1);i>=0;i--)
        {
            if(nums[i]==maxval)
            {
                myStack.push(nums[i]);
                answer[i]=-1;
                continue;
            }
           else if(nums[i]<myStack.peek())
            {
                answer[i]=myStack.peek();
                myStack.push(nums[i]);
            }
            else if(nums[i]>=myStack.peek())
            {
                while(myStack.peek()<=nums[i])
                {
                    myStack.pop();
                }
                answer[i]= myStack.peek();
                myStack.push(nums[i]);
            }
        }
        for(int i=(nums.length-1);i>index;i--)
        {
             if(nums[i]==maxval)
            {
                myStack.push(nums[i]);
                answer[i]=-1;
                continue;
            }
           else if(nums[i]<myStack.peek())
            {
                answer[i]=myStack.peek();
                myStack.push(nums[i]);
            }
            else if(nums[i]>=myStack.peek())
            {
                while(myStack.peek()<=nums[i])
                {
                    myStack.pop();
                }
                answer[i]= myStack.peek();
                myStack.push(nums[i]);
            }
        }
return answer;
    }
}