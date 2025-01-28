int right_bound(int[] nums, int target){
  int left = 0;
  int right = nums.length;

  while(left<right){
    int mid = left + (right-left)/2;
    if(nums[mid]==target){
      left = mid + 1; //注意，可以想成mid=left-1
    }
    else if(nums[mid]<target){
      left = mid + 1;
    }
    else if(nums[mid]>target){
      right = mid;
    }
  }
  return left - 1; //注意
}

//为什么返回 left - 1？
//为什么最后返回 left - 1 而不像左侧边界的函数，返回 left？而且我觉得这里既然是搜索右侧边界，应该返回 right 才对。
//答：首先，while 循环的终止条件是 left == right，所以 left 和 right 是一样的，你非要体现右侧的特点，返回 right - 1 好了。

//当 target 不存在时，right_bound 返回值的含义
//直接说结论，和前面讲的 left_bound 相反：如果 target 不存在，搜索右侧边界的二分搜索返回的索引是小于 target 的最大索引。
