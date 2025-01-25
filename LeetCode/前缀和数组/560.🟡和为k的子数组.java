//题目：给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
//子数组是数组中元素的连续非空序列。

/*
输入：nums = [1,1,1], k = 2
输出：2

输入：nums = [1,2,3], k = 3
输出：2
*/

class Solution{
  public int subarraySum(int[] nums, int k){
    int n = nums.length;
    //前缀和数组
    int[] preSum = new int[n+1];
    preSum[0] = 0;

    //前缀和到该前缀和出现次数的映射，方便快速查找所需的前缀和
    HashMap<Integer, Integer> count = new HashMap<>();
    count.put(0, 1);
    //记录和为k的子数组个数
    int res = 0;

    //计算nums的前缀和
    for(int i=1; i<=n; i++){
      preSum[i] = preSum[i-1] + nums[i-1];
      //如果之前存在值为need的前缀和
      //说明存在以nums[i-1]结尾的子数组的和为k
      int need = preSum[i] - k;
      if(count.containsKey(need)){
        res += count.get(need); //获取该前缀和出现的次数，并将结果累加到结果res中
      }

      //将当前前缀和存入哈希表
      if(!count.containsKey(preSum[i])){
        count.put(preSum[i], 1); //如果当前前缀和 preSum[i] 尚未出现在哈希表中，将其插入，次数为 1。
      }else{
        count.put(preSum[i], count.get(preSum[i])+1); //如果已存在，则将其计数加 1。
      }
    }
    return res;
  }
}
