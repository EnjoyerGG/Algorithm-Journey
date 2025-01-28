int left_bound(int[] nums, int target){
  int left = 0;
  int right = nums.length; //注意

  while(left<right){
    int mid = left + (right-left)/2;
    if(nums[mid]==target){
      right = mid;
    }
    else if(nums[mid]<target){
      left = mid + 1;
    }
    else if(nums[mid]>target){
      right = mid; //注意
    }
  }
  return left;
}

//注意：
//为什么 while 中是 < 而不是 <=？
//答：用相同的方法分析，因为 right = nums.length 而不是 nums.length - 1。因此每次循环的「搜索区间」是 [left, right) 左闭右开。
//while(left < right) 终止的条件是 left == right，此时搜索区间 [left, left) 为空，所以可以正确终止。

//如果 target 不存在，搜索左侧边界的二分搜索返回的索引是大于 target 的最小索引。
//举个例子，nums = [2,3,5,7], target = 4，left_bound 函数返回值是 2，因为元素 5 是大于 4 的最小元素。

//为什么该算法能够搜索左侧边界？
//关键在于对于 nums[mid] == target 这种情况的处理。
//找到 target 时不要立即返回，而是缩小「搜索区间」的上界 right，在区间 [left, mid) 中继续搜索，即不断向左收缩，达到锁定左侧边界的目的。

//left_bound 的这个行为有一个好处。比方说现在让你写一个 floor 函数，就可以直接用 left_bound 函数来实现：
// 在一个有序数组中，找到「小于 target 的最大元素的索引」
// 比如说输入 nums = [1,2,2,2,3]，target = 2，函数返回 0，因为 1 是小于 2 的最大元素。
// 再比如输入 nums = [1,2,3,5,6]，target = 4，函数返回 2，因为 3 是小于 4 的最大元素。
int floor(int[] nums, int target) {
    // 当 target 不存在，比如输入 [4,6,8,10], target = 7
    // left_bound 返回 2，减一就是 1，元素 6 就是小于 7 的最大元素
    // 当 target 存在，比如输入 [4,6,8,8,8,10], target = 8
    // left_bound 返回 2，减一就是 1，元素 6 就是小于 8 的最大元素
    return left_bound(nums, target) - 1;
}
