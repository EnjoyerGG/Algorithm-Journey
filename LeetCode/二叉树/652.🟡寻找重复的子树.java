//题目：给你一棵二叉树的根节点 root ，返回所有 重复的子树 。
//对于同一类的重复子树，你只需要返回其中任意 一棵 的根结点即可。
//如果两棵树具有 相同的结构 和 相同的结点值 ，则认为二者是 重复的。

/*
输入：root = [1,2,3,4,null,2,4,null,null,4]
输出：[[2,4],[4]]

输入：root = [2,1,1]
输出：[[1]]

输入：root = [2,2,2,3,null,3,null]
输出：[[2,3],[3]]
*/

//先思考：对于某一个节点，它应该做什么。
//要知道以自己为根的子树长啥样，是不是得先知道我的左右子树长啥样，再加上自己，就构成了整棵子树的样子？左右子树的样子，可不就得在后序位置通过递归函数的返回值传递回来吗？
//其次思考：我知道了自己长啥样，怎么知道别人长啥样？这样我才能知道有没有其他子树跟我重复对吧。
//我们借助一个外部数据结构，让每个节点把自己子树的序列化结果存进去，这样，对于每个节点，不就可以知道有没有其他节点的子树和自己重复了么？

class Solution{
  //记录所有子树以及出现的次数
  HashMap<String, Integer> subTrees = new HashMap<>();
  //记录重复的子树根节点
  LinkedList<TreeNode> res = new LinkedList<>();

  //主函数
  public List<TreeNode> findDuplicateSubtrees(TreeNode root){
    serialize(root);
    return res;
  }

  //辅助函数
  String serialize(TreeNode root){
    if(foot==null){ return "#"; }
    //先算左右子树的序列化结果
    String left = serialize(root.left);
    String right = serialize(root.right);

    String myself = left + "," + right + "," + root.val;

    int freq = subTree.getOrDefault(myself, 0);
    //多次重复也只会被加入结果集一次
    if(freq==1){ res.add(root); }
    
    //给子树对应的出现次数加1
    subTrees.put(myself, freq+1);
    return myself;
  }
}
