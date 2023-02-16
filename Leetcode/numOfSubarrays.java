// problem 1524 : Number of subarrays with odd sum

class noOfSubarrays {
    public int numOfSubarrays(int[] arr) {
        int oddnew=0;
        int evennew =0;
        int res=0;
        int answer=0;
        int temp=0;
        int dp[]=new int[arr.length];
        dp[0]=arr[0];
        if(arr[0]%2==0)
        {
            evennew =1;
        }
        else
        {
            oddnew=1;
            answer=answer+oddnew;
        }
        for(int i=1;i<arr.length;i++)
        {
            res=dp[i-1]+arr[i];
            dp[i]=res;
            if(res%2!=0)
            {
temp =oddnew;
answer =(answer+evennew+1)%(1000000007);
oddnew++;

//answer = answer + oddnew;
// you just need the number of odd numbers currently in the dp array in oddnew.
            }
            else
            {
                oddnew = oddnew;
                evennew = evennew+1;
                answer=(answer+oddnew)%(1000000007);
            }
            //System.out.println(answer);
        }
        
        return answer;
    }
}
