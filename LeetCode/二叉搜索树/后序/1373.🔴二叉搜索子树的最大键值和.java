//题目：给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
//二叉搜索树的定义如下：
//任意节点的左子树中的键值都 小于 此节点的键值。
//任意节点的右子树中的键值都 大于 此节点的键值。
//任意节点的左子树和右子树都是二叉搜索树。

/*
输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
输出：20
解释：键值为 3 的子树是和最大的二叉搜索树。

输入：root = [4,3,null,1,2]
输出：2
解释：键值为 2 的单节点子树是和最大的二叉搜索树。

输入：root = [-4,-2,-5]
输出：0
解释：所有节点键值都为负数，和最大的二叉搜索树为空。

输入：root = [2,1,3]
输出：6

输入：root = [5,4,8,3,null,6,3]
输出：7
*/

//关于二叉树前后遍历：
//前序位置的代码只能从函数参数中获取父节点传递来的数据，而后序位置的代码不仅可以获取参数数据，还可以获取到子树通过函数返回值传递回来的数据。
//换句话说，一旦你发现题目和子树有关，那大概率要给函数设置合理的定义和返回值，在后序位置写代码了。

class Solution{
  //记录BST最大节点之和
  int maxSum = 0;

  public int maxSumBST(TreeNode root){
    findMaxMinSum(root);
    return maxSum;
  }

  //计算以root为根的二叉树的最大值，最小值，节点和
  int[] findMaxMinSum(TreeNode root){
    //base case
    if(root==null){
      return new int[]{
        1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0
      };
    }

    //递归计算左右子树
    int[] left = findMaxMinSum(root.left);
    int[] right = findMaxMinSum(root.right);

    //***后序遍历位置***
    //通过left和right推导返回值
    //并且正确更新maxSum变量
    int[] res = new int[4];
    //这个if在判断以root为根的二叉树是不是BST
    if(left[0]==1 && right[0]==1 && root.val>left[2] && root.val<right[1]){
      //以root为根的二叉树是BST
      res[0] = 1;
      //计算以root为根的这棵BST的最小值
      res[1] = Math.min(left[1], root.val);
      //计算以 root 为根的这棵 BST 的最大值
      res[2] = Math.max(right[2], root.val);
      //计算以 root 为根的这棵 BST 所有节点之和
      res[3] = left[3] + right[3] + root.val;
      //更新全局变量
      maxSum = Math.max(maxSum, res[3]);
    }else{
      //以root为根的二叉树不是BST
      res[0] = 0;
      //其他的值都没必要计算了，因为用不到
    }
    //****************

    return res;
  }
}










    

























  
