// 输入一个n行 m列的整数矩阵，再输入q个操作，每个操作包含五个整数 x1,y1,x2,y2,c，其中 (x1,y1)和 (x2,y2)表示一个子矩阵的左上角坐标和右下角坐标。
// 每个操作都要将选中的子矩阵中的每个元素的值加上c。
// 请你将进行完所有操作后的矩阵输出。

#include <iostream>
using namespace std;
const int N = 1010;
int n, m, q;
int a[N][N], b[N][N];

void insert(int x1, int y1, int x2, int y2, int c)
{
    b[x1][y1] += c;
    b[x2 + 1][y1] -= c;
    b[x1][y2 + 1] -= c;
    b[x2 + 1][y2 + 1] += c;
}

int main()
{
    scanf("%d%d%d", &n, &m, &q);

    // 输入矩阵
    // 从1开始输入，方便后续计算前缀和
    // b数组的下标从1开始
    // a数组的下标从1开始
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            scanf("%d", &a[i][j]);
        }
    }
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            insert(i, j, i, j, a[i][j]);
        }
    }

    // 输入操作
    // 操作包含四个整数x1,y1,x2,y2，表示一个子矩阵的左上角坐标和右下角坐标
    // 对于每个操作输出子矩阵中所有数的和
    // 从1开始输入，方便后续计算前缀和
    while (q--)
    {
        int x1, y1, x2, y2, c;
        cin >> x1 >> y1 >> x2 >> y2 >> c;
        insert(x1, y1, x2, y2, c);
    }

    // 求前缀和
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            b[i][j] += b[i - 1][j] + b[i][j - 1] - b[i - 1][j - 1];
        }
    }

    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            printf("%d ", b[i][j]);
        }
        printf("\n");
    }

    return 0;
}
