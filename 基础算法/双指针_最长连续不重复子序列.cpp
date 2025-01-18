// 给定一个长度为 n的整数序列，请找出最长的不包含重复的数的连续区间，输出它的长度。

#include <iostream>
using namespace std;
const int N = 100010;
int n;
// q数组存储输入的数组
// s数组存储每个数出现的次数
int q[N], s[N];

int main()
{
    cin >> n;
    // 输入数组
    for (int i = 0; i < n; i++)
    {
        cin >> q[i];
    }

    int res = 0;
    for (int i = 0, j = 0; i < n; i++)
    {
        // s数组记录每个数出现的次数
        // 如果s[q[i]] > 1，说明q[i]在[j,i]区间内重复出现
        // 此时需要移动j指针，直到s[q[i]] <= 1
        s[q[i]]++; // 向右扩展区间右端点

        // 扩展后元素q[i]可能重复，下面的while循环就是在缩小区间左端点来去重
        while (j < i && s[q[i]] > 1)
        {
            s[q[j++]]--;
        }

        // i - j + 1表示当前不重复子序列的长度
        // res记录最长的不重复子序列的长度
        res = max(res, i - j + 1);
    }
    cout << res << endl;
    return 0;
}
