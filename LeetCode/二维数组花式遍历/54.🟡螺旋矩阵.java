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







  
