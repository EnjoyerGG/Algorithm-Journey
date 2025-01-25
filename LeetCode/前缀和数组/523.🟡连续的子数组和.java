//题目：给你一个整数数组 nums 和一个整数 k ，如果 nums 有一个 好的子数组 返回 true ，否则返回 false：
//一个 好的子数组 是：
//长度 至少为 2 ，且子数组元素总和为 k 的倍数。

//注意：
//子数组 是数组中 连续 的部分。
//如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终 视为 k 的一个倍数。

/*
输入：nums = [23,2,4,6,7], k = 6
输出：true
解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。

输入：nums = [23,2,6,4,7], k = 6
输出：true
解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。 
42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。

输入：nums = [23,2,6,4,7], k = 13
输出：false
*/

//翻译一下就是：
//寻找 i, j 使得 (preSum[i] - preSum[j]) % k == 0 且 i - j >= 2。
//另外，(preSum[i] - preSum[j]) % k == 0 其实就是 preSum[i] % k == preSum[j] % k。
//所以我们使用一个哈希表，记录 preSum[j] % k 的值以及对应的索引，就可以迅速判断 preSum[i] 是否符合条件了。

class Solution{
  public boolean checkSubarraySum(int[] nums, int k){
    int n = nums.length;
    //计算nums的前缀和
    int[] preSum = new int[n+1];
    preSum[0] = 0;
    for(int i=1; i<=n; i++){
      preSum[i] = preSum[i-1] + nums[i-1];
    }

    //前缀和与k的余数到索引的映射，方便快速查找所需的前缀和
    HashMap<Integer, Integer> valToIndex = new HashMap<>();
    for(int i=0; i<preSum.lenght; i++){
      //哈希表中记录余数
      int val = preSum[i] % k;
      //如果这个于数还没有对应的索引，则记录下来
      if(!valToIndex.containsKey(val)){
        valToIndex.put(val, i);
      }
      //如果这个前缀和已经有对应的索引了，则什么都不做
      //因为题目想找长度最大的子数组，所以前缀和索引应尽可能小
    }

    int res = 0;
    for(int i=1; i<preSum.length; i++){
      //计算need，使得(preSum[i] - need) % k == 0
      int need = preSum[i] % k;
      if(valToIndex.containsKey(need)){
        if(i - valToIndex.get(need) >= 2){
          //这个子数组的长度至少为2
          return true;
        }
      }
    }
    return false;
  }
}














