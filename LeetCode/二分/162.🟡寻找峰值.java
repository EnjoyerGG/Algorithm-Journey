//题目：峰值元素是指其值严格大于左右相邻值的元素。
//给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
//你可以假设 nums[-1] = nums[n] = -∞ 。
//你必须实现时间复杂度为 O(log n) 的算法来解决此问题。

/*
输入：nums = [1,2,3,1]
输出：2
解释：3 是峰值元素，你的函数应该返回其索引 2。

输入：nums = [1,2,1,3,5,6,4]
输出：1 或 5 
解释：你的函数可以返回索引 1，其峰值元素为 2；
     或者返回索引 5， 其峰值元素为 6。
*/

class Solution{
  public int findPeakElement(int[] nums){
    //取两端都封闭的二分搜索
    int left = 0;
    int right = nums.length - 1;
    //因为题目必然有解，所以设置left == right为结束条件
    while(left < right){
      int mid = left + (right-left)/2;
      if(nums[mid] > nums[mid+1]){
        //mid本身就是峰值或其左侧有一个峰值
        right = mid;
      }
      else{
        //mid右侧有一个峰值
        left = mid + 1;
      }
    }
    return left;
  }
}








  
