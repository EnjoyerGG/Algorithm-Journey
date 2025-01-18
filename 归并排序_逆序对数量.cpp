// 给定一个长度为n的整数数列，请你计算数列中的逆序对的数量。
// 逆序对的定义如下：对于数列的第i个和第j个元素，如果满足i<j且 a[i]>a[j]，则其为一个逆序对；否则不是。
#include <iostream>
using namespace std;
typedef long long LL;
const int N = 100010;
int a[N], tmp[N];

LL merge_sort(int q[], int l, int r)
{
    if (l >= r)
        return 0;
    int mid = (l + r) / 2;
    // 递归求解左右两部分的逆序对数量
    LL res = merge_sort(q, l, mid) + merge_sort(q, mid + 1, r);

    int k = 0, i = l, j = mid + 1;
    // 合并两个有序数组
    while (i <= mid && j <= r)
    {
        if (q[i] <= q[j])
            tmp[k++] = q[i++];
        else
        {
            tmp[k++] = q[j++];
            res += mid - i + 1;
        }
    }
    // 将剩余元素拷贝到tmp数组
    while (i <= mid)
        tmp[k++] = q[i++];
    while (j <= r)
        tmp[k++] = q[j++];

    // 将tmp数组拷贝到q数组
    for (int i = l, j = 0; i <= r; i++, j++)
        q[i] = tmp[j];

    return res;
}

int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    cout << merge_sort(a, 0, n - 1) << endl;
    return 0;
}