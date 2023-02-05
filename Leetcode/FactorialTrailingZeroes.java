package Leetcode;

public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        //depends on the number of pairs of 5and 2 as well as number of 10s in the number individually.
        int k=1;
        int no_of_fives =0;
        if(n<5)
        {
            return 0;
        }
        if(n==5)
        {
            return 1;
        }

        while(Math.pow(5,k)<n)
        {
            k++;
        }
        if((n%5!=0))
        {
            k--;
        }
        // k--;
        System.out.println("k= "+k);
        int l=n;
        for(int i=1;i<=k;i++)
        {
            System.out.println("no_of_fives= "+no_of_fives);
            no_of_fives = no_of_fives + (int)(l/Math.pow(5,i));
            l=n;
        }

        return no_of_fives;
    }
}
