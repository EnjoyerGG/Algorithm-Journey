//题目：编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
//每行的元素从左到右升序排列。
//每列的元素从上到下升序排列。

/*
输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
输出：true

输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
输出：false

提示：
m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-109 <= matrix[i][j] <= 109
每行的所有元素从左到右升序排列
每列的所有元素从上到下升序排列
-109 <= target <= 109
*/


//相对于从左上角开始，从右上角开始更简单。
//如果向左移动，元素在减小，如果向下移动，元素在增大，这样的话我们就可以根据当前位置的元素和 target 的相对大小来判断应该往哪移动，不断接近从而找到 target 的位置。

class Solution{
  public boolean searchMatrix(int[][] matrix, int target){
    int m = matrix.length;
    int n = matrix[0].length;
    //初始化在右上角
    int i = 0;
    int j = n - 1;
    while(i<m && j>=0){
      if(matrix[i][j] == target){
        return true;
      }
      if(matrix[i][j]<target){
        //需要大一点，往下移动
        i++;
      }
      else{
        //需要小一点，往左移动
        j--;
      }
    }
    //没找到，则target不存在
    return false;
  }
}






  
