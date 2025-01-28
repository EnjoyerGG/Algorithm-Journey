//题目：给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//请必须使用时间复杂度为 O(log n) 的算法。

/*
输入: nums = [1,3,5,6], target = 5
输出: 2

输入: nums = [1,3,5,6], target = 2
输出: 1

输入: nums = [1,3,5,6], target = 7
输出: 4
*/

/*
当目标元素 target 不存在数组 nums 中时，搜索左侧边界的二分搜索的返回值可以做以下几种解读：
1、返回的这个值是 nums 中大于等于 target 的最小元素索引。
2、返回的这个值是 target 应该插入在 nums 中的索引位置。
3、返回的这个值是 nums 中小于 target 的元素个数。
比如在有序数组 nums = [2,3,5,7] 中搜索 target = 4，搜索左边界的二分算法会返回 2，你带入上面的说法，都是对的。
所以以上三种解读都是等价的，可以根据具体题目场景灵活运用，显然这里我们需要的是第二种。
*/

class Solution{
  public int searchInsert(int[] nums, int target){
    return left_bound(nums, target);
  }

  //搜索左侧边界的二分算法
  int left_bound(int[] nums, int target){
    if(nums.length == 0) return -1;
    int left = 0;

    //注意
    int right = nums.length;

    //注意
    while(left<right){
      int mid = left + (right-left)/2;
      if(nums[mid] == target){
        right = mid;
      }
      else if(nums[mid] < target){
        left = mid + 1;
      }
      else if(nums[mid] > target){
        //注意
        right = mid;
      }
    }
    return left;
  }
}




















