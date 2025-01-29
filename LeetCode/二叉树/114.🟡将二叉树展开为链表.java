//题目：给你二叉树的根结点 root ，请你将它展开为一个单链表：
//展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
//展开后的单链表应该与二叉树 先序遍历 顺序相同。

/*
输入：root = [1,2,5,3,4,null,6]
输出：[1,null,2,null,3,null,4,null,5,null,6]

输入：root = []
输出：[]

输入：root = [0]
输出：[0]

进阶：
你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
*/

//对于一个节点 x，可以执行以下流程：
//1、先利用 flatten(x.left) 和 flatten(x.right) 将 x 的左右子树拉平。
//2、将 x 的右子树接到左子树下方，然后将整个左子树作为右子树。

class Solution{
  public void flatten(TreeNode root){
    if(root==null) return;

    //利用定义，把左右子树拉平
    flatten(root.left);
    flatten(root.right);

    //后续遍历
    //1.左右子树已经被拉平为一条链表
    TreeNode left = root.left;
    TreeNode right = root.right;

    //2.将左子树作为右子树
    root.left = null;
    root.right = left;

    //3.将原先的右子树接到当前右子树的末端
    TreeNode p = root;
    while(p.right!=null){
      p = p.right;
    }
    p.right = right;
  }
}


//对于两种思维方式，无论使用哪种思维模式，你都需要思考：
//如果单独抽出一个二叉树节点，它需要做什么事情？需要在什么时候（前/中/后序位置）做？其他的节点不用你操心，递归函数会帮你在所有节点上执行相同的操作。
