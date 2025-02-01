//题目：给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
//提醒一下，二叉搜索树满足下列约束条件：
//节点的左子树仅包含键 小于 节点键的节点。
//节点的右子树仅包含键 大于 节点键的节点。
//左右子树也必须是二叉搜索树。

/*
输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]

输入：root = [0,null,1]
输出：[1,null,1]

输入：root = [1,0,2]
输出：[3,3,2]

输入：root = [3,2,4,1]
输出：[7,9,4,10]
*/

//利用BST的中序遍历特性，BST 的中序遍历代码可以升序打印节点的值，那如果我想降序打印节点的值怎么办？
//很简单，只要把递归顺序改一下，先遍历右子树，后遍历左子树就行了

class Solution{
  TreeNode convertBST(TreeNode root){
    traverse(root);
    return root;
  }

  //记录累加和
  int sum = 0;
  void traverse(TreeNode root){
    if(root==null) return;
    traverse(root.right);
    //维护累加和
    sum += root.val;
    //将BST转化为累加树
    root.val = sum;
    traverse(root.left);
  }
}
