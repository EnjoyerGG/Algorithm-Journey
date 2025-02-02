//题目：给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
//请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。

/*
输入：root = [2,3,1,3,1,null,1]
输出：2 
解释：上图为给定的二叉树。总共有 3 条从根到叶子的路径：红色路径 [2,3,3] ，绿色路径 [2,1,1] 和路径 [2,3,1] 。
     在这些路径中，只有红色和绿色的路径是伪回文路径，因为红色路径 [2,3,3] 存在回文排列 [3,2,3] ，绿色路径 [2,1,1] 存在回文排列 [1,2,1] 。

输入：root = [2,1,1,1,3,null,null,null,null,null,1]
输出：1 
解释：上图为给定二叉树。总共有 3 条从根到叶子的路径：绿色路径 [2,1,1] ，路径 [2,1,3,1] 和路径 [2,1] 。
     这些路径中只有绿色路径是伪回文路径，因为 [2,1,1] 存在回文排列 [1,2,1] 。

输入：root = [9]
输出：1
*/

//关键：如果一组数字中，只有最多一个数字出现的次数为奇数，剩余数字的出现次数均为偶数，那么这组数字可以组成一个回文串。

class Solution{
  public int pseudoPalindromicPaths(TreeNode root){
    traverse(root);
    return res;
  }

  //计数数组，题目说了1 <= root.val <= 9
  int[] count = new int[10];
  int res = 0;

  //二叉树遍历函数
  void traverse(TreeNode root){
    if(root==null) return;

    if(root.left==null && root.right==null){
      //遇到叶子节点，判断路径是否为伪回文串
      count[root.val]++;
      //如果路径上出现奇数次的数字个数大于1，则不可能组成回文串，反之则可以组成回文串
      int odd = 0;
      for(int n : count){
        if(n % 2 == 1){
          odd++;
        }
      }
      if(odd <= 1){
        res++;
      }
      count[root.val]--;
      return;
    }

    count[root.val]++;
    //二叉树遍历框架
    traverse(root.left);
    traverse(root.right);

    count[root.val]--;
  }
}















  
