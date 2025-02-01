//题目：给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。

/*
输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
输出: [3,9,20,null,null,15,7]

输入: preorder = [-1], inorder = [-1]
输出: [-1]
*/

//我们肯定要想办法确定根节点的值，把根节点做出来，然后递归构造左右子树即可。

class Solution{
  //存储inorder中值到索引的映射
  HashMap<Integer, Integer> valToIndex = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder){
    for(int i=0; i<inorder.length; i++){
      valToIndex.put(inorder[i], i);
    }
    return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
  }

  //build函数的定义
  //若前序遍历数组为preorder[preStart...preEnd]
  //中序遍历数组为inorder[inStart...inEnd]
  //构造二叉树，返回二叉树的根节点
  TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
    if(preStart>preEnd){
      return null;
    }

    //root节点对应的值就是前序遍历数组的第一个元素
    int rootVal = preorder[preStart];
    //rootVal在中序遍历数组中索引
    int index = valToIndex.get(rootVal);

    int leftSize = index - inStart;

    //先构造出当前根节点
    TreeNode root = new TreeNode(rootVal);
    //递归构造左右子树
    root.left = build(preorder, preStart+1, preStart+leftSize, inorder, inStart, index-1);
    root.right = build(preorder, preStart+leftSize+1, preEnd, inorder, index+1, inEnd);

    return root;
  }
}












  
