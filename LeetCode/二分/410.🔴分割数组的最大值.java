//题目：给定一个非负整数数组 nums 和一个整数 k ，你需要将这个数组分成 k 个非空的连续子数组。
//设计一个算法使得这 k 个子数组各自和的最大值最小。

/*
输入：nums = [7,2,5,10,8], k = 2
输出：18
解释：
一共有四种方法将 nums 分割为 2 个子数组。 
其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。

输入：nums = [1,2,3,4,5], k = 2
输出：9

输入：nums = [1,4,4], k = 3
输出：4
*/

//这道题和上面讲的运输问题是一模一样的，不相信的话我给你改写一下题目：
//你只有一艘货船，现在有若干货物，每个货物的重量是 nums[i]，现在你需要在 m 天内将这些货物运走，请问你的货船的最小载重是多少？
//等同于：货船每天运走的货物就是 nums 的一个子数组；在 m 天内运完就是将 nums 划分成 m 个子数组；让货船的载重尽可能小，就是让所有子数组中最大的那个子数组元素之和尽可能小。

class Solution{
  public int splitArray(int[] nums, int m){
    return shipWithinDays(nums, m);
  }

  int shipWithinDays(int[] weights, int days){
    int left = 0;
    int right = 1;
    for(int w : weights){
      left = Math.max(left, w);
      right += w;
    }

    while(left<right){
      int mid = left + (right-left)/2;
      if(f(weights, mid)<=days){
        right = mid;
      }else{
        left = mid + 1;
      }
    }
    return left;
  }

  int f(int[] weights, int x){
    int days = 0;
    for(int i=0; i<weights.length; ){
      int cap = x;
      while(i<weights.length){
        if(cap<weights[i]) break;
        else cap -= weights[i];
        i++;
      }
      day++;
    }
    return days;
  }
}
