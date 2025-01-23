class Solution{
  public void rotate2(int[][] matrix){
    int n = matrix.length;
    //沿左下到右上的对角线镜像对称二维矩阵
    for(int i=0; i<n; i++){
      for(int j=0; j<n-i; j++){
        //swap(matrix[i][j], matrix[n-j-1][n-i-1])
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n-j-1][n-i-1];
        matrix[n-j-1][n-i-1] = temp;
      }
    }

    //反转二维矩阵每一行
    for(int[] row : matrix){
      reverse(row);
    }

    void reverse(int[] arr){
      ...
    }
}
