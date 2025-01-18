// 给定一个按照升序排列的长度为n的整数数组，以及q个查询。
// 对于每个查询，返回一个元素k的起始位置和终止位置（位置从0开始计数）。
// 如果数组中不存在该元素，则返回 -1 -1。

#include <iostream>
using namespace std;
const int N = 100010;
int n, m;
int q[N];

int main()
{
    scanf("%d%d", &n, &m);
    // 输入数组
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &q[i]);
    }

    while (m--)
    {
        // 输入查询元素
        int x;
        scanf("%d", &x);

        // 二分查找（模板）
        int l = 0, r = n - 1;
        while (l < r)
        {
            int mid = (l + r) / 2;
            if (q[mid] >= x)
                r = mid; // 缩小右边界
            else
                l = mid + 1; // 缩小左边界
        }

        // 不存在元素x
        if (q[l] != x)
        {
            cout << "-1 -1" << endl;
        }
        // 存在元素x
        else
        {
            // 输出元素x的起始位置
            cout << l << ' ';

            int l = 0, r = n - 1;
            while (l < r)
            {
                int mid = (l + r + 1) / 2;
                if (q[mid] <= x)
                    l = mid; // 缩小左边界
                else
                    r = mid - 1; // 缩小右边界
            }
            // 输出元素x的终止位置
            cout << l << endl;
        }
    }
    return 0;
}

// 每次时间复杂度为O(logn)，总时间复杂度为O(qlogn)，q为查询次数。