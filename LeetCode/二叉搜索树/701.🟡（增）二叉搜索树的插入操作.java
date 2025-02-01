//题目：给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
//注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果。

/*
输入：root = [4,2,7,1,3], val = 5
输出：[4,2,7,1,3,5]

输入：root = [40,20,60,10,30,50,70], val = 25
输出：[40,20,60,10,30,50,70,null,null,25]

输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
输出：[4,2,7,1,3,5]
*/

class Solution{
  public TreeNode insertIntoBST(TreeNode root, int val){
    if(root==null){
      //找到空位置插入新节点
      return new TreeNode(val);
    }

  //去右子树找插入位置
  if(root.val < val){
    root.right = insertIntoBST(root.right, val);
  }
  //去左子树找插入位置
  if(root.val > val){
    root.left = insertIntoBST(root.left, val);
  }
  //返回root, 上层递归会接受返回值作为子节点
  return root;
  }
}
