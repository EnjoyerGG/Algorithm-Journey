/*
二叉树解题的思维分为两类：
1.是否能通过遍历一遍二叉树得到答案？如果可以，用一个traverse函数配合外部变量来实现，这叫"遍历"的思维模式。
2.是否可以定义一个递归函数，通过子问题的答案推导出原问题的答案？如果可以，写出这个递归函数的定义，并充分利用这个函数的返回值，这叫"分解问题"的思维模式。
*/

//题目：给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。

/*
输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]

输入：root = [2,1,3]
输出：[2,3,1]

输入：root = []
输出：[]
*/

//用第一种思维：
class Solution{
  //主函数
  public TreeNode invertTree(TreeNode root){
    //遍历二叉树，交换每个节点的子节点
    traverse(root);
    return root;
  }

  //二叉树遍历函数
  void traverse(TreeNode root){
    if(root==null){ return; }

    //前序位置
    //每个节点需要做的事就是交换它的左右子节点
    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;

    //遍历框架，去遍历左右子树的节点
    traverse(root.left);
    traverse(root.right);
  }
}

//用第二种思维：
class Solution{
  public TreeNode invertTree(TreeNode root){
    if(root==null){ return null; }
    //利用函数优势，先翻转左右子树
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);

    //然后交换左右子节点
    root.left = right;
    root.right = left;

    //和定义逻辑自洽，以root为根的这棵二叉树已经被翻转，返回root
    return root;
  }
}

















