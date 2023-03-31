class Solution {
    public int search(int[] nums, int target) {
        int pivot = findpivot(nums);
        if(pivot==-1)
        {
            return BS(nums,target,0,nums.length-1);
        }
        else if(target>=nums[0])
        {
            return BS(nums,target,0,pivot);
        }
        else
        {
            return BS(nums,target,pivot+1,nums.length-1);
        }
    }

    int findpivot(int nums[])
    {
        int start = 0;
        int end = nums.length - 1;
       
        while(start<=end)
        {
            int mid = start + (end - start)/2;

           if (mid < end && nums[mid] > nums[mid + 1])
            {
                return mid;
            }
            else if(mid>start && nums[mid]<nums[mid-1])
            {
                return mid-1;
            }
            else if(nums[start]>=nums[mid])
            {
                end = mid -1;
            }
            else
            {
                start = mid +1;
            }
        }
        return -1;
    }
  
     int findpivotwithDuplicate(int nums[])
    {
        int start = 0;
        int end = nums.length - 1;
       
        while(start<=end)
        {
            int mid = start + (end - start)/2;

           if (mid < end && nums[mid] > nums[mid + 1])
            {
                return mid;
            }
            else if(mid>start && nums[mid]<nums[mid-1])
            {
                return mid-1;
            }
            
          if(nums[mid] == nums[start] && nums[mid] == nums[end])
          {
              if(nums[start] > nums[start + 1] )
              {
                  return start;
              }
            start++;
              if(nums[mid] < nums[mid-1])
              {
                return end - 1;
              }
            end--;
            //left side is sorted , so pivot should be in right 
            else if(nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end]))
            {
                  start = mid + 1;
            }
            else
            {
              end = mid - 1;
             }
        }
        return -1;
    }

    int BS(int nums[],int target,int start,int end)
    {
        while(start<=end)
        {
            int mid = start + (end-start)/2;

            if(target>nums[mid])
            {
                start = mid +1;
            }
            else if(target<nums[mid])
            {
                end = mid - 1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }
}
