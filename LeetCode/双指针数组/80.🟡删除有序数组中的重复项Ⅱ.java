//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
//不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

//思路：双指针，快慢指针

/*
输入：nums = [1,1,1,2,2,3]
输出：5, nums = [1,1,2,2,3]

输入：nums = [0,0,1,1,1,1,2,3,3]
输出：7, nums = [0,0,1,1,2,3,3]
*/

class Solution{
  public int removeDuplicates(int[] nums){
    if(nums.length==0){ return 0; }

    //快慢指针，维护nums[0...slow]为结果子数组
    int slow = 0;
    int fast = 0;
    //记录重复次数
    int count = 0;
    while(fast<nums.length){
      if(nums[fast]!=nums[slow]){
        //此时对于nums[0...slow]，nums[fast]是一个新元素，加入
        slow++;
        nums[slow] = nums[fast];
      }else if(slow<fast && count<2){
        //此时对于nums[0...slow]来说，nums[fast]重复次数小于2，也加进来
        slow++;
        nums[slow] = nums[fast];
      }
      fast++;
      count++;
      if(fast<nums.length && nums[fast]!=nums[fast-1]){
        //fast遇到新的不同元素时，重置count
        count = 0;
      }
    }
    //数组长度为索引+1
    return slow+1;
  }
}
