//题目：给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。

/*
输入：n = 3
输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]

输入：n = 1
输出：[[1]]
*/

//这道题的思路也是一样的：
//1、穷举 root 节点的所有可能。
//2、递归构造出左右子树的所有有效 BST。
//3、给 root 节点穷举所有左右子树的组合。

class Solution{
  //主函数
  public List<TreeNode> generateTrees(int n){
    if(n==0) return new LinkedList<>();
    //构造闭区间[1, n]组成的BST
    return build(1, n);
  }

  //构造闭区间[low, high]组成BST
  List<TreeNode> build(int low, int high){
    List<TreeNode> res = new LinkedList<>();
    //base case
    if(low>high){
      // 这里需要装一个 null 元素，这样才能让下面的两个内层 for 循环都能进入，正确地创建出叶子节点
      // 举例来说吧，什么时候会进到这个 if 语句？当你创建叶子节点的时候，对吧。
      // 那么如果你这里不加 null，直接返回空列表，那么下面的内层两个 for 循环都无法进入
      // 你的那个叶子节点就没有创建出来，看到了吗？所以这里要加一个 null，确保下面能把叶子节点做出来
      res.add(null);
      return res;
    }

    //1.穷举root节点的所有可能
    for(int i=low; i<=high; i++){
      //2.递归构造出左右子树的所有有效BST
      List<TreeNode> leftTree = build(low, i-1);
      List<TreeNode> rightTree = build(i+1, high);
      //3.给root节点穷举所有左右子树的组合
      for(TreeNode left : leftTree){
        for(TreeNode right : rightTree){
          //i作为根节点root的值
          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;
          res.add(root);
        }
      }
    }
    return res;
  }
}
















  
