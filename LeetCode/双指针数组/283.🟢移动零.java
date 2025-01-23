//题目：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//请注意 ，必须在不复制数组的情况下原地对数组进行操作。

//思路：双指针，快慢指针
//关键：原地修改
//题目让我们将所有 0 移到最后，其实就相当于移除 nums 中的所有 0，然后再把后面的元素都赋值为 0：

/*
输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]

输入: nums = [0]
输出: [0]

提示:
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
进阶：你能尽量减少完成的操作次数吗？
*/

class Solution{
  public void moveZeroes(int[] nums){
    //去除nums中所有0，返回不含0的数组长度
    int p = removeElement(nums, 0);
    //将nums[p..]的元素赋值为0
    for(; p<nums.length; p++){
      nums[p] = 0;
    }
  }

  //快慢指针模板，y总
  public int removeElement(int[] nums, int val){
    int fast = 0;
    int slow = 0;
    while(fast<nums.length){
      if(nums[fast]!=val){
        nums[slow] = nums[fast];
        slow++;
      }
      fast++;
    }
    return slow;
  }
}
