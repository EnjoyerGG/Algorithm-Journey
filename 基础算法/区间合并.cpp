// 给定n个区间 [li,ri]，要求合并所有有交集的区间。
// 注意如果在端点处相交，也算有交集。
// 输出合并完成后的区间个数。
// 例如：[1,3]和[2,6]可以合并为一个区间[1,6]。
// 输入格式
// 第一行包含整数n。
// 接下来n行，每行包含两个整数l和r。

// 输出格式
// 共一行，包含一个整数，表示合并区间完成后的区间个数。

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
typedef pair<int, int> PII; // 用于存储区间

void merge(vector<PII> &segs)
{
    vector<PII> res;
    sort(segs.begin(), segs.end()); // 按区间左端点排序
    int start = -2e9, end = -2e9;
    // 遍历所有区间
    for (auto seg : segs)
    {
        // 无交集
        if (end < seg.first)
        { // 如果当前区间的左端点大于上一个区间的右端点，说明两个区间不相交
            if (start != -2e9)
                // 如果start不等于-2e9，说明上一个区间不为空，将上一个区间加入res
                res.push_back({start, end});
            // 更新start和end
            start = seg.first, end = seg.second;
        }
        // 有交集
        else
        {
            // 如果当前区间的左端点小于等于上一个区间的右端点，说明两个区间相交
            // 更新end，取并集
            end = max(end, seg.second);
        }
    }

    // 将最后一个区间加入res
    // 如果start等于-2e9，说明res为空
    if (start != -2e9)
        res.push_back({start, end});
    // 更新segs
    segs = res;
}

int main()
{
    int n;
    scanf("%d", &n);

    vector<PII> segs;
    // 输入区间
    for (int i = 0; i < n; i++)
    {
        int l, r;
        scanf("%d%d", &l, &r);
        segs.push_back({l, r});
    }

    merge(segs);
    cout << segs.size() << endl;
    return 0;
}
