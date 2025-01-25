//题目：给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
//题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
//请 不要使用除法，且在 O(n) 时间复杂度内完成此题。

/*
输入: nums = [1,2,3,4]
输出: [24,12,8,6]

输入: nums = [-1,1,0,-3,3]
输出: [0,0,9,0,0]

进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
*/

//我们构造一个 prefix 数组记录「前缀积」，再用一个 suffix 记录「后缀积」，根据前缀和后缀积就能计算除了当前元素之外其他元素的积。

class Solution{
  public int[] productExceptSelf(int[] nums){
    int n = nums.length;
    //从左到右的前缀积，prefix[i]是nums[0...i]的元素积
    int[] prefix = new int[n];
    prefix[0] = nums[0];
    for(int i=1; i<nums.length; i++){
      prefix[i] = prefix[i-1] * nums[i];
    }
    
    //从右到左的前缀积，suffix[i]是nums[i...n-1]的元素积
    int[] suffix = new int[n];
    suffix[n-1] = nums[n-1];
    for(int i=n-2; i>=0; i--){
      suffix[i] = suffix[i+1] * nums[i];
    }

    //结果数组
    int[] res = new int[n];
    res[0] = suffix[1];
    res[n-1] = prefix[n-2];
    for(int i=1; i<n-1; i++){
      //除了nums[i]自己的元素积就是nums[i]左侧和右侧所有元素之积
      res[i] = prefix[i-1] * suffix[i+1];
    }
    return res;
  }
}
      












    
    
