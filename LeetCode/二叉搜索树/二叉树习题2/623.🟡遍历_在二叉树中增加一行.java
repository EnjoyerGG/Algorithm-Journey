//题目：给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。
//注意，根节点 root 位于深度 1 。
//加法规则如下:
//给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
//cur 原来的左子树应该是新的左子树根的左子树。
//cur 原来的右子树应该是新的右子树根的右子树。
//如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。

/*
输入: root = [4,2,6,3,1,5], val = 1, depth = 2
输出: [4,1,1,2,null,null,6,3,1,5]

输入: root = [4,2,null,3,1], val = 1, depth = 3
输出:  [4,2,null,1,1,3,null,null,1]
*/

class Solution{
  private int targetVal, targetDepth;

  public TreeNode addOneRow(TreeNode root, int val, int depth){
    targetVal = val; 
    targetDepth = depth;
    //插入到第一行的话特殊对待一下
    if(targetDepth==1){
      TreeNode newroot = new TreeNode(targetVal);
      newRoot.left = root;
      return newRoot;
    }
    //遍历二叉树，走到对应行进行插入
    traverse(root);

    return root;
  }

  private int curDepth = 0;

  void traverse(TreeNode root){
    if(root==null){ return; }
    //前序遍历
    curDepth++;
    if(curDepth == targetDepth - 1){
      //进行插入
      TreeNode newLeft = new TreeNode(targetVal);
      TreeNode newRight = new TreeNode(targetVal);
      newLeft.left = root.left;
      newRight.right = root.right;
      root.left = newLeft;
      root.right = newRight;
    }

    traverse(root.left);
    traverse(root.right);

    //后序遍历
    curDepth--;
  }
}















  
