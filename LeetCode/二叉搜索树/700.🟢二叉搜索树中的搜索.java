//题目：给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
//你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。

/*
输入：root = [4,2,7,1,3], val = 2
输出：[2,1,3]

输入：root = [4,2,7,1,3], val = 5
输出：[]
*/

TreeNode searchBST(TreeNode root, int target){
  if(root==null) return null;
  //去左子树搜索
  if(root.val>target){
    return searchBST(root.left, target);
  }
  //去右子树搜索
  if(root.val<target){
    return searchBST(root.right, target);
  }
  //当前节点就是目标值
  return root;
}
