//题目：给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
//每次「迁移」操作将会引发下述活动：
//位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
//位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
//位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
//请你返回 k 次迁移操作后最终得到的 二维网格。

/*
输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
输出：[[9,1,2],[3,4,5],[6,7,8]]

输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]

输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
输出：[[1,2,3],[4,5,6],[7,8,9]]
*/

//可以写一个 get 方法和 set 方法把二维数组抽象成一维数组，然后题目就变成了让你将一个一维的数组平移 k 位，相当于把前 mn - k 个元素的位置和后 k 个元素的位置对调。
//也可以先把整个数组翻转，再分别翻转前 mn - k 个元素和后 k 个元素，得到的结果就是题目想要的。

class Solution{
  public List<List<Integer>> shiftGrid(int[][] grid, int k){
    //把二维grid抽象成一维数组
    int m = grid.length;
    int n = grid[0].length;
    int mn = m*n;
    k = k%mn;

    //先把最后k个数翻转
    reverse(grid, mn-k, mn-1);
    //然后把前mn-k个数翻转
    reverse(grid, 0, mn-k-1);
    //最后把整体翻转
    reverse(grid, 0, mn-1);

    //转化成Java list
    List<List<Integer>> res = new ArrayList<>();
    for(int[] row : grid){
      List<Integer> rowList = new ArrayList<>();
      for(int e : row){
        rowList.add(e);
      }
      res.add(rowList);
    }
    return res;
  }

  //通过一维数组的索引访问二维数组元素
  int get(int[][] grid, int index){
    int n = grid[0].length;
    int i = index/n;
    int j = index%n;
    return grid[i][j];
  }

  //通过一维数组的索引修改二维数组的元素
  void set(int[][] grid, int index, int val){
    int n = grid[0].length;
    int i = index/n;
    int j = index%n;
    grid[i][j] = val;
  }

  //翻转一维数组的索引区间元素
  void reverse(int[][] grid, int i, int j){
    while(i<j){
      int temp = get(grid, i);
      set(grid, i, get(grid, j));
      set(grid, j, temp);
      i++;
      j--;
    }
  }
}
    
  
