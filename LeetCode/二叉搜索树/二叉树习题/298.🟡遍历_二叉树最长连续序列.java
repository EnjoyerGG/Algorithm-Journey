//题目：给你一棵指定的二叉树的根节点 root ，请你计算其中 最长连续序列路径 的长度。
//最长连续序列路径 是依次递增 1 的路径。该路径，可以是从某个初始节点到树中任意节点，通过「父 - 子」关系连接而产生的任意路径。且必须从父节点到子节点，反过来是不可以的。

/*
输入：root = [1,null,3,2,4,null,null,null,5]
输出：3
解释：当中，最长连续序列是 3-4-5 ，所以返回结果为 3 。

输入：root = [2,null,3,2,null,1]
输出：2
解释：当中，最长连续序列是 2-3 。注意，不是 3-2-1，所以返回 2 。
*/

class Solution{
  public int longestConsecutive(TreeNode root){
    traverse(root, 1, Integer.MIN_VALUE);
    return maxLen;
  }

  int maxLen = 0;

  //遍历二叉树，根据父节点的值判断连续的序列长度
  void traverse(TreeNode root, int len, int parentVal){
    if(root==null) return;
    
    if(parentVal + 1 == root.val){
      len++;
    }else{
      len = 1;
    }

    //更新最长连续序列的长度
    maxLen = Math.max(maxLen, len);
    //遍历框架
    traverse(root.left, len, root.val);
    traverse(root.right, len, root.val);
  }
}



















      
    }
