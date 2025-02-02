//题目：给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

/*
输入: [1,2,3,null,5,null,4]
输出: [1,3,4]

输入: [1,null,3]
输出: [1,3]

输入: []
输出: []
*/

class Solution{
  //BFS层序遍历解法
  public List<Integer> rightSideView(TreeNode root){
    List<Integer> res = new LinkedList<>();
    if(root==null) return res;

    //BFS层序遍历，计算右侧视图
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    //while循环控制从上向下一层层遍历
    while(!q.isEmpty()){
      int sz = q.size();
      //每一层头部就是最右侧的元素
      TreeNode last = q.peek();
      for(int i=0; i<sz; i++){
        TreeNode cur = q.poll();
        //控制每一层从右向左遍历
        if(cur.right!=null){
          q.offer(cur.right);
        }
        if(cur.left!=null){
          q.offer(cur.left);
        }
      }
      //每一层的最后一个节点就是二叉树的右侧视图
      res.add(last.val);
    }
    return res;
  }






  //*******************************************************************************
  //DFS递归遍历解法
  List<Integer> res = new ArrayList<>();
  //记录递归的层数
  int depth = 0;

  public List<Integer> rightSideView_DFS(TreeNode root){
    traverse(root);
    return res;
  }
  //二叉树遍历函数
  void traverse(TreeNode root){
    if(root==null) return;
    //前序遍历位置
    depth++;
    if(res.size() < depth){
      //这一层还没有记录值
      //说明root就是右侧视图的第一个节点
      res.add(root.val);
    }
    //注意，这里反过来，先遍历右子树再遍历左子树
    //这样首先遍历的一定是右侧节点
    traverse(root.right);
    traverse(root.left);
    //后序遍历位置
    depth--;
  }
}











    
