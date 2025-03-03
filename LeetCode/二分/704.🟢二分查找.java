//题目：给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target。
//写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

/*
输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4

输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1
*/

class Solution{
  public int search(int[] nums, int target){
    int left = 0;
    int right = nums.length - 1; //注意

    while(left<=right){
      int mid = left + (right - left)/2;
      if(nums[mid]==target){
        return mid;
      }
      else if(nums[mid]<target){
        //注意
        left = mid + 1;
      }else if(nums[mid]>target){
        //注意
        right = mid - 1;
      }
    }
    return -1;
  }
}
