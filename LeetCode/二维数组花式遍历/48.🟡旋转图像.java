//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像

//关键：原地修改

/*
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[[7,4,1],[8,5,2],[9,6,3]]

输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

提示：
n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
*/


//常规的思路就是去寻找原始坐标和旋转后坐标的映射规律.
//但我们是否可以让思维跳跃跳跃，尝试把矩阵进行反转、镜像对称等操作，可能会出现新的突破口。

class Solutiotn{
  //将二维矩阵原地顺时针旋转90度
  public void rotate(int[][] matirx){
    int n = matrix.length;
    //沿着对角线镜像对称二维矩阵
    for(int i=0; i<n; i++){
      for(int j=i; j<n; j++){
        //swap(matrix[i][j], matrix[j][i])
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
    //反转二维矩阵的每一行
    for(int[] row : matrix){
      reverse(row);
    }

    //反转一维数组
    void reverse(int[] arr){
      int i = 0;
      int j = arr.length-1;
      while(j>i){
        //swap(arr[i], arr[j])
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }
  }
  }

