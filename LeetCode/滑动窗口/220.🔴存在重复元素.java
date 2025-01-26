//题目：给你一个整数数组 nums 和两个整数 indexDiff 和 valueDiff 。
//找出满足下述条件的下标对 (i, j)：
//i != j,
//abs(i - j) <= indexDiff
//abs(nums[i] - nums[j]) <= valueDiff
//如果存在，返回 true ；否则，返回 false。

/*
输入：nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
输出：true
解释：可以找出 (i, j) = (0, 3) 。
满足下述 3 个条件：
i != j --> 0 != 3
abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0

输入：nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
输出：false
解释：尝试所有可能的下标对 (i, j) ，均无法满足这 3 个条件，因此返回 false 。

提示：
2 <= nums.length <= 105
-109 <= nums[i] <= 109
1 <= indexDiff <= nums.length
0 <= valueDiff <= 109
*/

/*
三个问题的答案是：
1、当窗口大小小于等于 k 时，扩大窗口，包含更多元素。
2、当窗口大小大于 k 时，缩小窗口，减少窗口元素。
3、窗口大小小于等于 k，且窗口中存在两个不同元素之差小于 t 时，找到一个答案。
*/

class Solution{
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
    TreeSet<Integer> window = new TreeSet<>();
    int left = 0;
    int right = 0;
    while(right<nums.length){
      //为了防止i==j，所以在扩大窗口之前先判断是否有符合题意的索引对(i,j)
      //查找略大于nums[right]的那个元素
      Integer ceiling = window.ceiling(nums[right]);
      if(ceiling!=null && (long)ceiling-nums[right]<=t){
        return true;
      }

      //查找略小于nums[right]的那个元素
      Intefer floor = window.floor(nums[right]);
      if(floor!=null && (long)nums[right]-floor<=t){
        return true;
      }

      //扩大窗口
      window.add(nums[right]);
      right++;

      if(right-left>k){
        //缩小窗口
        window.remove(nums[left]);
        left++;
      }
    }
    return false;
  }
}






