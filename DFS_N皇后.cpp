// n−皇后问题是指将n个皇后放在 n×n的国际象棋棋盘上，使得皇后不能相互攻击到，即任意两个皇后都不能处于同一行、同一列或同一斜线上。
// 现在给定整数 n，请你输出所有的满足条件的棋子摆法。

/*
输入样例：
4
输出样例：
.Q..
...Q
Q...
..Q.

..Q.
Q...
...Q
.Q..
*/

#include <iostream>
using namespace std;
const int N = 11;

char q[N][N];
bool dg[N * 2], udg[N * 2], col[N]; // dg表示对角线，udg表示反对角线，col表示列上是否有皇后
int n;

void dfs(int r)
{
    if (r == n)
    { // 棋盘满了，准备输出棋盘
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                cout << q[i][j];
            }
            cout << endl;
        }
        cout << endl;
        return;
    }

    for (int i = 0; i < n; i++)
    { // 第r行，第i列，是否放置皇后
        if (!col[i] && !dg[r + i] && !udg[n - i + r])
        { // 不冲突，放皇后
            q[r][i] = 'Q';
            col[i] = dg[r + i] = udg[n - i + r] = 1; // 状态改变
            dfs(r + 1);                              // 下一行
            col[i] = dg[r + i] = udg[n - i + r] = 0; // 恢复现场
            q[r][i] = '.';
        }
    }
}

int main()
{
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            q[i][j] = '.';
        }
    }
    dfs(0);
    return 0;
}