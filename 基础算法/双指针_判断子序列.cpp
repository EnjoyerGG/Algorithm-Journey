// 给定一个长度为n的整数序列 a1,a2,…,an以及一个长度为m的整数序列 b1,b2,…,bm。
// 请你判断a序列是否为 b序列的子序列。
// 如果a序列是b序列的子序列，输出一行Yes。否则，输出No。

#include <iostream>
#include <cstring>
using namespace std;
const int N = 100010;

int n, m;
int a[N], b[N];

int main()
{
    scanf("%d%d", &n, &m);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    for (int i = 0; i < m; i++)
    {
        scanf("%d", &b[i]);
    }

    int i = 0, j = 0;
    while (i < n && j < m)
    {
        if (a[i] == b[j])
            i++;
        j++;
    }

    if (i == n)
    {
        printf("Yes\n");
    }
    else
    {
        printf("No\n");
    }

    return 0;
}
