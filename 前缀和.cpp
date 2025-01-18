// 输入一个长度为n的整数序列。
// 接下来再输入m个询问，每个询问输入一对l,r。
// 对于每个询问，输出原序列中从第l个数到第r个数的和。

#include <iostream>
using namespace std;
const int N = 100010;
int n, m;
int a[N], s[N];

int main()
{
    cin >> n >> m;
    // 输入数组
    for (int i = 1; i <= n; i++)
    {
        cin >> a[i];
    }

    // 求前缀和，初始化s[0] = 0
    for (int i = 1; i <= n; i++)
    {
        s[i] = s[i - 1] + a[i];
    }

    while (m--)
    {
        int l, r;
        cin >> l >> r;
        cout << s[r] - s[l - 1] << endl; // 输出区间和
    }

    return 0;
}