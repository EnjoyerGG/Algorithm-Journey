//题目：给你二叉搜索树的根节点 root 和一个目标值 target ，请在该二叉搜索树中找到最接近目标值 target 的数值。如果有多个答案，返回最小的那个。

/*
输入：root = [4,2,5,1,3], target = 3.714286
输出：4

输入：root = [1], target = 4.428571
输出：1
*/

class Solution{
  int res = Integer.MAX_VALUE;

  public int closestValue(TreeNode root, double target){
    traverse(root, target);
    return res;
  }

  //遍历函数，在BST中搜索target
  //我们在中序位置写if判断逻辑，这样就可以从小到大执行，保证最终结果是值最小的
  void traverse(TreeNode root, double target){
    if(root==null) return;
    // 根据 target 和 root.val 的相对大小决定去左右子树搜索
    if(root.val < target){
      //中序位置（左子树遍历结束，准备遍历右子树时）
      if(Math.abs(root.val - target) < Math.abs(res - target)){
        res = root.val;
      }

    //如果target比root大，那么root的左子树差值肯定更大，直接遍历右子树
    traverse(root.right, target);
    }else{
      //如果target比root小，那么root的右子树差值肯定更大，直接遍历左子树
      traverse(root.left, target);

      //中序位置（左子树遍历结束，准备遍历右子树时）
      if(Math.abs(root.val - target) < Math.abs(res - target)){
        res = root.val;
      }
    }
  }
}
