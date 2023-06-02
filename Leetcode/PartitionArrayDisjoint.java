// leetcode 915

class PartitionArrayDisjoint {
    public int partitionDisjoint(int[] nums) {
        // atleast the array upto the minimum element will be in the LHS. 
// the max element of the array wont occur before the min element
// to make the list as small as possible , the next element shall be greater than the max element encountered so far , call this element the pivot , the one that breaks it 

// if the element after the pivot is smaller than the elements on the left , make another partition from the element after the pivot and new max element as pivot 
 // max so far and pivot should be different elements pls 
 int pivot = Integer.MAX_VALUE;
 int largest= nums[0];
int largest_temp =0;
 for(int i=0;i<nums.length;i++)
 {
     if((nums[i]>=largest)&&(pivot< Integer.MAX_VALUE))
     {
         if(nums[i]>largest_temp)
         {

         
         largest_temp=nums[i];
         }
         continue;
     }

     else if((nums[i]>=largest)&&(pivot==Integer.MAX_VALUE))
     {
         pivot = i;
     }

     else if((nums[i]<largest)&&(pivot<Integer.MAX_VALUE))
     {
         if(largest_temp>largest)
         {
 largest = largest_temp;
         }
         pivot = i;
     }
     else if((nums[i]<largest)&&(pivot==Integer.MAX_VALUE))
     {
pivot = i+1;
     }
 }

 if(pivot==Integer.MAX_VALUE)
 {

 return 1;
 }

        return pivot+1;
    }
}
