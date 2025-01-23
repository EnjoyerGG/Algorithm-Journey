//题目：给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。
//然后返回 nums 中与 val 不同的元素的数量。

//思路：双指针，快慢指针
//关键：原地删除

/*
输入：nums = [3,2,2,3], val = 3
输出：2, nums = [2,2,_,_]
解释：你的函数函数应该返回 k = 2, 并且 nums 中的前两个元素均为 2。

输入：nums = [0,1,2,2,3,0,4,2], val = 2
输出：5, nums = [0,1,4,0,3,_,_,_]
解释：你的函数应该返回 k = 5，并且 nums 中的前五个元素为 0,0,1,3,4。

提示：
0 <= nums.length <= 100
0 <= nums[i] <= 50
0 <= val <= 100
*/

class Solution{
  public int removeElement(int[] nums, int val){
    int fast = 0;
    int slow = 0;
    while(fast < nums.length){
      if(nums[fast]!=val){
        nums[slow] = nums[fast];
        slow++;
      }
      fast++;
    }
    return slow;
  }
}
