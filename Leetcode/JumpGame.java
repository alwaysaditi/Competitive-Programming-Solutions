package Leetcode;
//In this problem , it is very possible that a longer jump might not lead to the finish, while a shorter one would.
//Hence we must try out all the possibilities to reach the end
//So instead of trying all possibilities to reach the end index, we can rather try to reach that index, from which we can definitely reach the end
//In other words, we should try reaching a point from where we can definitely reach the end
//If our maximum step count at any index allows us to reach an index that is greater than the index from where we can atleast reach the end, that is also fine, but the goal is to reach an index from where we can definitely reach the end
//Hence we start iterating from behind the array, and for each index , we decide whether we can definitely reach the end , from that index.
//We keep a variable named "index" , which decides the smallest index from the end, which can reach the end
//As we start iterating from behind, we update the value of the "index" variable whenever we can get a newer, smaller index that can definitely reach the end
//Thus if "index" =0 at the end of the iteration, it means we can reach the end from index 0 and we return true
//Else we return false
public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int index =n-1;
        for(int i=(n-2);i>=0;i--)
        {
            if(nums[i]>=(index-i))
            {
                index =i;
            }
        }
        if(index==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
