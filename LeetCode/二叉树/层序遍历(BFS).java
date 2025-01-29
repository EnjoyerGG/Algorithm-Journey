//框架
void levelOrderTraverse(TreeNode root){
  if(root == null){ return; }
  Queue<TreeNode> q = new LinkedList<>();
  q.offer(root);
  //记录当前遍历到的层数(根节点视为第一层)
  int depth = 1;

  while(!q.isEmpty()){
    int sz = q.size();
    for(int i=0; i<sz; i++){
      TreeNode cut = q.poll(); //poll函数用于检索并删除队列头部元素
      System.out.println("depth = " + depth + ", val = " + cur.val);

      //把cur左右子节点加入队列
      if(cur.left!=null){
        q.offer(cur.left); //offer函数用于向尾部添加元素
      }
      if(cur.right!=null){
        q.offer(cur.right);
      }
    }
    depth++;
  }
}

//常用于寻找最短路径问题




