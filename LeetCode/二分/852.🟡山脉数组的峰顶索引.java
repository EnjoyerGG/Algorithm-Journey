//题目：给定一个长度为 n 的整数 山脉 数组 arr ，其中的值递增到一个 峰值元素 然后递减。
//返回峰值元素的下标。
//你必须设计并实现时间复杂度为 O(log(n)) 的解决方案。

/*
输入：arr = [0,1,0]
输出：1

输入：arr = [0,2,1,0]
输出：1

输入：arr = [0,10,5,2]
输出：1
*/

class Solution{
  public int peakIndexInMountainArray(int[] nums){
    //取两端都闭的二分搜索
    int left = 0;
    int right = nums.length - 1;
    //因为题目必然有解，所以设置left == right为结束条件
    while(left < right){
      int mid = left + (right - left) / 2;
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
