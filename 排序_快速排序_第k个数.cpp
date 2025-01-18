// 给定一个长度为n的整数数列，以及一个整数k，请用快速选择算法求出数列从小到大排序后的第k个数。
#include <iostream>
using namespace std;
const int N = 100010;
int q[N];

int quick_sort(int q[], int l, int r, int k)
{
    if (l >= r)
        return q[l];

    int x = q[(l + r) / 2];
    int i = l - 1;
    int j = r + 1;

    // 两个指针相遇时退出
    while (i < j)
    {
        // 从左往右找到第一个大于等于x的数
        do
            i++;
        while (q[i] < x);
        // 从右往左找到第一个小于等于x的数
        do
            j--;
        while (q[j] > x);
        // 交换两个数
        if (i < j)
            swap(q[i], q[j]);
    }

    // [l, j]区间的长度为j-l+1
    if (j - l + 1 >= k)
        return quick_sort(q, l, j, k);
    // [l, j]区间的长度为j-l+1，所以第k个数在右区间
    else
        return quick_sort(q, j + 1, r, k - (j - l + 1));
}

int main()
{
    int n, k;
    scanf("%d%d", &n, &k);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &q[i]);
    }
    printf("%d", quick_sort(q, 0, n - 1, k));
    return 0;
}
