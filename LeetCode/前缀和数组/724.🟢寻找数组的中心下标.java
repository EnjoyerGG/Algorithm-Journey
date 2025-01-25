//题目：给你一个整数数组 nums ，请计算数组的 中心下标。
//数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
//如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
//如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1。

/*
输入：nums = [1, 7, 3, 6, 5, 6]
输出：3
解释：
中心下标是 3 。
左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。

输入：nums = [1, 2, 3]
输出：-1
解释：
数组中不存在满足此条件的中心下标。

输入：nums = [2, 1, -1]
输出：0
解释：
中心下标是 0 。
左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
*/


class Solution{
  public int pivotIndex(int[]  nums){
    int n = nums.length;
    int[] preSum = new int[n+1];
    preSum[0] = 0;

    //计算nums的前缀和
    for(int i=1; i<=n; i++){
      preSum[i] = preSum[i-1] + nums[i-1];
    }

    //根据前缀和判断左半边数组和右半边数组的元素是否相同
    for(int i=1; i<preSum.length; i++){
      //计算nums[i-1]左侧和右侧的元素和
      int leftSum = preSum[i-1] - preSum[0];
      int rightSum = preSum[n] - preSum[i];
      if(leftSum==rightSum){
        //相对nums数组，preSum数组还有一位索引偏移
        return i-1;
      }
    }
    return -1;
  }
}










