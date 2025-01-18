// 给定一个长度为N的整数数列，输出每个数左边第一个比它小的数，如果不存在则输出−1。
// 输入样例
// 5
// 3 4 2 7 5
// 输出样例：
//-1 3 -1 2 2

#include <iostream>
using namespace std;
const int N = 100010;
int stk[N], tt;

int main()
{
    int n;
    cin >> n;
    while (n--)
    {
        int x;
        scanf("%d", &x);
        // 如果栈不为空，且栈顶元素大于等于x，那么栈顶元素就是x的前驱
        while (tt && stk[tt] >= x)
            tt--;
        if (!tt)
        {
            cout << -1 << ' ';
        }
        else
        {
            cout << stk[tt] << ' ';
        }
        stk[++tt] = x;
    }
    return 0;
}
