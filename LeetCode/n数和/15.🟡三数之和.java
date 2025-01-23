//题目：给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0。
//请你返回所有和为 0 且不重复的三元组。
//注意：答案中不可以包含重复的三元组。

/*
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。

输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。

输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。

提示：
3 <= nums.length <= 3000
-105 <= nums[i] <= 105
*/

//泛化，求三和为target的元组，不止是0
class Solution{
  public List<List<Integer>> threeSumTarget(int[] nums, int target){
    //数组先排序
    Arrays.sort(nums);
    int n = nums.length;
    List<List<Integer>> res = new ArrayList<>();

    //穷举threeSum的第一个数
    for(int i=0; i<n; i++){
      //对target-nums[i]计算twoSum
      List<List<Integer>> tuples = twoSumTarget(nums, i+1, target-nums[i]);
      //如果存在满足条件的二元组，再加上nums[i]就是结果三元组
      for(List<Integer> tuple : tuples){
        tuple.add(nums[i]);
        res.add(tuple);
      }
      //跳过第一个数字重复的情况，否则会出现重复结果
      while(i<n-1 && nums[i]==nums[i+1]) i++;
    }
    return res;
  }

  List<List<Integer>> twoSumTarget(int[] nums, int start, int target){
    //左指针改为从start开始，其他不变
    int low = start;
    int high = nums.length-1;
    List<List<Integer>> res = new ArrayList<>();
    while(low<high){
      ...
    }
    return res;
  }

//避免重复的关键点在于，不能让第一个数重复，至于后面的两个数，我们复用的 twoSumTarget 函数会保证它们不重复。所以代码中必须用一个 while 循环来保证 3Sum 中第一个元素不重复。
//至此，3Sum 问题就解决了，时间复杂度不难算，排序的复杂度为 O(NlogN)。 
//twoSumTarget 函数中的双指针操作为 O(N)，threeSumTarget 函数在 for 循环中调用 twoSumTarget 所以总的时间复杂度就是 O(NlogN+N ^2)=O(N^2)。


