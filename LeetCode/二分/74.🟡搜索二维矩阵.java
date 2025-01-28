//题目：给你一个满足下述两条属性的 m x n 整数矩阵：
//每行中的整数从左到右按非严格递增顺序排列。
//每行的第一个整数大于前一行的最后一个整数。
//给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false。

/*
输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
输出：true

输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
输出：false
*/

class Solution{
  public boolean searchMatrix(int[][] matrix, int target){
    int m = matrix.length;
    int n = matrix[0].length;
    //把二维数组映射到一维
    int left = 0;
    int right = m * n - 1;

    //标准二分搜索框架
    while(left<=right){
      int mid = left + (right-left)/2;
      if(get(matrix, mid)==target){
        return true;
      }else if(get(matrix, mid)<target){
        left = mid + 1;
      }else if)get(matrix, mid)>target){
        right = mid - 1;
      }
      return false;
    }

    //通过一维坐标访问二维数组的元素
    int get(int[][] matrix, int index){
      int m = matrix.length;
      int n = matrix[0].length;
      //计算二维中的横纵坐标
      int i = index / n;
      int j = index % n;
      return matrix[i][j];
    }
  }














  
