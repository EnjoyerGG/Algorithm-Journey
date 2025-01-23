//题目：nums 中可能有多对儿元素之和都等于 target，请你的算法返回所有和为 target 的元素对儿。
//其中元素对不能出现重复。

/*
输入： [1,3,1,2,2,3], target = 4
输出：[[1,3],[2,2]]
*/

//关键难点是现在可能有多个和为 target 的数对儿，还不能重复，比如上述例子中 [1,3] 和 [3,1] 就算重复，只能算一次。

List<List<Integer>> twoSumTarget(int[] nums, int target){
  Arrays.sort(nums);
  List<List<Integer>> res = new ArrayList<>();
  int low = 0;
  int high = nums.length-1;

  while(low<high){
    int sum = nums[low] + nums[high];
    int left = nums[low];
    int right = nums[high];

    //在if的时候就跳过相同元素
    if(sum<target){
      while (low < high && nums[low] == left) low++;
    }else if(sum>target){
      while (low < high && nums[high] == right) high--;
    }else{
      res.add(new ArrayList<>(Arrays.asList(left, right)));
      // 跳过所有重复的元素
        while (low < high && nums[low] == left) low++;
        while (low < high && nums[high] == right) high--;
    }
  }
  return res;
}

//时间复杂度为O(NlogN)
