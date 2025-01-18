// 假定有一个无限长的数轴，数轴上每个坐标上的数都是0。
// 现在，我们首先进行n次操作，每次操作将某一位置x上的数加c。
// 接下来，进行m次询问，每个询问包含两个整数l和r，你需要求出在区间[l,r]之间的所有数的和。

// 输入格式
// 第一行包含两个整数n和m。
// 接下来n行，每行包含两个整数x和c。
// 再接下来m行，每行包含两个整数l和r。

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
typedef pair<int, int> PII;
const int N = 300010;

int n, m;
int a[N], s[N];

vector<int> alls; // 存储所有待离散化的值
// add增加容器，存入对应下标和增加的值的大小
// query存入需要计算下标区间和的容器
vector<PII> add, query;

// 返回的是输入的坐标的离散化下标
int find(int x)
{
    int l = 0, r = alls.size() - 1;
    // 二分查找
    // 如果alls[mid]>=x，说明x在mid的左边，r=mid
    // 如果alls[mid]<x，说明x在mid的右边，l=mid+1
    while (l < r)
    {
        int mid = (l + r) / 2;
        if (alls[mid] >= x)
            r = mid;
        else
            l = mid + 1;
    }
    return r + 1;
}

int main()
{
    scanf("%d%d", &n, &m);
    for (int i = 0; i < n; i++)
    {
        int x, c;
        scanf("%d%d", &x, &c);
        add.push_back({x, c}); // 存入add容器
        alls.push_back(x);     // 存入数组下标x=add.first
    }

    for (int i = 0; i < m; i++)
    {
        int l, r;
        scanf("%d%d", &l, &r);
        query.push_back({l, r});
        alls.push_back(l);
        alls.push_back(r);
    }

    sort(alls.begin(), alls.end());                           // 排序！！！！
    alls.erase(unique(alls.begin(), alls.end()), alls.end()); // 去重

    // 处理插入
    for (auto item : add)
    {
        int x = find(item.first); // 找到x的映射值，往原数组中加c
        a[x] += item.second;
    }

    // 预处理前缀和
    for (int i = 1; i <= alls.size(); i++)
        s[i] = s[i - 1] + a[i];

    // 处理查询
    for (auto item : query)
    {
        int l = find(item.first), r = find(item.second);
        printf("%d\n", s[r] - s[l - 1]);
    }

    return 0;
}
