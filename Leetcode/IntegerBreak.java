package Leetcode;

import java.util.Arrays;

// the idea is to build a solution using the numbers that
//are smaller than it. the maximum sum possible for any
//number whether we build it from two or more
//numbers can be obtained from two numbers as well.
//We have an array dp[] which stores the max possible
//product for each number. Follow a top down
//approach starting from the target number and go
//down until you find a solution. Find this for all
//numbers less than the median upto the given
//number(as sums after the median usually repeat).
//Initialize a variable to store the maxproduct, in a for
//loop that stores all possible products upto target.
class IntegerBreak{

    public int integerBreak(int n) {

        int dp []=new int[n+1];

        int answer []= new int[n+1];

        Arrays.fill(answer,-1);

        Arrays.fill(dp,-1);

        dp[0]=0;

        dp[1]=1;

        dp[2]=2;

        answer = recursive(n,dp);

        return answer[n];

    }



    public int[] recursive(int n, int dp[])

    {

        int median=-1;
        int maxproduct =-1;
        int difference = -1;
        int num1=-1;
        int num2=-1;
        if(n%2==0)
        {
            median = n/2;
        }

        else

        {
            median =(n+1)/2;
        }

        for(int i=1;i<=median;i++)

        {
            difference = n-i;

            if(dp[i]==-1)

            {

                recursive(i,dp); // if a solution doesn't exist then find it

            }

            if(dp[difference]==-1)

            {

                recursive(difference,dp);

            }

            else {

                if(i>dp[i])// where the number itself is greater than the max possible product , we return the number
                {
                    num1=i;
                }
                else {
                    num1=dp[i];
                }
                if(difference>dp[difference])
                {
                    num2=difference;
                }

                else
                {
                    num2=dp[difference];
                }
            }
            int product = num1*num2;
            if(product>maxproduct)
            {
                maxproduct =product;
            }
        }
        dp[n]=maxproduct;
        return dp;

    }

}