// 题目：
/*
在一个 3×3
 的网格中，1∼8
 这 8
 个数字和一个 x 恰好不重不漏地分布在这 3×3
 的网格中。

例如：

1 2 3
x 4 6
7 5 8
在游戏过程中，可以把 x 与其上、下、左、右四个方向之一的数字交换（如果存在）。

我们的目的是通过交换，使得网格变为如下排列（称为正确排列）：

1 2 3
4 5 6
7 8 x
例如，示例中图形就可以通过让 x 先后与右、下、右三个方向的数字交换成功得到正确排列。

交换过程如下：

1 2 3   1 2 3   1 2 3   1 2 3
x 4 6   4 x 6   4 5 6   4 5 6
7 5 8   7 5 8   7 x 8   7 8 x
现在，给你一个初始网格，请你求出得到正确排列至少需要进行多少次交换。

*******
输入样例：
2 3 4 1 5 x 7 6 8
输出样例
19
*******
*/

#include <iostream>
#include <queue>
#include <algorithm>
#include <unordered_map>

using namespace std;

int bfs(string start)
{
    // 定义结束目标状态
    string end = "12345678x";

    // 定义队列和dist数组
    queue<string> q;              // 直接存转化后的字符串
    unordered_map<string, int> d; // 将字符串和数字联系，字符串表示状态，数字表示距离

    // 初始化
    q.push(start); // 存入初始的字符串
    d[start] = 0;

    // 转移方式, 4个方向
    int dx[4] = {1, -1, 0, 0}, dy[4] = {0, 0, 1, -1};

    while (q.size())
    {
        auto t = q.front();
        q.pop();
        int distance = d[t]; // 当前状态的距离，如果是最终状态则返回距离
        if (t == end)
            return distance;

        // 查询x在字符串中的下标，然后转换为在矩阵中的坐标
        int k = t.find('x');
        int x = k / 3, y = k % 3;

        for (int i = 0; i < 4; i++)
        {
            // 求转移后x的坐标
            int a = x + dx[i], b = y + dy[i];
            // 当前坐标没有越界
            if (a >= 0 && a < 3 && b >= 0 && b < 3)
            {
                // 转移x
                swap(t[k], t[a * 3 + b]);
                // 如果当前状态是第一次遍历，记录距离，入队
                if (!d.count(t))
                {
                    d[t] = distance + 1;
                    q.push(t);
                }
                // 还原状态，为下一种转换情况做准备
                swap(t[k], t[a * 3 + b]);
            }
        }
    }
    return -1; // 无法转换到目标状态，返回-1
}

int main()
{
    string c, start;

    for (int i = 0; i < 9; i++)
    {
        cin >> c;
        start += c;
    }

    cout << bfs(start) << endl;
    return 0;
}