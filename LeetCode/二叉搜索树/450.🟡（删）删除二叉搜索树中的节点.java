//题目：给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
//一般来说，删除节点可分为两个步骤：
//首先找到需要删除的节点；
//如果找到了，删除它。

/*
输入：root = [5,3,6,2,4,null,7], key = 3
输出：[5,4,6,2,null,null,7]
解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
另一个正确答案是 [5,2,6,null,4,null,7]。

输入: root = [5,3,6,2,4,null,7], key = 0
输出: [5,3,6,2,4,null,7]
解释: 二叉树不包含值为 0 的节点

输入: root = [], key = 0
输出: []
*/

//找到目标节点了，比方说是节点 A，如何删除这个节点，这是难点。因为删除节点的同时不能破坏 BST 的性质。有三种情况。
class Solution{
  public TreeNode deleteNode(TreeNode root, int key){
    if(root==null) return null;
    if(root.val==key){
      //情况1：A 恰好是末端节点，两个子节点都为空，那么它可以当场去世了。
      //情况2：A 只有一个非空子节点，那么它要让这个孩子接替自己的位置。
      if(root.left==null) return root.right;
      if(root.right==null) return root.left;

      //情况3：A 有两个子节点，麻烦了，为了不破坏 BST 的性质，A 必须找到左子树中最大的那个节点，或者右子树中最小的那个节点来接替自己。
      //获得右子树最小的节点
      TreeNode minNode = getMin(root.right);
      //删除右子树最小的节点
      root.right = deleteNode(root.right, minNode.val);
      //用右子树最小的节点替换root节点
      minNode.left = root.left;
      minNode.right = root.right;
      root = minNode;
    }else if(root.val > key){
      root.left = deleteNode(root.left, key);
    }else if(root.val < key){
      root.right = deleteNode(root.right, key);
    }
    return root;
  }

  TreeNode getMin(TreeNode node){
    //BST最左边就是最小的
    while(node.left!=null) node = node.left;
    return node;
  }
}
    
