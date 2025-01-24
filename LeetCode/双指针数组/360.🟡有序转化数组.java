//题目：给你一个已经 排好序 的整数数组 nums 和整数 a 、 b 、 c 。对于数组中的每一个元素 nums[i] ，计算函数值 f(x) = ax2 + bx + c ，请 按升序返回数组 。

/*
输入: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
输出: [3,9,15,33]

输入: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
输出: [-23,-5,1,7]

进阶：你可以在时间复杂度为 O(n) 的情况下解决这个问题吗？
*/

class Solution{
  public int[] sortTransformedArray(int[] nums, int a, int b, int c){
    //双指针，相向而行，逼近对称轴
    int i = 0;
    int j = nums.length-1;

    // 如果开口朝上，越靠近对称轴函数值越小
    // 如果开口朝下，越靠近对称轴函数值越大
    int p = a > 0 ? nums.length-1 : 0;
    int[] res = new int[nums.length];

    //执行合并两个有序数组的逻辑
    while(i<=j){
      int v1 = f(nums[i], a, b, c);
      int v2 = f(nums[j], a, b, c);
      if(a>0){
        //如果开口朝上，越靠近对称轴函数值越小
        if(v1>v2){
          res[p--] = v1;
          i++;
        }else{
          res[p--] = v2;
          j--;
        }
      }else{
        //如果开口朝下，越靠近对称轴函数值越大
        if(v1>v2){
          res[p++] = v2;
          j--;
        }else{
          res[p++] = v1;
          i++;
        }
      }
    }
    return res;
  }

  int f(int x, int a, int b, int c){
    return a*x*x + b*x + c;
  }
}
