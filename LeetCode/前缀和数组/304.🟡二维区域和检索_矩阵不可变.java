//给定一个二维矩阵 matrix，以下类型的多个请求：
//计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。

//实现 NumMatrix 类：
//NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
//int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下角 (row2, col2) 所描述的子矩阵的元素 总和。

/*
输入: 
["NumMatrix","sumRegion","sumRegion","sumRegion"]
[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
输出: 
[null, 8, 11, 12]

解释:
NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]);
numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
*/

class NumMatrix{
  //preSum[i][j]记录矩阵[0,0,i-1,j-1]的元素和
  private int[][] preSum;

  public NumMatrix(int[][] matrix){
    int m = matrix.length;
    int n = matrix[0].length;

    if(m==0 || n==0){
      return;
    }
    //构造前缀和矩阵
    preSum = new int[m+1][n+1];
    for(int i=1; i<=m; i++){
      for(int j=1; j<=n; j++){
        //计算每个矩阵[0,0,i,j]的元素和
        preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] + matrix[i-1][j-1] - preSum[i-1][j-1];
      }
    }
  }

  //计算子矩阵[x1,y1,x2,y2]的元素和
  public int sumRegion(int x1, int y1, int x2, int y2){
    //目标矩阵之和由四个相邻矩阵运算获得
    return preSum[x2+1][y2+1] - preSum[x1][y2+1] - preSum[x2+1][y1] + preSum[x1][y1];
  }
}
