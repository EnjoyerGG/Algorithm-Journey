//题目：给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

/*
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]

提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/

class Soulution{
  public List<Integer> spiralOrder(int[][] matrix){
    int m = matrix.length;
    int n = matrix[0].length;
    int upper_bound = 0;
    int lower_bound = m-1;
    int left_bound = 0;
    int right_bound = n-1;
    List<Integer> res = new LinkedList<>();

    //res.size()==m*n则遍历完整个数组
    while(res.size()<m*n){
      if(upper_bound<=lower_bound){
        //在顶部从左向右遍历
        for(int j=left_bound; j<=right_bound; j++){
          res.add(matrix[upper_bound][j]);
        }
        //上边界下移
        upper_bound++;
      }

      if(left_bound<=right_bound){
        //在右侧从上往下遍历
        for(int i=upper_bound; i<=lower_bound; i++){
          res.add(matrix[i][right_bound]);
        }
        //右边界左移
        right_bound--;
      }

      if(upper_bound<=lower_bound){
        //在底部从右向左遍历
        for(int j=right_bound; j>=left_bound; j--){
          res.add(matrix[lower_bound][j]);
        }
        //下边界上移
        lower_bound--;
      }

      if(left_bound<=right_bound){
        //在左侧从下向上遍历
        for(int i=lower_bound; i>=upper_bound; i--){
          res.add(matrix[i][left_bound]);
        }
        //左边界右移
        left_bound++;
      }
    }
    return res;
  }
}







  
