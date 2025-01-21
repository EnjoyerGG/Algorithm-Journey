// 广度优先
/*
从起点开始，往前走第一步，记录下所有第一步能走到的点。
然后从所第一步能走到的点开始，往前走第二步，记录下所有第二步能走到的点。
重复下去，直到走到终点。输出步数即可。
*/

/*
题意：
给定一个n×m的二维整数数组，用来表示一个迷宫，数组中只包含0或1；
其中0表示可以走的路，1表示不可通过的墙壁。

最初，有一个人位于左上角 (1,1)处，
已知该人每次可以向上、下、左、右任意一个方向移动一个位置。
请问，该人从左上角移动至右下角(n,m)处，至少需要移动多少次。
数据保证(1,1)处和 (n,m)处的数字为 0，且一定至少存在一条通路。

输入样例：
5 5
0 1 0 0 0
0 1 0 1 0
0 0 0 0 0
0 1 1 1 0
0 0 0 1 0
输出样例：
8
*/

#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
typedef pair<int, int> PII;
const int N = 110;
int g[N][N]; // 存储地图
int f[N][N]; // 存储距离
int n, m;

void bfs(int a, int b) // 广度优先
{
    queue<PII> q;
    q.push({a, b});
    f[0][0] = 0; // 初始点距离为0

    while (!q.empty())
    {
        PII start = q.front(); // 取出队首元素
        q.pop();
        g[start.first][start.second] = 1; // 标记已经走过

        int dx[4] = {0, 1, 0, -1}, dy[4] = {-1, 0, 1, 0}; // 方向数组
        for (int i = 0; i < 4; i++)
        {
            int x = start.first + dx[i];
            int y = start.second + dy[i];
            // 如果还没有走过
            if (g[x][y] == 0)
            {
                g[x][y] = 1;
                f[x][y] = f[start.first][start.second] + 1; // //从当前点走过去，则距离等于当前点的距离+1
                // 这个点放入队列，用来走到和它相邻的点
                q.push({x, y});
            }
        }
    }
    cout << f[n][m];
}

int main()
{
    memset(g, 1, sizeof(g));
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            cin >> g[i][j];
        }
    }
    bfs(1, 1);
}