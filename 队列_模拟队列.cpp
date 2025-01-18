// 实现一个队列，队列初始为空，支持四种操作：
// push x – 向队尾插入一个数 x；
// pop – 从队头弹出一个数；
// empty – 判断队列是否为空；
// query – 查询队头元素。

#include <iostream>
using namespace std;
const int N = 100010;

int m;
int q[N], hh, tt = -1; // hh是队头，tt是队尾

int main()
{
    cin >> m;

    while (m--)
    {
        string op;
        int x;

        cin >> op;
        if (op == "push")
        {
            // 队尾入队
            cin >> x;
            q[++tt] = x;
        }
        else if (op == "pop")
        {
            // 队头出队
            hh++;
        }
        else if (op == "empty")
        {
            // 判断队列是否为空
            // 队列为空的条件是队头大于队尾
            // 因为队头大于队尾的时候，说明队列中没有元素
            // 注意这里是小于等于
            cout << (hh <= tt ? "NO" : "YES") << endl;
        }
        else // query
        {
            cout << q[hh] << endl;
        }
    }
    return 0;
}
