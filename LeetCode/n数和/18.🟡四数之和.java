//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
//请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
/*
0 <= a, b, c, d < n
a、b、c 和 d 互不相同
nums[a] + nums[b] + nums[c] + nums[d] == target
你可以按 任意顺序 返回答案。
  */

/*
输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

输入：nums = [2,2,2,2,2], target = 8
输出：[[2,2,2,2]]
*/

//思路相同，先穷举第一个数字，再调用3Sum函数计算剩下三个数
class Solution{
  public List<List<Integer>> fourSum(int[] nums, int target){
    Array.sort(nums);
    int n = nums.length;
    List<List<Integer>> res = new ArrayList<>();

  //穷举第一个数
  for(int i=0; i<n; i++){
    List<List<Integer>> triples = threeSumTarget(nums, i+1, target-nums[i]);
    //如果存在满足条件的三元组，再加上nums[i]就是结果四元组
    for(List<Integer> triple : triples){
      triple.add(nums[i]);
      res.add(triple);
    }
    //fourSum第一个数不能重复
    while(i<n-1 && nums[i]==nums[i+1]) i++;
  }
    return res;
}

// 从 nums[start] 开始，计算有序数组 nums 中所有和为 target 的三元组
List<List<Integer>> threeSumTarget(int[] nums, int start, long target) {
    int n = nums.length;
    List<List<Integer>> res = new ArrayList<>();
    // i 从 start 开始穷举，其他都不变
    for (int i = start; i < n; i++) {
        ...
    }
    return res;
  }
}
