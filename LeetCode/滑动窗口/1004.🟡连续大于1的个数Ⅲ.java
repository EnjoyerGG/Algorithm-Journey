//题目：给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。

/*
输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
输出：6
解释：[1,1,1,0,0,1,1,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 6。

输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
输出：10
解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 10。
*/

class Solution{
  public int longestOnes(int[] nums, int k){
    int left = 0;
    int right = 0;
    //记录1出现次数
    int windowOneCount = 0;
    //记录结果长度
    int res = 0;

    //开始滑动窗口模板
    while(right<nums.length){
      //扩大窗口
      if(nums[right]==1){
        windowOneCount++;
      }
      right++;

      while(right-left-windowOneCount>k){
        //当窗口中需要题换的0的数量大于k，缩小窗口
        if(nums[left]==1){
          windowOneCount--;
        }
        left++;
      }
      //此时一定是一个合法窗口，求最大窗口长度
      res = Math.max(res, right-left);
    }
    return res;
  }
}
