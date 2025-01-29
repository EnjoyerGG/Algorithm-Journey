//题目：整数数组 nums 按升序排列，数组中的值 互不相同 。
//在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
//给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1。
//你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。

/*
输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4

输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1

输入：nums = [1], target = 0
输出：-1
*/

//把一个排好序的数组就好比一段斜向上的山坡，沿着一个元素旋转数组，相当于将山坡切断并旋转，在原本平滑的山坡上产生一个「断崖」：
//「断崖」左侧的所有元素比右侧所有元素都大，我们是可以在这样一个存在断崖的山坡上用二分搜索算法搜索元素的，主要分成两步：
//1、确定 mid 中点落在「断崖」左侧还是右侧。
//2、在第 1 步确定的结果之上，根据 target 和 nums[left], nums[right], nums[mid] 的相对大小收缩搜索区间。

class Solution{
  public int search(int[] nums, int target){
    //左右都闭的搜索区间
    int left = 0;
    int right = nums.length - 1;

    //因为是闭区间，所以结束条件为left > right
    while(left <= right){
      int mid = left + (right - left)/2;
      //首先检查nums[mid]，是否找到target
      if(nums[mid] == target){
        return mid;
      }

      if(nums[mid] >= nums[left]){
        //mid落在断崖左边，此时nums[left...mid]有序
        if(target >= nums[left] && target < nums[mid]){
          //target落在[left...mid-1]中
          right = mid - 1;
        }else{
          //target落在[mid+1...right]中
          left = mid + 1;
        }
      }else{
        //mid落在断崖右边，此时nums[mid...right]有序
        if(target <= nums[right] && target > nums[mid]){
          //target落在[mid+1...right]中
          left = mid + 1;
        }else{
          //target落在[left...mid-1]中
          right = mid - 1;
        }
      }
    }
    //当while结束还没找到，说明target不存在
    return -1;
  }
}



  
