//题目：给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
//创建一个根节点，其值为 nums 中的最大值。
//递归地在最大值 左边 的 子数组前缀上 构建左子树。
//递归地在最大值 右边 的 子数组后缀上 构建右子树。
//返回 nums 构建的 最大二叉树。

/*
输入：nums = [3,2,1,6,0,5]
输出：[6,3,5,null,2,0,null,null,1]
解释：递归调用如下所示：
- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
        - 空数组，无子节点。
        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
            - 空数组，无子节点。
            - 只有一个元素，所以子节点是一个值为 1 的节点。
    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
        - 只有一个元素，所以子节点是一个值为 0 的节点。
        - 空数组，无子节点。

输入：nums = [3,2,1]
输出：[3,null,2,null,1]
*/

//每个二叉树节点都可以认为是一棵子树的根节点，对于根节点，首先要做的当然是把想办法把自己先构造出来，然后想办法构造自己的左右子树。
//所以，我们要遍历数组把找到最大值 maxVal，从而把根节点 root 做出来，然后对 maxVal 左边的数组和右边的数组进行递归构建，作为 root 的左右子树。

class Solution{
  public TreeNode constructMaximumBinaryTree(int[] nums){
    return build(nums, 0, nums.length - 1);
  }

  //定义，将nums[low...high]构造成符合条件的树，返回根节点
  TreeNode build(int[] nums, int low, int high){
    if(low > high){
      return null;
    }

    //找到数组中的最大值和对于的索引
    int index = -1;
    int maxval = Integer.MIN_VALUE;
    for(int i=low; i<=high; i++){
      if(maxval<nums[i]){
        index = i;
        maxval = nums[i];
      }
    }

    //先构造根节点
    TreeNode root = new TreeNode(maxval);
    //递归调用构造左右子树
    root.left = build(nums, low, index-1);
    root.right = build(nums, index+1, high);

    return root;
  }
}



