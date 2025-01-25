//题目：给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长连续子数组长度。如果不存在任意一个符合要求的子数组，则返回 0。

/*
输入: nums = [1,-1,5,-2,3], k = 3
输出: 4 
解释: 子数组 [1, -1, 5, -2] 和等于 3，且长度最长。

输入: nums = [-2,-1,2,1], k = 1
输出: 2 
解释: 子数组 [-1, 2] 和等于 1，且长度最长。
*/

//翻译一下就是：
//寻找 i, j 使得 preSum[i] - preSum[j] == k 且 i - j 尽可能的大。
//另外，preSum[i] - preSum[j] == k 其实就是 preSum[j] == preSum[i] - k。
//所以我们使用一个哈希表，记录 preSum[i] 的值以及这个前缀和第一次出现的索引，就可以迅速判断 preSum[i] 是否符合条件并计算最长子数组长度了。

class Solution{
  public static int maxSubArrayLen(int[] nums, int k){
    int n = nums.length;
    //preSum中的值 -> 对应的最小索引
    //比如preSum = [2,4,1,3,4]，preSumToIndex[4]=1

    HashMap<Integer, Integer> preSumToIndex = new HashMap<>();
    int maxLen = 0;
    //前缀和数组（在这道题中可以优化为一个变量）
    
    int preSum = 0;
    //base case，这样索引相减的时候可以算出正确的子数组长度
    preSumToIndex.put(0, -1);

    for(int i=0; i<n; i++){
      //计算前缀和，维护preSum = sum(nums[0...i])
      preSum += nums[i];
      preSumToIndex.putIfAbsent(preSum, i); //确保preSumToIndex中记录的索引是第一次出现的位置
      int need = preSum - k;
      if(preSumToIndex.containsKey(need)){
        int j = preSumToIndex.get(need);
        //nums[j...i]是和为k的子数组
        maxLen = Math.max(maxLen, i-j);
      }
    }
    return maxLen;
  }
}













    



