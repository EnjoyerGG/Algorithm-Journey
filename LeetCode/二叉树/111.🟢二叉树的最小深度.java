//题目：给定一个二叉树，找出其最小深度。
//最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//说明：叶子节点是指没有子节点的节点。

/*
输入：root = [3,9,20,null,null,15,7]
输出：2

输入：root = [2,null,3,null,4,null,5,null,6]
输出：5

提示：
树中节点数的范围在 [0, 105] 内
-1000 <= Node.val <= 1000
*/

//DFS算法更加简洁，但需要遍历完所有节点才能找到最短路径
class Solution{
  //记录最小深度(根节点到最近的叶子节点的距离)
  private int minDepth = Integer.MAX_VALUE;
  //记录当前遍历到的节点深度
  private int currentDepth = 0;

  public int minDepth(TreeNode root){
    if(root == null){ return 0; }
    //从根节点开始DFS遍历
    traverse(root);
    return minDepth;
  }

  private void traverse(TreeNode root){
    if(root == null){ return; }
    //前序位置进入节点时增加当前深度
    currentDepth++;
    //如果当前节点是叶子节点，更新最小深度
    if(root.left == null && root.right == null){
      minDepth = Math.min(minDepth, currentDepth);
    }

    traverse(root.left);
    traverse(root.right);

    //后序位置离开节点时减少当前深度
    currentDepth--;
  }
}

//形象地说，它是从左到右，一条树枝一条树枝进行遍历的

//而BFS算法在第一次遇到目标节点时，所经过的路径就是最短路径，算法可能不需要遍历完所有节点就能提前结束
class Solution{
  public int minDepth(TreeNode root){
    if(root == null){ return 0; }
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    //root本身就是一层，depth初始化为1
    int depth = 1;

    while(!q.isEmpty()){
      int sz = q.size();
      //遍历当前层的节点
      for(int i=0; i<sz; i++){
        TreeNode cur = q.poll();
        //判断是否到达叶子节点
        if(cur.left == null && cur.right == null){
          return depth;
        }
        //将下一层节点加入队列
        if(cur.left!=null){
          q.offer(cur.left);
        }
        if(cur.right!=null){
          q.offer(cur.right);
        }
      }
      //增加步数
      depth++;
    }
    return depth;
  }
}

















