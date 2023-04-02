// DP solution with Matrix Chain Multiplication algorithm


class BurstBalloons {
    public int maxCoins(int[] nums) {
       int n = nums.length-1;
       int arr[]= new int[nums.length+2];
       arr[0]=1;
       arr[arr.length-1]=1;
       for(int i=0;i<nums.length;i++)
       {
           arr[i+1]=nums[i];
       }
       int dp[][]= new int[arr.length-1][arr.length-1];
       for(int k=0;k<arr.length-1;k++)
       {
           int maxprod = Integer.MIN_VALUE;
           int left=0;
           int right=k;
           while(right<arr.length-1)
           {
               if(left==right)
               {
                   right++;
                   left++;
                   continue;

               }
               else
               {
                   int stopper=left;
                   int prod=0;
                 //  maxprod=Integer.MIN_VALUE;
                   //int lefti =0;
                   //int righti=0;
                   
                   while(stopper<right)
                   {
prod = Math.max(dp[left][stopper]+dp[stopper+1][right]+ arr[left]*arr[stopper+1]*arr[right+1],prod);
    //System.out.println("stopper= "+stopper+" left= "+left+" right= "+right);
stopper++;    
                   }
            
                dp[left][right]=prod;
            
            //right++;
           // System.out.println("left= "+left+" right= "+right+" val= "+dp[left][right]);

               }
               right++;
               left++;
           }
       }

       return dp[0][dp.length-1];
    }
}
