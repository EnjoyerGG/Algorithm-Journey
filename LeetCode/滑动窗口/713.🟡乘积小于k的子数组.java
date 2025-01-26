//题目：给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。

/*
输入：nums = [10,5,2,6], k = 100
输出：8
解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2]、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。

输入：nums = [1,2,3], k = 0
输出：0
*/

//思路：滑动窗口
//之所以本题可以用滑动窗口，关键是题目说了 nums 中的元素都是正数，这就保证了只要有元素加入窗口，积一定变大，只要有元素离开窗口，积一定变小。
//如果存在负数的话就没有这个性质了，也就不能确定什么时候扩大和缩小窗口

class Solution{
  public int numSubarrayProductLessThanK(int[] nums, int k){
    int left = 0;
    int right = 0;
    //滑动窗口，初始化位乘法单元
    int windowProduct = 1;
    //记录符合条件的子数组个数
    int count = 0;

    while(right<nums.length){
      //扩大窗口，并更新窗口数据
      windowProduct = windowProduct * nums[right];
      right++;

      while(left<right && windowProduct>=k){
        //缩小窗口，并更新窗口数据
        windowProduct = windowProduct / nums[left];
        left++;
      }
      // 现在必然是一个合法的窗口，但注意思考这个窗口中的子数组个数怎么计算：
      // 比方说 left = 1, right = 4 划定了 [1, 2, 3] 这个窗口（right 是开区间）
      // 但不止 [left..right] 是合法的子数组，[left+1..right], [left+2..right] 等都是合法子数组
      // 所以我们需要把 [3], [2,3], [1,2,3] 这 right - left 个子数组都加上
      count += right - left;
    }
    return count;
  }
}
















    
