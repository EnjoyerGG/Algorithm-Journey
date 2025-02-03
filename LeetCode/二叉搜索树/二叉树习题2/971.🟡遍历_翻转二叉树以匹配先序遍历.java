//题目：给你一棵二叉树的根节点 root ，树中有 n 个节点，每个节点都有一个不同于其他节点且处于 1 到 n 之间的值。
//另给你一个由 n 个值组成的行程序列 voyage ，表示 预期 的二叉树 先序遍历 结果。
//通过交换节点的左右子树，可以 翻转 该二叉树中的任意节点。
//请翻转 最少 的树中节点，使二叉树的 先序遍历 与预期的遍历行程 voyage 相匹配 。
//如果可以，则返回 翻转的 所有节点的值的列表。你可以按任何顺序返回答案。如果不能，则返回列表 [-1]。

/*
输入：root = [1,2], voyage = [2,1]
输出：[-1]
解释：翻转节点无法令先序遍历匹配预期行程。

输入：root = [1,2,3], voyage = [1,3,2]
输出：[1]
解释：交换节点 2 和 3 来翻转节点 1 ，先序遍历可以匹配预期行程。

输入：root = [1,2,3], voyage = [1,2,3]
输出：[]
解释：先序遍历已经匹配预期行程，所以不需要翻转节点。
*/

class Solution {
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;
        // 遍历的过程中尝试进行反转
        traverse(root);

        if (canFlip) {
            return res;
        }
        return Arrays.asList(-1);
    }


    List<Integer> res = new LinkedList<>();
    int i = 0;
    int[] voyage;
    boolean canFlip = true;

    void traverse(TreeNode root) {
        if (root == null || !canFlip) {
            return;
        }
        if (root.val != voyage[i++]) {
            // 节点的 val 对不上，必然无解
            canFlip = false;
            return;
        }
        if (root.left != null && root.left.val != voyage[i]) {
            // 前序遍历结果不对，尝试翻转左右子树
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            // 记录翻转节点
            res.add(root.val);
        }

        traverse(root.left);
        traverse(root.right);
    }
}
