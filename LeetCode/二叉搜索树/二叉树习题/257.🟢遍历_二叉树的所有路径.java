//题目：给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//叶子节点 是指没有子节点的节点。

/*
输入：root = [1,2,3,null,5]
输出：["1->2->5","1->3"]

输入：root = [1]
输出：["1"]
*/

class Solution{
  public List<String> binaryTreePaths(TreeNode root){
    //遍历一遍二叉树出结果
    traverse(root);
    return res;
  }

  //记录traverse函数递归的路径
  LinkedList<String> path = new LinkedList<>();
  //记录所有从根节点到叶子节点的路径
  LinkedList<String> res = new LinkedList<>();

  void traverse(TreeNode root){
    if(root==null) return;

    //root是叶子节点
    if(root.left==null && root.right==null){
      path.addLast(root.val + "");
      //将这条路径装入res
      res.addLast(String.join("->", path);
      path.removeLast();
      return;
    }

    //前序遍历位置
    path.addLast(root.val + "");
    //递归遍历左右子树
    traverse(root.left);
    traverse(root.right);
    //后序遍历位置
    path.removeLast();
  }
}
    
