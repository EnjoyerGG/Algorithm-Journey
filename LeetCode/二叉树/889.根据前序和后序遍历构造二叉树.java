//题目：给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
//如果存在多个答案，您可以返回其中 任何 一个。

/*
输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
输出：[1,2,3,4,5,6,7]

输入: preorder = [1], postorder = [1]
输出: [1]
*/

//关键：通过前序中序，或者后序中序遍历结果可以确定唯一一棵原始二叉树，但是通过前序后序遍历结果无法确定唯一的原始二叉树。
//1、首先把前序遍历结果的第一个元素或者后序遍历结果的最后一个元素确定为根节点的值。
//2、然后把前序遍历结果的第二个元素作为左子树的根节点的值。
//3、在后序遍历结果中寻找左子树根节点的值，从而确定了左子树的索引边界，进而确定右子树的索引边界，递归构造左右子树即可。

class Solution{
  //存储postorder中值到索引的映射
  HashMap<Integer, Integer> valToIndex = new HashMap<>();

  public TreeNode constructFromPrePost(int[] preorder, int[] postorder){
    for(int i=0; i<postorder.length; i++){
      valToIndex.put(postorder[i], i);
    }
    return build(preorder, 0, preorder.length-1, postorder, 0, postorder.length-1);
  }

  //定义：根据preorder[preStart...preEnd]和postorder[postStart...postEnd]
  //创建二叉树，饼返回根节点
  TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd){
    if(preStart>preEnd){ return null; }
    if(preStart==preEnd){ return new TreeNode(preorder[preStart]); }
  
    //root节点对应的值就是前序遍历数组的第一个元素
    int rootVal = preorder[preStart];
    //root.left的值是前序遍历第二个元素
    //通过前序和后序遍历构造二叉树的关键在于通过左子树的根节点
    //确实preorder和postorder中左右子树的元素区间
    int leftRootVal = preorder[preStart+1];
    //leftRootVal在后序遍历数组中的索引
    int index = valToIndex.get(leftRootVal);
    //左子树的元素个数
    int leftSize = index - postStart + 1;

    //先构造出当前根节点
    TreeNode root = new TreeNode(rootVal);
    //递归构造左右子树
    //根据左子树的根节点索引和元素个数推导左右子树的索引边界
    root.left = build(preorder, preStart+1, preStart+leftSize, postorder, postStart, index);
    root.right = build(preorder, preStart+leftSize+1, preEnd, postorder, index+1, postEnd-1);

    return root;
  }
}

//为什么通过前序遍历和后序遍历结果还原的二叉树可能不唯一呢？
//假设前序遍历的第二个元素是左子树的根节点，但实际上左子树有可能是空指针，那么这个元素就应该是右子树的根节点。由于这里无法确切进行判断，所以导致了最终答案的不唯一。
//二叉树的构造问题一般都是使用「分解问题」的思路：构造整棵树 = 根节点 + 构造左子树 + 构造右子树。








