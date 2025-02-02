//题目：给定一棵二叉树的根节点 root 以及两个整数 p 和 q ，返回该二叉树中值为 p 的结点与值为 q 的结点间的 距离 。
//两个结点间的 距离 就是从一个结点到另一个结点的路径上边的数目。

/*
输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 0
输出：3
解释：在 5 和 0 之间有 3 条边：5-3-1-0

输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 7
输出：2
解释：在 5 和 7 之间有 2 条边：5-2-7

输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 5
输出：0
解释：一个结点与它本身之间的距离为 0
*/

class Solution{
  public int findDistance(TreeNode root, int p, int q){
    lca(root, p, q);
    return res;
  }

  boolean found = false;
  int res = 0;

  //定义：当子树中不包含 p 或 q 时，返回 0；
  // 当子树中仅包含 p 或 q 中的一个时，返回 root 到 p 或 q 的距离；
  // 当子树中同时包含 p 和 q 时，返回一个无意义的值（答案会被存在外部变量 res 中）
  int lca(TreeNode root, int p, int q){
    if(found){
      //found为true时答案已经被记录在全局res中
      //递归函数的返回值已不需要了，此时返回什么值都无所谓
      return 123;
    }
    if(root==null){
      return 0;
    }

    int left = lca(root.left, p, q);
    int right = lca(root.right, p, q);

    if(left==0 && right==0){
      //root的左右子树都不包含p或q
      if(root.val==p || root.val==q){
        return 1;
      }
      return 0;
    }

    if(left!=0 && right!=0 && !found){
      //当前节点root就是p，q的最近公共祖先节点
      //答案已经算出来了，更新全局变量
      res += left + right;
      //这个递归函数的返回值已经不重要了，让它终止递归
      found = true;
      return 456;
    }

    //此时left和right有一个为0，即只找到了一个节点
    //branch就是到该节点的距离
    int branch = left == 0 ? right : left;

    if(root.val==p || root.val==q){
      res = branch;
    }

    return branch + 1;
  }
}
























