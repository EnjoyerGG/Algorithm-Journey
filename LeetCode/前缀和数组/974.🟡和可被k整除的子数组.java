//题目：给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的非空 子数组 的数目。
//子数组 是数组中 连续 的部分。

/*
输入：nums = [4,5,0,-2,-3,1], k = 5
输出：7
解释：
有 7 个子数组满足其元素之和可被 k = 5 整除：
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

输入: nums = [5], k = 9
输出: 0
*/

class Solution{
  public int subarraysDivByK(int[] nums, int k){
    int n = nums.length;
    //nums的前缀和数组，注意索引偏移，preSum[i]的值为sum(nums[0...i-1])
    int[] preSum = new int[n+1];

    //前缀和余数的计数器，方便快速查找所需的前缀和余数的数量
    HashMap<Integer, Integer> remainderToCount = new HashMap<>();
    preSum[0] = 0;
    remainderToCount.put(0, 1);

    //计算nums的前缀和余数并更新计数器
    int res = 0;
    for(int i=0; i<n; i++){
      //计算nums[0...i]的前缀和
      preSum[i+1] = preSum[i] + nums[i];
      //nums[0...i]的所有元素之和与k的余数
      int curRemainder = preSum[i+1] % k;
      if(curRemainder<0){
        // 考虑到 preSum[i + 1] 可能是负数，根据 Java 求模的特性，-2 % 3 的结果是 -2
        // 但我们实际想要正余数 1，所以这里需要对 curRemainder 进行调整。
        curRemainder += k;
      }

      //看看之前 nums[0..i-1] 中是否也存在前缀和余数为 curRemainder 的子数组
      if(remainderToCount.containsKey(curRemainder)){
        //如果存在，则说明找到了可以整除k的子数组，累加子数组数量
        int count = remainderToCount.get(curRemainder);
        res += count;
        remainderToCount.put(curRemainder, count+1);
      }else{
        //如果不存在，那么nums[0...i]是第一个前缀和余数为curRemainder的子数组
        remainderToCount.put(curRemainder, 1);
      }
    }
    return res;
  }
}











  
