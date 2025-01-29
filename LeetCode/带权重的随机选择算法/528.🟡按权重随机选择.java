//题目：给你一个 下标从 0 开始 的正整数数组 w ，其中 w[i] 代表第 i 个下标的权重。
//请你实现一个函数 pickIndex ，它可以 随机地 从范围 [0, w.length - 1] 内（含 0 和 w.length - 1）选出并返回一个下标。选取下标 i 的 概率 为 w[i] / sum(w) 。
//例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。

/*
输入：
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
输出：
[null,1,1,1,1,0]
解释：
Solution solution = new Solution([1, 3]);
solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
solution.pickIndex(); // 返回 1
solution.pickIndex(); // 返回 1
solution.pickIndex(); // 返回 1
solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。

由于这是一个随机问题，允许多个答案，因此下列输出都可以被认为是正确的:
[null,1,1,1,1,0]
[null,1,1,1,1,1]
[null,1,1,1,0,0]
[null,1,1,1,0,1]
[null,1,0,1,0,0]
......
诸若此类。
*/

//思路：根据权重数组w生成前缀和数组preSum
//生成一个取值在preSum之内的随机数，用二分搜索算法寻找大于等于这个随机数的最小元素索引。
//最后对这个索引减一（因为前缀和和数组有一位索引偏移），就可以作为权重数组的索引，即最终答案
//如图：https://labuladong.online/algo/images/random-weight/5.jpeg

class Solution{
  //前缀和数组
  private int[] preSum;
  private Random rand = new Random();

  public Solution(int[] w){
    int n = w.length;
    //构建前缀和数组，偏移一位留给preSum[0]
    preSum = new int[n+1];
    preSum[0] = 0;
    //preSum[i] = Sum(w[0...i-1])
    for(int i=1; i<=n; i++){
      preSum[i] = preSum[i-1] + w[i-1];
    }
  }

  public int pickIndex(){
    int n = preSum.length;
    //Java 的 nextInt(n) 方法在 [0, n) 中生成一个随机整数
    // 再加一就是在闭区间 [1, preSum[n - 1]] 中随机选择一个数字
    int target = rand.nextInt(preSum[n-1])+1;
    //获取target在前缀和数组preSum中的索引
    //别忘了前缀和数组preSum和原始数组w有一位索引偏移
    return left_bound(preSum, target) - 1;
  }

  //搜索左侧边界的二分搜索
  private int left_bound(int[] nums, int target){
    int left = 0;
    int right = nums.length;
    while(left<right){
      int mid = left + (right-left)/2;
      if(nums[mid]==target){
        right = mid;
      }else if(nums[mid]<target){
        left = mid + 1;
      }else if(nums[mid]>target){
        right = mid;
      }
    }
    return left;
  }
}
























