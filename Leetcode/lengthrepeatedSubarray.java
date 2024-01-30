class lengthRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        HashMap<Integer,Boolean> previous = new HashMap<Integer,Boolean>();
        HashMap<Integer,Boolean> current = new HashMap<Integer,Boolean>();
int m = nums1.length;
int n = nums2.length;
int maxlength =0;
        int [][]dp = new int[m+1][n+1];

        for(int i=1;i<=m;i++)
        {
          //  System.out.println(previous);
            for(int j=1;j<=n;j++)
            {
if(nums1[i-1]==nums2[j-1])
{
    if((!previous.isEmpty())&&previous.containsKey(j-1))
    {
        dp[i][j]= dp[i-1][j-1]+1;
       // maxlength = (maxlength<dp[i][j])?(dp[i][j]):maxlength;

    }
    else
    {
        dp[i][j]=1;
    }
    maxlength = (maxlength<dp[i][j])?dp[i][j]:maxlength;
    current.put(j,true);
}
else
{
    dp[i][j]=dp[i][j-1];
}
            }
previous.clear();
            previous = new HashMap<Integer,Boolean>(current);
            current.clear();
        }
        return maxlength;
    }
}
