//题目：给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。

/*
输入：nums = [1,2,3,1], k = 3
输出：true

输入：nums = [1,0,1,1], k = 1
输出：true

输入：nums = [1,2,3,1,2,3], k = 2
输出：false
*/

/*
使用滑动窗口算法需要搞清楚以下几个问题：
1、什么时候应该扩大窗口？
2、什么时候应该缩小窗口？
3、什么时候得到一个合法的答案？
本题很简单直接，以上三个问题的答案是：
1、当窗口大小小于 k 时，扩大窗口。
2、当窗口大小大于 k 时，缩小窗口。
3、当窗口大小等于 k 且发现窗口中存在重复元素时，返回 true。
*/

class Solution{
  public boolean containsNearbyDuplicate(int[] nums, int k){
    int left = 0;
    int right = 0;
    HashSet<Integer> window = new HashSet<>();

    while(right<nums.length){
      //扩大窗口
      if(window.contains(nums[right])){
        return true;
      }
      window.add(nums[right]);
      right++;

      if(right-left>k){
        //当窗口的大小大于k时，缩小窗口
        window.remove(nums[left]);
        left++;
      }
    }
    return false;
  }
}
      
