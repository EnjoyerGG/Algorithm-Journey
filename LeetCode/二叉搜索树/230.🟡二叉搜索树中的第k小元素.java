//题目：给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
//BST，除了它的定义，还有一个重要的性质：BST 的中序遍历结果是有序的（升序）。

/*
输入：root = [3,1,4,null,2], k = 1
输出：1

输入：root = [5,3,6,2,4,null,null,1], k = 3
输出：3

进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
*/
//一个直接的思路就是升序排序，然后找第 k 个元素

class Solution{
  int kthSmallest(TreeNode root, int k){
    //利用BST的中序遍历特性
    traverse(root, k);
    return res;
  }

  //记录结果
  int res = 0;
  //记录当前元素的排名
  int rank = 0;
  void traverse(TreeNode root, int k){
    if(root==null) return;
    traverse(root.left, k);
    //中序代码位置
    rank++;
    if(k==rank){
      //找到第k小的元素
      res = root.val;
      return;
    }
    traverse(root.right, k);
  }
}






    
