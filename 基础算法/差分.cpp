// 输入一个长度为n的整数序列。
// 接下来输入m个操作，每个操作包含三个整数l,r,c，表示将序列中[l,r]之间的每个数加上c。
// 请你输出进行完所有操作后的序列。

#include <iostream>
using namespace std;
const int N = 100010;
int n, m;
int a[N], b[N];

void insert(int l, int r, int c)
{
    b[l] += c;
    b[r + 1] -= c;
}

int main()
{
    scanf("%d%d", &n, &m);

    // 输入数组
    for (int i = 1; i <= n; i++)
    {
        scanf("%d", &a[i]);
    }
    // 差分
    for (int i = 1; i <= n; i++)
    {
        insert(i, i, a[i]);
    }

    while (m--)
    {
        int l, r, c;
        scanf("%d%d%d", &l, &r, &c);
        insert(l, r, c);
    }

    for (int i = 1; i <= n; i++)
    {
        // 差分数组求前缀和
        b[i] += b[i - 1];
        printf("%d ", b[i]);
    }

    return 0;
}
