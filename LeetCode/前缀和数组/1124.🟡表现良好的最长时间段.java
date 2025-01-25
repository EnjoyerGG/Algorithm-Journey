//题目：给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
//我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
//所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
//请你返回「表现良好时间段」的最大长度。

/*
输入：hours = [9,9,6,0,6,6,9]
输出：3
解释：最长的表现良好时间段是 [9,9,6]。

输入：hours = [6,6,6]
输出：0
*/

//题目说 hours[i] 以 8 作为分界线，那么我们就要条件反射地想到对数据进行「归一化」处理。
//比如把所有大于 8 的元素视为 +1，把所有小于 8 的元素视为 -1。
//这样一来，这道题就改造成了：计算数组中元素和大于 0 的子数组的最大长度。
//然后回想之前子数组相关的题目，第 525. 连续数组 是问和为 0 的子数组，974. 和可被 K 整除的子数组 是问和能被 k 整除的子数组，这道题和它们很类似，都是考察前缀和 + 哈希表的组合场景。

class Solution{
  public int longestWPI(int[] hours){
    int n = hours.length;
    int[] preSum = new int[n+1];
    preSum[0] = 0;

    //前缀和到索引的映射，方便快速查找所需的前缀和
    HashMap<Integer, Integer> valToIndex = new HashMap<>();
    int res = 0;
    for(int i=1; i<=n; i++){
      preSum[i] = preSum[i-1] + (hours[i-1] > 8 ? 1 : -1);

      //如果这个前缀和还没有对应的索引，说明这个前缀和第一次出现，记录下来
      if(!valToIndex.containsKey(preSum[i])){
        valToIndex.put(preSum[i], i);
      }else{
        // 因为题目想找长度最大的子数组，valToIndex 中的索引应尽可能小，
        // 所以这里什么都不做
      }

      //现在我们想找hours[0...i-1]中元素和大于0的子数组
      //这就要根据preSum[i]的正负分情况讨论了
      if(preSum[i]>0){
        //preSum[i]为正，说明hours[0...i-1]都是 表现良好的时间段
        res = Math.max(res, i);
      }else{
        //preSum[i]为负，需要寻找一个j使得preSum[i] - preSum[j] > 0
        //考虑到我们的preSum数组每两个相邻元素的差的绝对值都是1且j应该尽可能小
        //那么只要找到 preSum[j] == preSum[i] - 1，nums[j+1..i] 就是一个「表现良好的时间段」
        if(valToIndex.containsKey(preSum[i]-1)){
          int j = valToIndex.get(preSum[i]-1);
          res = Math.max(res, i-j);
        }
      }
    }
    return res;
  }
}
        












  
