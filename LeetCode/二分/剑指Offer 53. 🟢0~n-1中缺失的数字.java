//题目：某班级 n 位同学的学号为 0 ~ n-1。点名结果记录于升序数组 records。假定仅有一位同学缺席，请返回他的学号。

/*
输入: records = [0,1,2,3,5]
输出: 4

输入: records = [0, 1, 2, 3, 4, 5, 6, 8]
输出: 7
*/

class Solution{
  public int missingNumber(int[] nums){
    int left = 0;
    int right = nums.length - 1;

    while(left<right){
      int mid = left + (right-left) / 2;
      if(nums[mid] > mid){
        //mid和nums[mid]不对应，说明左边有元素缺失
        right = mid - 1;
      }
      else{
        //mid和nums[mid]对应，说明元素缺失在右边
        left = mid + 1;
      }
    }
    return left;
  }
}
