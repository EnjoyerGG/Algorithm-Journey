// 给定两个升序排序的有序数组A和B，以及一个目标值 x。
// 数组下标从0开始。
// 请你求出满足 A[i]+B[j]=x的数对 (i,j)。
// 数据保证有唯一解。

#include <iostream>
using namespace std;
const int N = 100010;
int n, m, x;
int a[N], b[N];

int main()
{
    scanf("%d%d%d", &n, &m, &x);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    for (int i = 0; i < m; i++)
    {
        scanf("%d", &b[i]);
    }

    for (int i = 0, j = m - 1; i < n; i++)
    {
        while (j >= 0 && a[i] + b[j] > x)
        {
            j--;
        }
        // 如果j>=0且a[i]+b[j]=x，说明找到了满足条件的数对
        if (j >= 0 && a[i] + b[j] == x)
        {
            cout << i << " " << j << endl;
        }
    }
    return 0;
}