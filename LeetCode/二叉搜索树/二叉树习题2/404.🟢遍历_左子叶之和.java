//题目：给定二叉树的根节点 root ，返回所有左叶子之和。

/*
输入: root = [3,9,20,null,null,15,7] 
输出: 24 
解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24

输入: root = [1]
输出: 0
*/

class Solution{
  public int sumOfLeftLeaves(TreeNode root){
    traverse(root);
    return sum;
  }

  //记录左叶子之和
  int sum = 0;
  //二叉树遍历函数
  void traverse(TreeNode root){
    if(root==null) return;
    if(root.left!=null && root.left.left==null && root.left.right==null){
      //找到左侧的叶子节点，记录累加值
      sum += root.left.val;
    }

  //递归框架
  traverse(root.left);
  traverse(root.right);
  }
}




  
