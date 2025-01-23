//n数和模板
// 注意：调用这个函数之前一定要先给 nums 排序
// n 填写想求的是几数之和，start 从哪个索引开始计算（一般填 0），target 填想凑出的目标和
List<List<Integer>> nSumTarget(int[] nums, int n, int start, long target){
  int sz = nums.length;
  list<List<Integer>> res = new ArrayList<>();
  //至少是2Sum，并且数组大小不应该小于n
  if(n<2 || sz<n) return res;
  //2Sum是base case
  if(n==2){
    int low = start;
    int high = sz - 1;
    while(low<high){
      int sum = nums[low] + nums[high];
      int left = nums[low];
      int right = nums[high];
      if(sum<target){
        while(low<high && nums[low]==left) low++;
      }else if(sum>target){
        while(low<high && nums[high]==right) high--;
      }else{
        res.add(new ArrayList<>(Arrays.asList(left, right)));
        while(low<high && nums[low]==left) low++;
        while(low<high && nums[high]==right) high--;
      }
    }
  }else{
    //n>2时，递归计算(n-1)Sum的结果
    for(int i=start; i<sz; i++){
      List<List<Integer>> sub = nSumTarget(nums, n-1, i+1, target-nums[i]);
      for(List<Integer> arr : sub){
        //(n-1)Sum加上nums[i]就是nSum
      arr.add(nums[i]);
      res.add(arr);
      }
      while(i<sz-1 && nums[i]==nums[i+1]) i++;
    }
  }
  return res;
}

//当4数和时
public List<List<Integer>> fourSum(int[] nums, int target){
  Arrays.sort(nums);
  return nSumTarget(nums,4,0,target);
}

//100数和时
public List<List<Integer>> 100Sum(int[] nums, int target){
  Arrays.sort(nums);
  return nSumTarget(nums,100,0,target);
}
    
