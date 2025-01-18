// 归并排序，常见的排序算法之一，时间复杂度O(nlogn)
#include <iostream>
using namespace std;
const int N = 100010;
int a[N], tmp[N];

void merge_sort(int q[], int l, int r)
{
    // 递归边界
    if (l >= r)
        return;
    int mid = (l + r) / 2;
    merge_sort(q, l, mid);
    merge_sort(q, mid + 1, r);

    // 合并两个有序数组
    int k = 0, i = l, j = mid + 1;
    while (i <= mid && j <= r)
    {
        if (q[i] <= q[j])
            tmp[k++] = q[i++];
        else
            tmp[k++] = q[j++];
    }
    while (i <= mid)
        tmp[k++] = q[i++];

    while (j <= r)
        tmp[k++] = q[j++];

    // temp数组的元素拷贝到q数组
    for (int i = l, j = 0; i <= r; i++, j++)
    {
        q[i] = tmp[j];
    }
}

int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
        cin >> a[i];
    merge_sort(a, 0, n - 1);
    for (int i = 0; i < n; i++)
        cout << a[i] << " ";
    return 0;
}