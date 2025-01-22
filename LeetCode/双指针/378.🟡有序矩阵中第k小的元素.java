//题目：给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
//请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
//你必须找到一个内存复杂度优于 O(n2) 的解决方案。

//思路：双指针
//是前文23.🟡合并K个升序链表的变体。

/*
输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
输出：13
解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13

输入：matrix = [[-5]], k = 1
输出：-5

提示：
n == matrix.length
n == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列
1 <= k <= n2
*/

//矩阵中的每一行都是排好序的，就好比多条有序链表，你用优先级队列施展合并多条有序链表的逻辑就能找到第 k 小的元素了。

class Solution{
  public int kthSmallest(int[][] matrix, int k){
    //存储二元组(matrix[i][j], i, j)
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{return a[0]-b[0]}); //lambda表达式，当为正值时，a排在b后

    //初始化优先级队列，把每一行的第一个元素装进去
    for(int i=0; i<matrix.length; i++){
      pq.offer(new int[]{matrix[i][0], i, 0});
    }

    int res = -1;
    //执行合并多个有序链表的逻辑，找到第k小的元素
    while(!pq.isEmpty() && k>0){
      int[] cur = pq.poll(); //获取并移除队列中的头元素（优先级最高的元素）
      res = cur[0];
      k--;
      //链表的中的下一个节点加入优先级队列
      int i = cur[1];
      int j = cur[2];
      if(j+1<matrix[i].length){
        pq.add(new int[]{matrix[i][j+1], i, j+1});
      }
    }
    return res;
  }
}

//.offer和.add不太懂，先放着



