//题目：给你一些区域列表 regions ，每个列表的第一个区域都包含这个列表内所有其他区域。
//很自然地，如果区域 X 包含区域 Y ，那么区域 X  比区域 Y 大。
//给定两个区域 region1 和 region2 ，找到同时包含这两个区域的 最小 区域。
//如果区域列表中 r1 包含 r2 和 r3 ，那么数据保证 r2 不会包含 r3 。
//数据同样保证最小公共区域一定存在。

/*
输入：
regions = [["Earth","North America","South America"],
["North America","United States","Canada"],
["United States","New York","Boston"],
["Canada","Ontario","Quebec"],
["South America","Brazil"]],
region1 = "Quebec",
region2 = "New York"
输出："North America"
*/

class Solution {
    HashMap<String, String> tree = new HashMap<>();

    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        // 构建反向链接的多叉树，key 为子节点，value 为父节点
        for (List<String> list : regions) {
            String parent = list.get(0);
            for (String child : list.subList(1, list.size())) {
                tree.put(child, parent);
            }
        }

        // 转化为 1650. 二叉树的最近公共祖先 III 的解法
        return lowestCommonAncestor(region1, region2);
    }

    String lowestCommonAncestor(String p, String q) {
        // 施展链表双指针技巧
        String a = p, b = q;
        while (!a.equals(b)) {
            // a 走一步，如果走到根节点，转到 q 节点
            a = tree.getOrDefault(a, q);
            // b 走一步，如果走到根节点，转到 p 节点
            b = tree.getOrDefault(b, p);
        }
        return a;
    }
}
