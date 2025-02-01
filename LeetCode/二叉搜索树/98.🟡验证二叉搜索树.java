//题目：给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//有效 二叉搜索树定义如下：
//节点的左子树只包含 小于 当前节点的数。
//节点的右子树只包含 大于 当前节点的数。
//所有左子树和右子树自身必须也是二叉搜索树。

/*
输入：root = [2,1,3]
输出：true

输入：root = [5,1,4,null,null,3,6]
输出：false
解释：根节点的值是 5 ，但是右子节点的值是 4 。
*/

class Solution{
  public boolean isValidBST(TreeNode root){
    return _isValidBST(root, null, null);
  }

  //定义：该函数返回root为根的子树的所有节点是否满足max.val>root.val>min>val
  public boolean _isValidBST(TreeNode root, TreeNode min, TreeNode max){
    //base case
    if(root==null) return true;
    //若root.val不符合max和min的限制，说明不是合法的BST
    if(min!=null && root.val<=min.val) return false;
    if(max!=null && root.val>=max.val) return false;
    //根据定义，限定左子树的最大值是root.val，右子树的最小值为root.val
    return _isValidBST(root.left, min, root) && _isValidBST(root.right, root, max);
  }
}
    
