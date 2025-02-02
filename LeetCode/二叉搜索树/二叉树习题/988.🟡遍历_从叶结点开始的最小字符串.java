//题目：给定一颗根结点为 root 的二叉树，树中的每一个结点都有一个 [0, 25] 范围内的值，分别代表字母 'a' 到 'z'。
//返回 按字典序最小 的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
//注：字符串中任何较短的前缀在 字典序上 都是 较小 的：
//例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。 

/*
输入：root = [0,1,2,3,4,3,4]
输出："dba"

输入：root = [25,1,3,1,3,0,2]
输出："adz"

输入：root = [2,2,1,null,1,0,null,0]
输出："abc"
*/

//代码看起来虽然多，但思路非常简单：用 path 维护递归遍历的路径，到达叶子节点的时候判断字典序最小的路径。
//不要忘了在叶子节点的时候也要正确维护 path 变量，而且要把 StringBuilder 中的字符串反转才是题目想要的答案。


class Solution{
  public String smallestFromLeaf(TreeNode root){
    traverse(root);
    return res;
  }
  //遍历过程中的路径
  StringBuilder path = new StringBuilder();
  String res = null;

  //二叉树遍历函数
  void traverse(TreeNode root){
    if(root==null) return;
    if(root.left==null && root.right==null){
      //找到叶结点，比较字典序最小的路径
      //结果字符是从叶子向根，所以需要反转
      path.append((char)('a' + root.val));
      path.reverse();

      String s = path.toString();
      if(res==null || res.compareTo(s)>0){
        //如果字典序更小，则更新res
        res = s;
      }

      //恢复，正确维护path中的元素
      path.reverse();
      path.deleteCharAt(path.length()-1);
      return;
    }
    
    //前序位置
    path.append((char)('a' + root.val));

    traverse(root.left);
    traverse(root.right);

    //后序位置
    path.deleteCharAt(path.length()-1);
  }
}

















