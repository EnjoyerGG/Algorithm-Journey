//题目：给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：
//i - k <= r <= i + k,
//j - k <= c <= j + k 且
//(r, c) 在矩阵内。

/*
输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
输出：[[12,21,16],[27,45,33],[24,39,28]]

输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
输出：[[45,45,45],[45,45,45],[45,45,45]]
*/

//通过 min, max 函数优雅避免索引越界
class Solution{
  public int[][] matrixBlockSum(int[][] mat, int k){
    int m = mat.length;
    int n = mat[0].length;
    NumMatrix numMatrix = new NumMatrix(mat);
    int[][] res = new int[m][n];
    for(int i=0; i<m; i++){
      for(int j=0; j<n; j++){
        //左上角坐标
        int x1 = Math.max(i-k, 0);
        int y1 = Math.max(j-k, 0);
        //右下角坐标
        int x2 = Math.min(j+k, m-1);
        int y2 = Math.min(j+k, n-1);

        res[i][j] = numMatrix.sumRegion(x1, y1, x2, y2);
      }
    }
    return res;
  }
}

class NumMatrix{
  //定义：preSum[i][j]记录matrix中子矩阵[0,0,i-1,j-1]元素和
  private int[][] preSum;

  public NumMatrix(int[][] matrix){
    int m = matrix.length;
    int n = matrix[0].length;
    if(m==0 || n==0) return;

    //构造前缀和矩阵
    preSum = new int[m+1][n+1];
    for(int i=1; i<=m; i++){
      for(int j=1; j<=n; j++){
        //计算每个矩阵[0,0,i,j]的元素和
        preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] + matrix[i-1][j-1] - preSum[i-1][j-1];










