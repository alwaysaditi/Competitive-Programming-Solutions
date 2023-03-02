package Leetcode;

public class LongestMountainInArray {
    public int longestMountain(int[] arr) {
        int left[] = new int[arr.length];
        int right []= new int[arr.length];
        //   int sum []= new int[arr.length];

        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>arr[i-1])
            {
                left[i]=left[i-1]+1;
            }
            else left[i]=0;
        }
        for(int j=arr.length-2;j>=0;j--)
        {
            if(arr[j]>arr[j+1])
            {
                right[j]=right[j+1]+1;
            }
            else right[j]=0;
        }
        int maxmountain = Integer.MIN_VALUE;
        //for(int i=0;i<arr.length;i++)
        // {
        // System.out.print(left[i]);
        //  }
        for(int i=0;i<arr.length;i++)
        {
            if((left[i]==0)||(right[i]==0))
            {
                continue;
            }
            else if((left[i]+right[i])>maxmountain)
            {
                maxmountain = left[i]+right[i];
            }
        }
        if(maxmountain<0)
        {
            return 0;
        }
        return maxmountain+1;
    }
}
