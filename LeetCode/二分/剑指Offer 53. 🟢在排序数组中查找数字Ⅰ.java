//题目：某班级考试成绩按非严格递增顺序记录于整数数组 scores，请返回目标成绩 target 的出现次数。

/*
输入: scores = [2, 2, 3, 4, 4, 4, 5, 6, 6, 8], target = 4
输出: 3

输入: scores = [1, 2, 3, 5, 7, 9], target = 6
输出: 0
*/

class Solution{
  public int search(int[] nums, int target){
    int left_index = left_bound(nums, target);
    if(left_index == -1){
      return 0;
    }
    int right_index = right_bound(nums, target);
    //根据左右边界即可推导出元素出现的次数
    return right_index - left_index + 1;
  }

  int left_bound(int[] nums, int target){
    int left = 0;
    int right = nums.length - 1;
    //搜索区间为[left, right]
    while(left<=right){
      int mid = left + (right - left ) / 2;
      if(nums[mid] < target){
        //搜索区间变为[mid+1, right]
        left = mid + 1;
      }
      else if(nums[mid] > target){
        //搜索区间变为[left, mid - 1]
        right = mid - 1;
      }
      else if(nums[mid] == target){
        //收缩右侧边界
        right = mid - 1;
      }
    }
    //检查出界情况
    if(left >= nums.length || nums[left] != target){
      return -1;
    }
    return left;
  }

  int right_bound(int[] nums, int target){
    int left = 0;
    int right = nums.length - 1;
    while(left <= right){
      int mid = left + (right - left) / 2;
      if(nums[mid] < target){
        left = mid + 1;
      }
      else if(nums[mid] > target){
        right = mid - 1;
      }
      else if(nums[mid] == target){
        //这里改成收缩左侧边界即可
        left = mid + 1;
      }
    }
    //这里改为检查right越界的情况
    if(right<0 || nums[right] != target){
      return -1;
    }
    return right;
  }
}
      
