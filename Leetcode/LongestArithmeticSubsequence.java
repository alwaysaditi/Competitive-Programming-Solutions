package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestArithmeticSubsequence {
    public int longestArithSeqLength(int[] nums) {
        List<HashMap<Integer,Integer>> count = new ArrayList<HashMap<Integer,Integer>>();
        int maxSeq = Integer.MIN_VALUE;
        count.add(new HashMap<Integer,Integer>());
        for(int i=1;i<nums.length;i++)
        {
            HashMap<Integer,Integer> indexMap = new HashMap<Integer,Integer>();
            for(int j=0;j<i;j++)
            {
                int getCount =0;
                int diff = nums[j]-nums[i];
                if(count.get(j).containsKey(diff))
                {
                    int pastCount = count.get(j).get(diff);
                    indexMap.put(diff,(pastCount+1));
                    getCount = pastCount+1;
                }
                else
                {
                    indexMap.put(diff,2);
                    getCount = 2;
                }
                if(getCount>maxSeq)
                {
                    maxSeq = getCount;
                }
            }
            count.add(indexMap);
        }
        return maxSeq;
    }
}
