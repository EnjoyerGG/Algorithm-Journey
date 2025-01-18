// 排序
//  最常用的排序方式之一，时间复杂度为O(nlogn)，空间复杂度为O(logn)
#include <iostream>
using namespace std;
const int N = 100010;
int q[N];

void quick_sort(int q[], int l, int r)
{
    // 如果l和r交叉，则说明数列已经被分割成为单元素数列，排序完成
    if (l >= r)
        return;
    // x为中间值，i为左指针，j为右指针
    int x = q[(l + r) / 2];
    int i = l - 1;
    int j = r + 1;

    while (i < j)
    {
        do
            i++;
        while (q[i] < x);
        do
            j--;
        while (q[j] > x);
        // 如果指针未交叉，则执行交换操作
        if (i < j)
            swap(q[i], q[j]);
    }

    quick_sort(q, l, j);
    quick_sort(q, j + 1, r);
}

int main()
{
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &q[i]);
    }
    quick_sort(q, 0, n - 1);

    for (int i = 0; i < n; i++)
    {
        printf("%d ", q[i]);
    }
    return 0;
}
