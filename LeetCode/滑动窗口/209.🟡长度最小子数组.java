//题目：给定一个含有 n 个正整数的数组和一个正整数 target 。
//找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0。

/*
输入：target = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。

输入：target = 4, nums = [1,4,4]
输出：1

输入：target = 11, nums = [1,1,1,1,1,1,1,1]
输出：0

进阶：
如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
*/

/*
题目说了 nums 数组中的元素都是正数，有了这个前提才能使用滑动窗口算法，因为窗口扩大时窗口内元素之和必然增大，窗口缩小时窗口内元素之和必然减小。
如果 nums 数组中包含负数，则窗口扩大时元素和不见得就增大，窗口缩小时元素和不见得就减小，这种情况就不能单纯使用滑动窗口技巧了，可能需要混合动态规划和单调队列来做。
*/

class Solution{
  public int minSubArrayLen(int target, int[] nums){
    int left = 0;
    int right = 0;
    //维护窗口内元素之和
    int windowSum = 0;
    int res = Integer.MAX_VALUE;

    while(right<nums.length){
      //扩大窗口
      windowSum += nums[right];
      right++;
      while(windowSum>=target && left<right){
        //已经达到target，缩小窗口，同时更新答案
        res = Math.min(res, right-left);
        windowSum -= nums[left];
        left++;
      }
    }
    return res == Integer.MAX_VALUE ? 0 : res;
  }
}
      
