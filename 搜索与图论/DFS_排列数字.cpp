// 给定一个整数n，将数字1∼n排成一排，将会有很多种排列方法。
// 现在，请你按照字典序将所有的排列方法输出。

/*
输入样例：
3
输出样例：
1 2 3
1 3 2
2 1 3
2 3 1
3 1 2
3 2 1
*/

#include <iostream>
using namespace std;
const int N = 10;
int path[N];  // 存储路径
int state[N]; // 储存状态，数字是否被用过
int n;

void dfs(int u)
{
    if (u > n)
    { // 数字填完了，准备输出
        for (int i = 1; i <= n; i++)
        {
            cout << path[i] << " ";
        }
        cout << endl;
    }

    for (int i = 1; i <= n; i++)
    {
        if (!state[i])
        {
            path[u] = i;  // 放入空位
            state[i] = 1; // 数字被使用，修改状态
            dfs(u + 1);   // 填下一位
            state[i] = 0; // 回溯，取出i
        }
    }
}

int main()
{
    cin >> n;
    dfs(1);
    return 0;
}
