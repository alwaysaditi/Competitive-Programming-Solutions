class KInversePairs {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        final int MOD = 1000000007;
        if(k==0) return 1;
        if(n==1&&(k==1)) return 0;
        else if((n==1)&&(k==0)) return 1;
        dp[1][0] = dp[2][0] = dp[2][1] =1;
        for(int num=3;num<=n;num++)
        {
            dp[num][0] =1;
            if((num*(num-1)/2)<=k)
            {
                dp[num][num*(num-1)/2] =1;
            }

            for(int i=1;i<=k;i++)
            {
                int pres = 0;
                int past = i;
                int sum  = 0;

                while(pres<=i)
                {
                    if((dp[num-1][past]==0)||((num-1)<pres))
                    {
pres++; past--; continue;
                    }

                    else {
                        sum = (sum+ dp[num-1][past])%MOD;
                        pres++;
                        past--;
                    }

                    dp[num][i] = sum;
                }
            }
        }

        return dp[n][k];
    }
}
