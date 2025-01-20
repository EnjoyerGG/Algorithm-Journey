// 堆是维护一组数中的最大值或最小值的数据结构，可以用数组实现
// 1. 用于插入一个数  heap[++cnt] = x; up(cnt);
// 2. 用于删除最小值  heap[1] = heap[cnt]; cnt--; down(1);
// 3. 求最小值  heap[1];
// 4. 删除任意一个元素  heap[k] = heap[cnt]; cnt--; down(k); up(k);
// 5. 修改任意一个元素的值 heap[k]=x; down(k); up(k);

// 输入一个长度为n的整数数列，从小到大输出前 m小的数。
// 输入样例：
// 5 3
// 4 5 1 3 2
// 输出样例：
// 1 2 3

// 存储形式：
// 第一个元素是最小的，即堆顶元素
// 第二个元素是左儿子, 2x
// 第三个元素是右儿子, 2x+1

#include <iostream>
#include <algorithm>
using namespace std;
const int N = 100010;
int n, m;
int h[N], cnt;

void down(int u)
{
    int t = u;                           // t存储最小的元素
    if (u * 2 <= cnt && h[u * 2] < h[t]) // 左儿子比自己小
    {
        t = u * 2;
    }
    if (u * 2 + 1 <= cnt && h[u * 2 + 1] < h[t]) // 右儿子比自己小
    {
        t = u * 2 + 1;
    }
    if (u != t) // 说明根节点不是最小值
    {
        swap(h[u], h[t]);
        down(t);
    }
}

int main()
{
    scanf("%d%d", &n, &m); // n个数，输出前m小的数

    for (int i = 1; i <= n; i++)
    {
        scanf("%d", &h[i]);
    }

    cnt = n; // 堆中元素个数
    for (int i = n / 2; i; i--)
    {
        down(i);
    }

    while (m--)
    {
        printf("%d ", h[1]); // 输出堆顶元素
        h[1] = h[cnt--];     // 删除堆顶元素
        down(1);             // 重新调整堆
    }
    puts("");

    return 0;
}