int binarySearch(int[] nums, int target){
  int left = 0;
  int right = ...;

  while(...){
    int mid = left + (right - left)/2;
    if(nums[mid]==target){ ... }
    else if(nums[mid]<target){ left=... }
    else if(nums[mid]>target){ right=... }
  }
  return ...;
}

//缺陷：
/*
给你有序数组 nums = [1,2,2,2,3]，target 为 2，此算法返回的索引是 2，没错。但是如果我想得到 target 的左侧边界，即索引 1，或者我想得到 target 的右侧边界，即索引 3，这样的话此算法是无法处理的。
这样的需求很常见，你也许会说，找到一个 target，然后向左或向右线性搜索不行吗？可以，但是不好，因为这样难以保证二分查找对数级的复杂度了。
*/
