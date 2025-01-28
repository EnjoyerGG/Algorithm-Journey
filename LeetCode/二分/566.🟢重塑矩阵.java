//题目：在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
//给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
//重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
//如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。

/*
输入：mat = [[1,2],[3,4]], r = 1, c = 4
输出：[[1,2,3,4]]

输入：mat = [[1,2],[3,4]], r = 2, c = 4
输出：[[1,2],[3,4]]
*/

//任何多维数组都可以被映射到一维，所以甭管几维数组，你统一把多维的坐标转化成一维，然后再从一维坐标转化到多维。

class Solution{
  public int[][] matrixReshape(int[][] mat, int r, int c){
    int m = mat.length;
    int n = mat[0].length;
    //想要成功reshape，元素个数应该相同
    if(r * c != m * n){
      return mat;
    }

    int[][] res = new int[r][c];
    for(int i=0; i<m*n; i++){
      set(res, i, get(mat, i));
    }
    return res;
  }

  //通过一维坐标访问二维数组中的元素
  int get(int[][] matrix, int index){
    int m = matrix.length;
    int n = matrix[0].length;
    //计算二维中的横纵坐标
    int i = index / n;
    int j = index % n;
    return matrix[i][j];
  }

  //通过一维坐标设置二维数组中的元素
  void set(int[][] matrix, int index, int value){
    int m = matrix.length;
    int n = matrix[0].length;
    //计算二维中的横纵坐标
    int i = index / n;
    int j = index % n;
    matrix[i][j] = value;
  }
}


