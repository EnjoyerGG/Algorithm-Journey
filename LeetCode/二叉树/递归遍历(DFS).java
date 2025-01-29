//递归遍历的顺序，即 traverse 函数访问节点的顺序确实是固定的。正如上面那个可视化面板，root 指针在树上移动的顺序是固定的。
//但是你在 traverse 函数中不同位置写代码，效果是可以不一样的。前中后序遍历的结果不同，原因是因为你把代码写在了不同位置，所以产生了不同的效果。

//框架：
class TreeNode{
  int val;
  TreeNode left, right;
}

void traverse(TreeNode root){
  if(root == null) { return; }
  traverse(root.left);
  traverse(root.right);
}

//常用于寻找所有路径的问题
