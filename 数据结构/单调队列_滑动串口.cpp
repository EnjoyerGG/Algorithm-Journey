// 有一个大小为 k的滑动窗口，它从数组的最左边移动到最右边。
// 你只能在窗口中看到k个数字。
// 每次滑动窗口向右移动一个位置。
// 确定滑动窗口位于每个位置时，窗口中的最大值和最小值。

// 输入样例：
// 8 3
// 1 3 -1 -3 5 3 6 7
// 输出样例：
//-1 -3 -3 -3 3 3
// 3 3 5 5 6 7

#include <iostream>
using namespace std;
const int N = 1000010;
int a[N], q[N];

int main()
{
    int n, k;
    scanf("%d%d", &n, &k);
    for (int i = 0; i < n; i++)
        scanf("%d", &a[i]);

    int hh = 0, tt = -1;
    for (int i = 0; i < n; i++)
    {
        // 如果队列不为空，且队头元素已经滑出窗口，那么队头元素出队
        if (hh <= tt && i - k + 1 > q[hh])
            hh++;

        // 队列不为空，且当前数字比队尾元素大，那么队尾元素出队
        // 保证队列里的元素是单调递增的
        while (hh <= tt && a[q[tt]] >= a[i])
            tt--;
        q[++tt] = i;

        // 输出结果
        // i是从0开始的，所以i >= k - 1
        if (i >= k - 1)
            printf("%d ", a[q[hh]]);
    }

    puts("");

    hh = 0, tt = -1;
    for (int i = 0; i < n; i++)
    {
        if (hh <= tt && i - k + 1 > q[hh])
            hh++;

        while (hh <= tt && a[q[tt]] <= a[i])
            tt--;
        q[++tt] = i;

        if (i >= k - 1)
            printf("%d ", a[q[hh]]);
    }

    puts("");

    return 0;
}
