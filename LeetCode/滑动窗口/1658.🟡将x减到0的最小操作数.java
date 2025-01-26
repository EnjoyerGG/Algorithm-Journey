//题目：给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
//如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。

//思路：滑动窗口
//之所以本题可以用滑动窗口，关键是题目说了 nums 中的元素都是正数，这就保证了只要有元素加入窗口，和一定变大，只要有元素离开窗口，和一定变小。
//如果存在负数的话就没有这个性质了，也就不能确定什么时候扩大和缩小窗口，也就不能使用滑动窗口算法，而应该使用 前缀和 + 哈希表的方式 解决，参见 560. 和为K的子数组。

/*
输入：nums = [1,1,4,2,3], x = 5
输出：2
解释：最佳解决方案是移除后两个元素，将 x 减到 0 。

输入：nums = [5,6,7,8,9], x = 4
输出：-1

输入：nums = [3,2,20,1,1,3], x = 10
输出：5
解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
*/

//关键：这道题等价于让你寻找 nums 中元素和为 sum(nums) - x 的最长子数组。

class Solution{
  public int minOperations(int[] nums, int x){
    int n = nums.length;
    int sum = 0;
    for(int i=0; i<n; i++){
      sum += nums[i];
    }

    //滑动窗口需要寻找的子数组目标和
    int target = sum - x;

    int left = 0; 
    int right = 0;
    //记录窗口内所有元素和
    int windowSum = 0;
    //记录目标子数组的最大长度
    int maxLen = Integer.MIN_VALUE;
    //开始执行滑动窗口框架
    while(right<nums.length){
      //扩大窗口
      windowSum += nums[right];
      right++;

      while(windowSum>target && left<right){
        //缩小窗口
        windowSum -= nums[left];
        left++;
      }
      //寻找目标子数组
      if(windowSum==target){
        maxLen = Math.max(maxLen, right-left);
      }
    }
    //目标子数组的最大长度可以推导出需要删除的字符数量
    return maxLen == Integer.MIN_VALUE ? -1 : n-maxLen;
  }
}
