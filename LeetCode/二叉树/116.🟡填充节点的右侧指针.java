//题目：给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
//填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//初始状态下，所有 next 指针都被设置为 NULL。

/*
输入：root = [1,2,3,4,5,6,7]
输出：[1,#,2,3,#,4,5,6,7,#]
解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。

输入：root = []
输出：[]

进阶：
你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
*/

//传统的 traverse 函数是遍历二叉树的所有节点，但现在我们想遍历的其实是两个相邻节点之间的「空隙」。
//因此我们将其抽象为一颗三叉树，，三叉树上的每个节点就是原先二叉树的两个相邻节点。
//运用第一种思路解决问题，第二种思路不太行。
class Solution{
  public Node connect(Node root){
    if(root==null) return null;
    //遍历三叉树，连接相邻节点
    traverse(root.left, root.right);
    return root;
  }

  //三叉树遍历框架
  void traverse(Node node1, Node node2){
    if(node1==null || node2==null){ return; }
    
    //前序位置
    //将传入的两个节点穿起来
    node1.next = node2;

    //连接相同父节点的两个子节点
    traverse(node1.left, node1.right);
    traverse(node2.left, node2.right);
    //链接跨越父节点的两个子节点
    traverse(node1.right, node2.left);
  }
}














