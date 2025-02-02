//题目：给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。

/*
输入：n = 3
输出：5

输入：n = 1
输出：1
*/

//二叉树算法的关键就在于明确根节点需要做什么，其实 BST 作为一种特殊的二叉树，核心思路也是一样的。

class Solution{
  //备忘录
  //用于消除重叠子问题
  int[][] memo;

  public int numTrees(int n){
    //备忘录的值初始化为0
    memo = new int[n+1][n+1];
    return count(1, 0);
  }

  //定义：计算闭区间[low, high]组成从BST的个数
  int count(int low, int high){
    if(low > high) return 1;
    //查备忘录
    if(memo[low][high]!=0){
      return memo[low][high];
    }

    int res = 0;
    for(int mid=low; mid<=high; mid++){
      int left = count(low, mid-1);
      int right = count(mid+1, high);
      res += left * right;
    }
    //将结果存入备忘录
    memo[low][high] = res;

    return res;
  }
}















    
  
