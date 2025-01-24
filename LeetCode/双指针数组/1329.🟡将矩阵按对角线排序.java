//题目：矩阵对角线 是一条从矩阵最上面行或者最左侧列中的某个元素开始的对角线，沿右下方向一直到矩阵末尾的元素。例如，矩阵 mat 有 6 行 3 列，从 mat[2][0] 开始的 矩阵对角线 将会经过 mat[2][0]、mat[3][1] 和 mat[4][2] 。
//给你一个 m * n 的整数矩阵 mat ，请你将同一条 矩阵对角线 上的元素按升序排序后，返回排好序的矩阵。

/*
输入：mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
输出：[[1,1,1,1],[1,2,2,2],[1,2,3,3]]

输入：mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]
输出：[[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]
*/

//关键：在同一个对角线上的元素，其横纵坐标之差是相同的。你画图看看，或者稍微想想就能明白：右下角走一步横纵坐标都会加一，所以他们的差肯定不会变。
//有了这个规律辅助，这道题就很容易做了，我直接用一个哈希表把每个对角线的元素存起来，想办法排序，最后放回二维矩阵上即可。

class Solution{
  public int[][] diagonalSort(int[][] mat){
    int m = mat.length;
    int n = mat[0].length;

    //存储所有对角线的元素列表
    HashMap<Integer, ArrayList<Integer>> diagonals = new HashMap<>();

    for(int i=0; i<m; i++){
      for(int j=0; j<n; j++){
        //横坐标之差可以作为一条对角线的ID
        int diagonalID = i-j;
        diagnoals.putIfAbsent(diagonalID, new ArrayList<>());
        diagonals.get(diagonalID).add(mat[i][j]);
      }
    }

    //从数组末尾删除元素的效率较高，所以我们把ArrayList倒序排序
    for(List<Integer> diagonal: diagonals.values()){
      Collections.sort(diagonal, Collections.reverseOrder());
    }

    //把排序结果回填二维矩阵
    for(int i=0; i<m; i++){
      for(int j=0; j<n; j++){
        ArrayList<Integer> diagonal = diagonals.get(i-j);
        mat[i][j] = diagonal.remove(diagonal.size()-1);
      }
    }
    return mat;
  }
}
