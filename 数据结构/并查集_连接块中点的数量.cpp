// 无向图
// 当在两个集合之间连一条边的时候，就是在合并两个集合

// 给定一个包含n个点（编号为1∼n）的无向图，初始时图中没有边。
// 现在要进行m个操作，操作共有三种：
// C a b，在点a和点b之间连一条边，a和b可能相等；
// Q1 a b，询问点a和点b是否在同一个连通块中，a和b可能相等；
// Q2 a，询问点a所在连通块中点的数。

// 输入样例：
// 5 5
// C 1 2
// Q1 1 2
// Q2 1
// C 2 5
// Q2 5
// 输出样例：
// Yes
// 2
// 3

#include <iostream>
using namespace std;
const int N = 100010;

int n, m;
int p[N], cnt[N]; // cnt[x]表示x所在集合的点的数量

int find(int x)
{
    if (p[x] != x)
    {
        p[x] = find(p[x]);
    }
    return p[x];
}

int main()
{
    cin >> n >> m;

    // 初始化
    for (int i = 1; i <= n; i++)
    {
        p[i] = i;   // 初始化，每个点各自为一个集合
        cnt[i] = 1; // 每个集合中只有一个点
    }

    while (m--)
    {
        string op;
        int a, b;
        cin >> op;

        if (op == "C")
        {
            cin >> a >> b;
            a = find(a), b = find(b); // 找到a和b所在集合的根节点
            if (a != b)
            {
                p[a] = b;         // 合并a和b所在的集合
                cnt[b] += cnt[a]; // 更新b所在集合的点的数量
            }
        }
        else if (op == "Q1")
        {
            // 查询是否连通
            cin >> a >> b;
            if (find(a) == find(b))
            {
                puts("Yes");
            }
            else
            {
                puts("No");
            }
        }
        else
        {
            cin >> a;
            cout << cnt[find(a)] << endl;
        }
    }
    return 0;
}